define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'views/SakListItemView',
    'text!templates/SakList.html'
], function ($, _, Backbone, Marionette, SakListItemView, tmp) {

    var View = Marionette.CompositeView.extend({
        onRender: function () {
            var self = this;
            this.emneId = "";
            this.collection = new Backbone.Collection();
            this.collection.url = function() {
                if (self.emneId) {
                return "rest/saker?emneId=" + self.emneId; 
                    
                } else {
                    return "rest/saker"; 
                    
                }
            }
            this.collection.fetch();
        },
        childView: SakListItemView,
        childViewContainer: '#sakContainer',
        template: _.template(tmp)
    });

    return View;

});