Ext.require(['controller.Login']);

Ext.onReady(function () {
    Ext.application({
        name: 'Login',

        launch: function () {

            Ext.create('controller.Login', {
                renderTo: Ext.get('login-div')
            }).init();
            Ext.getCmp('username').focus();
        }
    })
});