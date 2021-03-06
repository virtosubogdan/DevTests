Ext.define('view.Login', {
    extend: 'Ext.form.Panel',

    id: 'login-view',
    height: 200,
    width: 300,
    layout: 'absolute',
    bodyPadding: 10,
    preventHeader: true,

    initComponent: function() {
        var me = this;
        me.items = [
            {
                xtype: 'textfield',
                name: 'j_username',
                id: 'username',
                allowBlank: false,
                fieldLabel: 'Username',
                labelWidth: 60,
                x: 40,
                y: 50,
                listeners: {
                    specialkey: function(field, e){
                        if (e.getKey() == e.ENTER) {
                            Ext.getCmp('login-btn').fireEvent('click');
                        }
                    }
                }
            },{
                xtype: 'textfield',
                inputType: 'password',
                vtypeText: 'password',
                id: 'password',
                name: 'j_password',
                allowBlank: false,
                fieldLabel: 'Password',
                labelWidth: 60,
                x: 40,
                y: 90,
                listeners: {
                    specialkey: function(field, e){
                        if (e.getKey() == e.ENTER) {
                            Ext.getCmp('login-btn').fireEvent('click');
                        }
                    }
                }
            },{
                xtype: 'button',
                id: 'register-btn',
                text: 'Register',
                height: 22,
                width: 80,
                x: 55,
                y: 130
            },{
                xtype: 'button',
                id: 'login-btn',
                text: 'Login',
                height: 22,
                width: 80,
                x: 165,
                y: 130
            }
        ];
        me.callParent(arguments);
    }
});