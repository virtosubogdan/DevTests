Ext.require(['controller.Register']);

Ext.onReady(function () {
    Ext.application({
        name: 'Register',

        launch: function () {
            Ext.create('controller.Register').init();
            Ext.getCmp('username').focus();
        }
    })
});