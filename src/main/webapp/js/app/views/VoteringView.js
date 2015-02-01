define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'views/VoteView',
    'views/VotePerPartyView',
    'views/VoteTableRowView',
    'text!templates/VoteringView.html',
    'text!templates/VoteringTable.html'
], function ($, _, Backbone, Marionette, VoteView, VotePerPartyView, VoteTableRowView, tmp, tableTmp) {

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
            
            var selectedDetail = self.$el.find('.voteringDetailItem.selected');
            var detailType = selectedDetail.attr('id');
            var perPartyModel = new Backbone.Collection();

            if (detailType === "partySelector") {
                perPartyModel.url = "rest/votering/" + this.currentModel.get('voteringId') + "/partySummary"
                this.perPartyView.title = "Votering per parti"
            } else if (detailType === "genderSelector") {
                perPartyModel.url = "rest/votering/" + this.currentModel.get('voteringId') + "/genderSummary"
                this.perPartyView.title = "Votering per kjønn"
            } else {
                this.perPartyView.title = "Votering per fylke"
                perPartyModel.url = "rest/votering/" + this.currentModel.get('voteringId') + "/fylkeSummary"
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
            this.updateTable();
        },
        updateTable: function() {
            
            var collection = new Backbone.Collection();
            collection.url = "rest/votering/" + this.currentModel.get('voteringId');
            collection.fetch({
                success: function() {
                    new Marionette.CompositeView({
                        collection: collection, 
                        el: ".voteringsTable", 
                        childView: VoteTableRowView,
                        template: _.template(tableTmp),
                        childViewContainer: '.tableBody'
                    }).render()
                }
            });
        },
        template: _.template(tmp)
    });

    return View;

});