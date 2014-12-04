Ext.require(['controller.Question']);

Ext.onReady(function () {
    Ext.application({
        name: 'MyApp',

        launch: function () {
            console.log('before init app');
            Ext.create('controller.Question').init();
            console.log('after init app');

        }
    })
});