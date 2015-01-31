define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'app/routers/MainRouter',
    'app/routers/MainController',
    'views/MainLayoutView'
], function ($, _, Backbone, Marionette, MainRouter, MainController, MainLayoutView) {

    var app = Marionette.Application.extend({
        initialize: function () {
            this.mainLayout = new MainLayoutView();
            this.controller = new MainController();
            this.router = new MainRouter({controller: this.controller});
        },
        onStart: function () {
            this.mainLayout.render();
            if (Backbone.history) {
                return Backbone.history.start();
            }
        },
        showError: function (message, seconds) {
            if (!seconds) {
                seconds = 5;
            }

            $("#error").html(message);
            $("#errorContainer").show(0);
            setTimeout(function () {
                $("#errorContainer").hide(0);
            }, (seconds * 1000));

        },
        showMessage: function (message, seconds) {
            if (!seconds) {
                seconds = 5;
            }

            $("#message").html(message);
            $("#messageContainer").show(0);
            setTimeout(function () {
                $("#messageContainer").hide(0);
            }, (seconds * 1000));
        }
    });

    return app;
});