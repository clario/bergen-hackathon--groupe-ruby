define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'text!templates/SakListItem.html'
], function ($, _, Backbone, Marionette, tmp) {

    var View = Marionette.ItemView.extend({

        template: _.template(tmp)
    });

    return View;

});