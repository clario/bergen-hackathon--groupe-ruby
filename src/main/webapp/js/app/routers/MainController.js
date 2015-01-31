define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'views/SakListView',
    'views/VotesView'
], function ($, _, Backbone, Marionette, SakListView, VotesView) {

    var controller = Marionette.Controller.extend({
        root: function () {
            App.mainLayout.main.show(new SakListView());
        },
        votes: function () {
            App.mainLayout.main.show(new VotesView());
        },
    });

    return controller;
});