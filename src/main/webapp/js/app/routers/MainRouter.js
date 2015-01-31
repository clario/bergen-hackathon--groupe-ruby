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
            "voteringer": "votes",
        },
        routes: {
        },
    });

    return router;
});