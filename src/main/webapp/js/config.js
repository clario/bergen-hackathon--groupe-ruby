require.config({
    baseUrl: 'js/',
    paths: {
        app: 'app/',
        templates: '../templates',
        underscore: 'lib/underscore/underscore-min',
        jquery: 'lib/jquery/jquery-min',
        backbone: 'lib/backbone/backbone-min',
        marionette: 'lib/backbone/marionette',
        text: 'lib/require/text',
        moment: 'lib/moment/moment',
        views: 'app/views',
        models: 'app/models',
        utils: 'app/utils'
    },
    shim: {
        'backbone': {
            deps: ['underscore', 'jquery'],
            exports: 'Backbone'
        },
        "marionette": {
            "deps": ["underscore", "backbone", "jquery"],
            "exports": "Marionette"
        },
        'underscore': {
            exports: '_'
        },
    }
});

require(['app/application'], function (Application) {
    App = new Application();
    App.start();
});