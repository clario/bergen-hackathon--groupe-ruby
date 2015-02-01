define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'text!templates/VoteTableRowView.html'
], function ($, _, Backbone, Marionette, tmp) {

    var BlankView = Marionette.ItemView.extend({
        tagName: 'tr',
        className: 'voteringTableRow',
        template: _.template(tmp)
    });

    return BlankView;

});