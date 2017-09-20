var request = require('request');

var api = {
    getUrl : 'https://stu4e8uoh2.execute-api.us-east-2.amazonaws.com/dev/compare-yourself',
    postUrl : 'https://stu4e8uoh2.execute-api.us-east-2.amazonaws.com/dev/compare-yourself',
    putUrl : 'https://stu4e8uoh2.execute-api.us-east-2.amazonaws.com/dev/compare-yourself'
};

function listData(req, res) {
    res.render('compareYourself/list', {
        title : "Compare Yourself",
        header : ["#","User Name","Age","Height","Income"],
        data : [
            ["1", "cenk", 37, 170, 5000]
        ]
    });
}

function createForm(req, res) {
    res.render('compareYourself/form', {
        title : "Create User Data",
        submitAction : 'Create',
        data : {}
    });
}

function updateForm(req, res) {
    //request(api.getUrl, function(error, response, body) {
        res.render('compareYourself/form', {
            title : "Update User Data",
            submitAction : 'Update',
            data : {
                id : 1,
                username : "cenk",
                age : 37,
                height: 170,
                income: 5000
            }
        });
    //});
}

function create(req, res) {

}

function update(req, res) {

}

function remove(req, res) {

}

module.exports = function(router) {
    router.get('/compare', listData);
    router.get('/compare/form', createForm);
    router.get('/compare/:id/form', updateForm);

    router.post('/compare', create);
    router.put('/compare/:id', update);

    router.delete('/compare/:id', remove);
};