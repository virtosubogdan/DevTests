Ext.define('view.Menu', {
    extend: 'Ext.menu.Menu',
    floating: false,

    initComponent: function () {
        var me = this;

        me.items = [{
            text: 'Home',
            handler: me.parentController.go
        }, {
            text: 'Tests',
            handler: me.parentController.go
        }, {
            text: 'Performance Report',
            handler: me.parentController.go
        }, {
            text: 'Logout',
            handler: me.parentController.go
        }
        ];
        me.callParent(arguments);
    }
});