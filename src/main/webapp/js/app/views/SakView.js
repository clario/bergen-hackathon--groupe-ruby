define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'moment',
    'views/VoteringView',
    'text!templates/SakView.html'
], function ($, _, Backbone, Marionette, moment, VoteringView, tmp) {

    var View = Marionette.ItemView.extend({
        template: _.template(tmp),
        onRender: function(view) {
            var self = view;
            var model  = new Backbone.Model();
            model.url = "rest/votering/sak/" + this.model.get('saksId');
            model.fetch( {
                success: function() {
                    new VoteringView({el: "#voteringContainer", model: model}).render();
                }
            });
        }
    });

    return View;

});