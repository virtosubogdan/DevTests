Ext.define('view.TestsSummary', {
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
                store: me.parentController.getTestsStore(),
                enableColumnHide: false,
                defaultType: 'gridcolumn',
                columns: [{
                    dataIndex: 'id',
                    hidden: true
                }, {
                    dataIndex: 'name',
                    text: 'Test',
                    flex: 1
                }
                ],
                selModel: Ext.create('Ext.selection.RowModel', {})
            }
        ];
        me.callParent(arguments);
    }
});