define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'text!templates/MainLayout.html'
], function ($, _, Backbone, Marionette, tpl) {

    var MainLayoutView = Marionette.LayoutView.extend({
        el: 'body',
        template: _.template(tpl),
        regions: {
            sidebar: "#sidebar",
            main: "#main",
            modal: "#modalContainer",
        },
        events: {
            'click': 'hideDropDowns'
        },
        hideDropDowns: function(e) {
            this.$el.find('.dropdown').hide();
        },
        onRender: function() {
            var self = this;
            App.vent.on('hidedropdowns', function() {
                self.hideDropDowns();
            });
        }
    });

    return MainLayoutView;
});