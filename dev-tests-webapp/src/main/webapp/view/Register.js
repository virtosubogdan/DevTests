Ext.define('view.Register', {
    extend: 'Ext.form.Panel',

    id: 'register-view',
    height: 400,
    width: 300,
    layout: 'absolute',
    bodyPadding: 10,
    preventHeader: true,

    initComponent: function () {
        var me = this;
        me.items = [
            {
                xtype: 'textfield',
                name: 'username',
                id: 'username',
                allowBlank: false,
                fieldLabel: 'Username',
                labelWidth: 60,
                x: 40,
                y: 50
            },
            {
                xtype: 'textfield',
                name: 'firstname',
                id: 'firstname',
                allowBlank: false,
                fieldLabel: 'Firstname',
                labelWidth: 60,
                x: 40,
                y: 90
            },
            {
                xtype: 'textfield',
                name: 'lastname',
                id: 'lastname',
                allowBlank: false,
                fieldLabel: 'Lastname',
                labelWidth: 60,
                x: 40,
                y: 130
            }, {
                xtype: 'textfield',
                name: 'email',
                id: 'email',
                allowBlank: false,
                fieldLabel: 'Email',
                labelWidth: 60,
                x: 40,
                y: 170
            }, {
                xtype: 'textfield',
                inputType: 'password',
                vtypeText: 'password',
                id: 'password',
                name: 'password',
                allowBlank: false,
                fieldLabel: 'Password',
                labelWidth: 60,
                x: 40,
                y: 210
            }, {
                xtype: 'textfield',
                inputType: 'password',
                vtypeText: 'password',
                id: 'password2',
                name: 'password2',
                allowBlank: false,
                fieldLabel: 'Password Check',
                labelWidth: 60,
                x: 40,
                y: 250
            }, {
                xtype: 'button',
                text: 'Cancel',
                height: 22,
                width: 80,
                x: 55,
                y: 290,
                listeners: {
                    click: function () {
                        window.location = "login.html"
                    }
                }
            }, {
                xtype: 'button',
                text: 'Register',
                height: 22,
                width: 80,
                x: 165,
                y: 290,
                listeners: {
                    click: function () {
                        me.parentController.register();
                    }
                }
            }
        ];
        me.callParent(arguments);
    }
});