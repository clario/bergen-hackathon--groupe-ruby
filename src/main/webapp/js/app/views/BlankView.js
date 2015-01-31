define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/MainLayout.html'
], function ($, _, Backbone, tmp) {

    var BlankView = Backbone.View.extend({
        initialize: function () {
            this.render();
        },
        template: _.template(tmp)
    });

    return BlankView;

});