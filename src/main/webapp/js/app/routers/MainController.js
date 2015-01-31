define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
], function ($, _, Backbone, Marionette) {

    var controller = Marionette.Controller.extend({
        root: function () {
            App.mainLayout.main.show(new Marionette.ItemView({template: '<div>Nothing here yet</div>' }));
        },
    });

    return controller;
});