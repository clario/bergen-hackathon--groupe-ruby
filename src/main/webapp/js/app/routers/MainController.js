define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'views/SakListView',
    'views/VotesView',
    'views/SakView'
], function ($, _, Backbone, Marionette, SakListView, VotesView, SakView) {

    var controller = Marionette.Controller.extend({
        root: function () {
            App.mainLayout.main.show(new SakListView());
        },
        votes: function () {
            App.mainLayout.main.show(new VotesView());
        },
        sak: function (sakId) {
            var model = new Backbone.Model();
            model.url = "rest/saker/" + sakId;
            model.fetch( {
                success: function() {
                    App.mainLayout.main.show(new SakView({model: model}));
                }
            })
        }
    });

    return controller;
});