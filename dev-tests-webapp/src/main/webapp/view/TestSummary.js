Ext.define('view.TestSummary', {
    extend: 'Ext.panel.Panel',
    id: 'content-component',

    initComponent: function () {
        var me = this;
        me.items = [
            {
                xtype: 'gridpanel',
                region: 'center',
                preventHeader: true,
                style: {padding: '5px'},
                border: false,
                store: me.parentController.getQuestionsStore(),
                enableColumnHide: false,
                defaultType: 'gridcolumn',
                columns: [{
                    dataIndex: 'number',
                    hidden: true
                }, {
                    dataIndex: 'testId',
                    hidden: true
                }, {
                    dataIndex: 'questionId',
                    hidden: true
                }, {
                    dataIndex: 'status',
                    text: 'Status',
                    width: 200
                }, {
                    dataIndex: 'identifier',
                    text: 'Identifier',
                    flex: 1
                }
                ],
                selModel: Ext.create('Ext.selection.RowModel', {}),
                listeners: {
                    itemdblclick: function (dv, record, item, index, e) {
                        console.log(record);
                    }
                }
            }
        ]
        ;
        me.callParent(arguments);
    }
})
;