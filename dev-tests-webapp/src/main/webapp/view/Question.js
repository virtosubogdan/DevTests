Ext.define('view.Question', {
    extend: 'Ext.panel.Panel',


    initComponent: function () {
        var me = this;
        me.items = [
            {
                xtype: 'gridpanel',
                region: 'center',
                preventHeader: true,
                style: { padding: '5px' },
                border: false,
                store: me.parentController.getQuestionsStore(),
                enableColumnHide: false,
                defaultType: 'gridcolumn',
                columns: [{
                    dataIndex: 'id',
                    hidden: true
                },{
                    dataIndex: 'name',
                    text: 'Question',
                    width: 250,
                    editor: {
                        xtype: 'textfield',
                        maxLength: 32,
                        enforceMaxLength: true,
                        msgTarget: 'side'
                    }
                },{
                    dataIndex: 'content',
                    text: 'Content',
                    flex: 1
                }
                ],
                selModel: Ext.create('Ext.selection.RowModel', {})
            }
        ];
        me.callParent(arguments);
    }
});