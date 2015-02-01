define([
    'jquery',
    'underscore',
    'backbone',
    'marionette',
    'lib/highcharts/highcharts',
    'text!templates/MainLayout.html'
], function ($, _, Backbone, Marionette, highcharts, tmp) {

    var View = Backbone.View.extend({
        initialize: function (opts) {
            this.title = opts.title || "Votering per parti";
//            this.collection = new Backbone.Collection();
//            this.collection.reset([
//                {partyId: "H", forCount: 24, motCount: 25, ikkeTilstedeCount: 100},
//                {partyId: "V", forCount: 24, motCount: 25, ikkeTilstedeCount: 100},
//                {partyId: "A", forCount: 24, motCount: 25, ikkeTilstedeCount: 100}
//            ]);
            Highcharts.theme = {
                colors: ["#43A047", "#E53935", "rgb(128, 128, 128)"]}
            
            Highcharts.setOptions(Highcharts.theme)

        },
        render: function () {
            var self = this;
            var parties = this.collection.pluck('partyCode');
            this.$el.highcharts({
                chart: {
                    type: 'column'
                },
                title: {
                    text: self.title
                },
                xAxis: {
                    categories: parties
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Antall stemmer'
                    },
                    stackLabels: {
                        enabled: true,
                        style: {
                            fontWeight: 'bold',
                            color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                        }
                    }
                },
                legend: {
                    align: 'right',
                    x: -30,
                    verticalAlign: 'top',
                    y: 25,
                    floating: true,
                    backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                    borderColor: '#CCC',
                    borderWidth: 1,
                    shadow: false
                },
                tooltip: {
                    formatter: function () {
                        return '<b>' + this.x + '</b><br/>' +
                                this.series.name + ': ' + this.y + '<br/>' +
                                'Total: ' + this.point.stackTotal;
                    }
                },
                plotOptions: {
                    column: {
                        stacking: 'normal',
                        dataLabels: {
                            enabled: true,
                            color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                            style: {
                                textShadow: '0 0 3px black'
                            }
                        }
                    }
                },
                series: [{
                        name: 'For',
                        data: self.collection.pluck('countFor')
                    }, {
                        name: 'Mot',
                        data: self.collection.pluck('countMot')
                    }, {
                        name: 'Ikke tilstede',
                        data: self.collection.pluck('countIkkeTilstede')
                    }]
            });
        }
    });

    return View;

});