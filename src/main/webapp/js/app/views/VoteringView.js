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
            'click .voteringListItem': 'selected'
        },
        selected: function (e) {
            this.$el.find(".voteringListItem").removeClass("selected");
            $(e.currentTarget).addClass("selected");
            this.updateVotering();
        },
        updateVotering: function () {
            var self = this;
            if (this.model.get('voteringSummaryList').length === 0) {
                this.$el.find('.voteringDescription').empty().append("Ingen votering i denne saken")
                return;
            }
            var voteringIdx = this.$el.find(".voteringListItem.selected").data('id');
            var model = new Backbone.Model(this.model.get('voteringSummaryList')[voteringIdx]);

            this.$el.find('.voteringDescription').empty().append(model.get('description'))
            new VoteView({el: ".voteringContainer", model: model}).render();

            var perPartyModel = new Backbone.Model();
            perPartyModel.url = "rest/votering/" + model.get('voteringId') + "/partysummary"
            this.$el.find(".voteringPerPartyContainer").empty();
            
            perPartyModel.fetch({
                success: function() {
                    new VotePerPartyView({el: ".voteringPerPartyContainer", model: perPartyModel}).render();
                }
            })
        },
        template: _.template(tmp)
    });

    return View;

});