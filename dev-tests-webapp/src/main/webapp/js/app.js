Ext.require(['controller.Home', 'controller.Menu']);

Ext.onReady(function () {
    Ext.application({
        name: 'MyApp',

        launch: function () {
            Ext.create('controller.Home').init();
            Ext.create('controller.Menu').init();
        }
    })
});