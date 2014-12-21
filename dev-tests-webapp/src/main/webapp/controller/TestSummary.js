Ext.require(['view.TestSummary', 'model.QuestionSummary']);

Ext.define('controller.TestSummary', {
    extend: 'Ext.app.ViewController',
    testId: null,

    init: function () {
        Ext.create('view.TestSummary', {
            renderTo: Ext.get('content-div'),
            parentController: this
        }).show();
    },

    getQuestionsStore: function () {
        var me = this;
        return new Ext.data.Store({
            autoLoad: true,
            autoSync: false,
            model: 'model.QuestionSummary',
            proxy: {
                type: 'ajax',
                url: 'devTests/tests/summary?testId=' + me.testId,
                headers: {'Content-Type': 'application/json', 'Accept': 'application/json'},
                reader: {type: 'json'}
            }
        });
    }
})
;