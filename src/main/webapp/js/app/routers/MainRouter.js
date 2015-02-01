define([
    'jquery',
    'underscore',
    'backbone',
    'marionette'
], function ($, _, Backbone, Marionette) {

    var router = Marionette.AppRouter.extend({
        appRoutes: {
            "": "root",
            "saker": "root",
            "saker/:id": "sak",
            "voteringer": "votes",
        },
        routes: {
        },
    });

    return router;
});