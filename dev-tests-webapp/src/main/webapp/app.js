Ext.require(['controller.Question', 'controller.Menu']);

Ext.onReady(function () {
    Ext.application({
        name: 'MyApp',

        launch: function () {
            Ext.create('controller.Question').init();
            Ext.create('controller.Menu').init();
        }
    })
});