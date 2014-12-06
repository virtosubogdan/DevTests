Ext.require(['view.Home', 'model.Home']);

Ext.define('controller.Home', {
    extend: 'Ext.app.ViewController',
    view: null,

    init: function () {
        var me = this;
        me.view = Ext.create('view.Home', {
            renderTo: Ext.get('content-div'),
            parentController: this
        });
        me.view.show();
        me.loadData();
    },

    loadData: function () {
        var me = this;
        new Ext.data.Store({
            autoLoad: true,
            proxy: {
                type: 'ajax',
                url: 'devTests/performance/home/',
                headers: {'Content-Type': 'application/json', 'Accept': 'application/json'},
                reader: {type: 'json', rootProperty: 'data'}
            },
            model: 'model.Home',
            listeners: {
                load: function (content, records, successful, eOpts) {
                    if (successful) {
                        me.view.loadRecord(records[0]);
                    } else {
                        console.log(records);
                    }
                }
            }
        });
    }
});