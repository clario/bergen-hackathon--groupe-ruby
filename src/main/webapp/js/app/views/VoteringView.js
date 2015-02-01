define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'views/VoteView',
    'text!templates/VoteringView.html'
], function ($, _, Backbone, Marionette, VoteView, tmp) {

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
            if (this.model.get('voteringSummaryList').length === 0) {
                this.$el.find('.voteringDescription').empty().append("Ingen votering i denne saken")
                return;
            }
            var voteringIdx = this.$el.find(".voteringListItem.selected").data('id');
            var model = new Backbone.Model(this.model.get('voteringSummaryList')[voteringIdx]);

            this.$el.find('.voteringDescription').empty().append(model.get('description'))
            new VoteView({el: ".voteringContainer", model: model}).render();
        },
        template: _.template(tmp)
    });

    return View;

});