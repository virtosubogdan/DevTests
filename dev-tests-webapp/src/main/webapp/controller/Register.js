Ext.require('view.Register');

Ext.define('controller.Register', {
    extend: 'Ext.app.ViewController',

    init: function () {
        Ext.create('view.Register', {
            renderTo: Ext.get('register-div'),
            parentController: this
        }).show();
    },

    register: function () {
        var form = Ext.getCmp("register-view").getForm();
        if (form.findField('password').getValue() !== form.findField('password2').getValue()) {
            Ext.Msg.alert("Error", 'Passwords do not match!');
            return;
        }

        if (form.isValid()) {
            Ext.Ajax.request({
                url: '/devTests/main/register',
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                jsonData: Ext.util.JSON.encode(form.getValues()),
                success: function (response) {
                    Ext.Msg.alert("Info", "User created.");
                    window.location = 'login.html';
                },
                failure: function (response) {
                    Ext.Msg.alert("Error", 'Could not create user!');
                }
            });
        }
    }
});