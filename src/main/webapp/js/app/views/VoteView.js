define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'text!templates/VoteView.html'
], function ($, _, Backbone, Marionette, tmp) {

    var View = Marionette.ItemView.extend({
        template: _.template(tmp),
        initialize: function () {
            this.render();
        },
        render: function() {
            this.$el.empty().append(tmp);
            this.updateVote(this.model.get('countFor'), this.model.get('countIkkeTilstede'))
        },
        updateVote: function (f, i) {
            d3.selectAll('#layer1 > rect').style('fill', 'gray');

            var rects = this.$el.find('rect').sort(function (a, b) {
                return parseInt(a.id) > parseInt(b.id) ? 1 : -1
            });
            var forVote = d3.selectAll(rects.slice(0, f)).remove();
            var ikkeVote = d3.selectAll(rects.slice(f, i + f)).remove();
            var motVote = d3.selectAll(rects.slice(i + f, 169)).remove();
            d3.select('#layer1 > g').remove();
            d3.select('#layer1').insert('g').attr('id', 'forVote');
            d3.select('#layer1').insert('g').attr('id', 'ikkeVote');
            d3.select('#layer1').insert('g').attr('id', 'motVote');
            $('#layer1 #forVote').append(forVote.map($));
            $('#layer1 #ikkeVote').append(ikkeVote.map($));
            $('#layer1 #motVote').append(motVote.map($));
            d3.selectAll('#forVote > rect')
                    .transition()
                    .delay(250)
                    .style('fill', 'green');
            d3.selectAll('#ikkeVote > rect')
                    .transition()
                    .delay(250)
                    .style('fill', 'gray');
            d3.selectAll('#motVote > rect')
                    .transition()
                    .delay(250)
                    .style('fill', 'red');


        },

    });

    return View;

});
