Ext.define('view.Home', {
    extend: 'Ext.form.Panel',
    id: 'content-component',

    width: 500,
    height: 400,
    layout: {
        type: 'vbox',
        align: 'stretch'
    },

    initComponent: function () {
        var me = this;
        me.items = [
            {
                xtype: 'textfield',
                name: 'questions',
                id: 'questions',
                readOnly: true,
                fieldLabel: 'Number of questions:',
                labelWidth: 150,
                flex: 1
            }, {
                xtype: 'textfield',
                id: 'users',
                name: 'users',
                readOnly: true,
                fieldLabel: 'Number of users:',
                labelWidth: 150,
                flex: 1
            }, {
                xtype: 'textfield',
                id: 'survivorNr',
                name: 'survivorNr',
                readOnly: true,
                fieldLabel: 'Survivor record:',
                labelWidth: 150,
                flex: 1
            }
        ];
        me.callParent(arguments);
    }
});