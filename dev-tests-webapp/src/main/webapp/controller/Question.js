Ext.require(['view.Question', 'model.Question']);

Ext.define('controller.Question', {
    extend: 'Ext.app.ViewController',

    init: function () {
        console.log('before create view');

        Ext.create('view.Question', {
            renderTo: Ext.get('question'),
            parentController: this
        }).show();
        console.log('after show view');

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