Ext.application({
    name: 'Question',

    launch: function () {

        Ext.define('question', {
            extend: 'Ext.data.Model',
            fields: [
                {name: 'id', type: 'string'},
                {name: 'name', type: 'string'},
                {name: 'content', type: 'string'}
            ]
        });

        var myQuestions = Ext.create('Ext.data.Store', {
            model: 'question',
            proxy: {
                type: 'ajax',
                url: 'devTests/demo/questions',
                reader: {
                    type: 'json'
                }
            },
            autoLoad: true
        });

        Ext.create('Ext.grid.Panel', {
            renderTo: Ext.getBody(),
            bodyPadding: 5,
            title: 'Questions',
            store: myQuestions,
            columns: [
                {header: 'Id', dataIndex: 'id', flex: 1},
                {header: 'Name', dataIndex: 'name', flex: 1},
                {header: 'Content', dataIndex: 'content', flex: 1}
            ]
        });

    }
});