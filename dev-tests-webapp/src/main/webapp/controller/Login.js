Ext.define('controller.Login', {
    extend: 'Ext.app.ViewController',

    init: function () {
        console.log('before create view');

        Ext.create('view.Login', {
            renderTo: Ext.get('login-div'),
            parentController: this
        }).show();
        console.log('after show view');
        Ext.getCmp("login-btn").on("click", function (button, event) {
            if (!Ext.getCmp("login-view").getForm().isValid()) return;
            Ext.getCmp("login-view").getForm().submit({
                url: 'j_spring_security_check?auth=form',
                method: 'POST',
                success: function () {
                    console.log('successful login');
                    window.location = 'question.html';
                },

                failure: function (form, action) {
                    console.log('fail');
                    console.log(action);
                    form.reset();
                }
            });
        });
    }
});