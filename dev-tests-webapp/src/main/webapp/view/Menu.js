Ext.define('view.Menu', {
    extend: 'Ext.menu.Menu',
    floating: false,

    initComponent: function () {
        var me = this;

        me.items = [{
            text: 'Home',
            handler: me.parentController.goHome
        }, {
            text: 'Tests',
            handler: me.parentController.goToTests
        }, {
            text: 'Questions',
            handler: me.parentController.goToQuestions
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