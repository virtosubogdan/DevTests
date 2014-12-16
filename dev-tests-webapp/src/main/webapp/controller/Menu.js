Ext.require(['view.Menu']);

Ext.define('controller.Menu', {
    extend: 'Ext.app.ViewController',

    init: function () {
        Ext.create('view.Menu', {
            renderTo: Ext.get('menu-div'),
            parentController: this
        }).show();
    },

    go: function () {
        console.log('going somewhere');
    },

    goHome: function () {
        Ext.getCmp('content-component').close();
        Ext.create('controller.Home').init();
    },

    goToQuestions: function () {
        Ext.getCmp('content-component').close();
        Ext.create('controller.Question').init();
    },

    goToTests: function () {
        Ext.getCmp('content-component').close();
        Ext.create('controller.TestsSummary').init();
    }
});