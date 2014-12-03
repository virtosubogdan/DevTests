Ext.require('view.Login');

Ext.define('controller.Login', {
    extend: 'Ext.app.ViewController',

    init: function () {
        Ext.create('view.Login', {
            renderTo: Ext.get('login-div'),
            parentController: this
        }).show();
        Ext.getCmp("login-btn").on("click", function (button, event) {
            if (!Ext.getCmp("login-view").getForm().isValid()) return;
            Ext.getCmp("login-view").getForm().submit({
                url: 'j_spring_security_check',
                method: 'POST',
                success: function (form, action) {
                    window.location = 'demo.html';
                },

                failure: function (form, action) {
                    form.reset();
                }
            });
        });
    }
});