define([
    'jquery',
    'underscore',
    'backbone',
    'marionette'
], function ($, _, Backbone, Marionette) {

    var router = Marionette.AppRouter.extend({
        appRoutes: {
            "": "root",
        },
        routes: {
        },
    });

    return router;
});