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
    }
});