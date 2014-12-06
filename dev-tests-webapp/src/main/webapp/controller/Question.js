Ext.require(['view.Question', 'model.Question']);

Ext.define('controller.Question', {
    extend: 'Ext.app.ViewController',

    init: function () {
        Ext.create('view.Question', {
            renderTo: Ext.get('content-div'),
            parentController: this
        }).show();
    },

    getQuestionsStore: function () {
        return new Ext.data.Store({
            autoLoad: true,
            autoSync: false,
            model: 'model.Question',
            proxy: {
                type: 'ajax',
                url: 'devTests/demo/questions/',
                headers: {'Content-Type': 'application/json', 'Accept': 'application/json'},
                reader: {type: 'json'}
            }
        });
    }
});