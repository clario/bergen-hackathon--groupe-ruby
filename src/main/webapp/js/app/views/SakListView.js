define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'lib/chosen/select2.min',
    'views/SakListItemView',
    'text!templates/SakList.html'
], function ($, _, Backbone, Marionette, chosen, SakListItemView, tmp) {

    var View = Marionette.CompositeView.extend({
        onRender: function () {
            var self = this;

            $.get("rest/emner", function (data) {
                var selectEl = self.$el.find("#emneSelect");
                selectEl.empty();
                selectEl.append("<option></option>")
                _.each(data, function (item) {
                    selectEl.append("<option value='" + item.emneId + "' class=''>" + item.emnenavn.toLowerCase() + "</option>")
                })

//                selectEl.select2({
//                    allowClear: true
//                });

            });

            this.emneId = "";
            this.collection = new Backbone.Collection();
            this.collection.url = function () {
                if (self.emneId) {
                    var url = "rest/saker?emneId=" + self.emneId;
                    if (self.$el.find('#query').val().length > 0) {
                        url += "&q=" + self.$el.find('#query').val();
                    }
                    return url;
                } else if (self.$el.find('#query').val().length > 0) {
                    return "rest/saker?q=" + self.$el.find('#query').val();

                } else {
                    return "rest/saker";
                }
            };
            this.collection.fetch();
        },
        events: {
            'keyup #query': 'update',
            'change #query': 'update',
            'change #emneSelect': 'update',
            'submit form': 'update',
        },
        childView: SakListItemView,
        childViewContainer: '#sakListContainer',
        template: _.template(tmp),
        update: function (e) {
            this.emneId = this.$el.find("#emneSelect").val();
            if (e.keyCode) {
                if (e.keyCode === 13) {
                    this.collection.fetch();
                }
            } else {
                this.collection.fetch();
                e.preventDefault();
            }
        }
    });

    return View;

});