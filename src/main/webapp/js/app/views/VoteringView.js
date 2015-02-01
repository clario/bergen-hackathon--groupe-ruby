define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'views/VoteView',
    'views/VotePerPartyView',
    'text!templates/VoteringView.html'
], function ($, _, Backbone, Marionette, VoteView, VotePerPartyView, tmp) {

    var View = Marionette.ItemView.extend({
        onRender: function () {
            this.updateVotering();
        },
        events: {
            'click .voteringListItem': 'selected',
            'click .voteringDetailItem': 'selectedDetail'
        },
        selected: function (e) {
            this.$el.find(".voteringListItem").removeClass("selected");
            $(e.currentTarget).addClass("selected");
            this.updateVotering();
        },
        selectedDetail: function (e) {
            this.$el.find(".voteringDetailItem").removeClass("selected");
            $(e.currentTarget).addClass("selected");
            this.updateDetail();
        },
        updateDetail: function () {
            var self = this;
            if (!this.perPartyView) {
                this.perPartyView = new VotePerPartyView({el: ".voteringPerPartyContainer"});
            }
            var detailType = "party";
            var perPartyModel = new Backbone.Collection();

            if (detailType === "party") {
                perPartyModel.url = "rest/votering/" + this.currentModel.get('voteringId') + "/partySummary"
                this.perPartyView.title = "Votering per parti"
            } else {
                this.perPartyView.title = "Votering per kjønn"
                perPartyModel.url = "rest/votering/" + this.currentModel.get('voteringId') + "/gendersummary"
            }

//            this.$el.find(".voteringPerPartyContainer").empty();

            perPartyModel.fetch({
                success: function () {
                    self.perPartyView.collection = perPartyModel;
                    self.perPartyView.render();
                }
            });
        },
        updateVotering: function () {
            var self = this;
            if (this.model.get('voteringSummaryList').length === 0) {
                this.$el.find('.voteringDescription').empty().append("Ingen votering i denne saken")
                return;
            }
            var voteringIdx = this.$el.find(".voteringListItem.selected").data('id');
            this.currentModel = new Backbone.Model(this.model.get('voteringSummaryList')[voteringIdx]);

            this.$el.find('.voteringDescription').empty().append(this.currentModel.get('description'))
            new VoteView({el: ".voteringContainer", model: this.currentModel}).render();

            this.updateDetail();
        },
        template: _.template(tmp)
    });

    return View;

});