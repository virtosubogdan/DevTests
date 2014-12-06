Ext.define('model.Home', {
    extend: 'Ext.data.Model',

    fields: [
        {name: 'questions', type: 'string'},
        {name: 'users', type: 'string'},
        {name: 'survivorNr', type: 'string'}
    ]
});