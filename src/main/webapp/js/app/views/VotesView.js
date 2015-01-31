define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'views/VoteView',
    'text!templates/VotesView.html'
], function ($, _, Backbone, Marionette, VoteView, tmp) {

    var View = Backbone.View.extend({
        initialize: function () {
            var self = this;
            this.emneId = "";
            this.collection = new Backbone.Collection();
            this.collection.url = "rest/votes"
            this.collection.reset([{voteringId: 1499}, {voteringId: 1498}]);
            this.render();
        },
        events: {
            "click .voteListItem": "voteClicked"
        },
        voteClicked: function (e) {
            var self = this;
            this.model = new Backbone.Model();
            this.model.url = "rest/votering/" + e.target.innerText + "/summary";
            this.model.fetch({
                success: function(data) {
                    new VoteView({el: self.$el.find('#voteContainer'), model: data});
                }
            });
        },
        render: function () {
            this.$el.empty().append(this.template(this.collection));
        },
        template: _.template(tmp),
        showVotering: function (id) {
            new VoteView({el: "#voteContainer", voteId: 1499})
        }
    });
    return View;
});