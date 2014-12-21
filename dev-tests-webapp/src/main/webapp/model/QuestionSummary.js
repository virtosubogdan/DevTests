Ext.define('model.QuestionSummary', {
    extend: 'Ext.data.Model',

    fields: [
        {name: 'id', type: 'string'},
        {name: 'status', type: 'string'},
        {name: 'identifier', type: 'string'}
    ]
});