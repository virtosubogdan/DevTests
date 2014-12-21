Ext.require(['view.TestsSummary', 'model.TestSummary']);

Ext.define('controller.TestsSummary', {
    extend: 'Ext.app.ViewController',

    init: function () {
        Ext.create('view.TestsSummary', {
            renderTo: Ext.get('content-div'),
            parentController: this
        }).show();
    },

    getTestsStore: function () {
        return new Ext.data.Store({
            autoLoad: true,
            autoSync: false,
            model: 'model.TestSummary',
            proxy: {
                type: 'ajax',
                url: 'devTests/tests/',
                headers: {'Content-Type': 'application/json', 'Accept': 'application/json'},
                reader: {type: 'json'}
            }
        });
    },

    openTest: function (testId) {
        Ext.getCmp('content-component').close();
        var testSummaryController = Ext.create('controller.TestSummary');
        testSummaryController.testId = testId;
        testSummaryController.init();
    }
});