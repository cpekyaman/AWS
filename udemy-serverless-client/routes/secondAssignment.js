var request = require('request');

var api = {
    saveUrl : 'https://0qlhvdd115.execute-api.us-east-2.amazonaws.com/dev/store-data'
};

function showForm(req, res) {
    res.render('secondAssignment/form', { title : 'Second Assignment'});
}

function postAssignment(req, res) {
    request.post({
        url : api.saveUrl,
        json : {
            name : req.body.name,
            age : parseInt(req.body.age),
            height : parseInt(req.body.height),
            income : parseInt(req.body.income)
        }
    }, function(error,response,body) {
        console.log(body);
        res.render('secondAssignment/result', body);
    });
}

module.exports = function(router) {
    router.get('/assignment2', showForm);
    router.post('/assignment2', postAssignment);
};