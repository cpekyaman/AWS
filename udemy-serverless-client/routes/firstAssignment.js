var request = require('request');

var api = {
    fetchUrl : 'https://hjb1ovxamh.execute-api.us-east-2.amazonaws.com/dev/fetch-data',
    saveUrl : 'https://hjb1ovxamh.execute-api.us-east-2.amazonaws.com/dev/store-data'
};

function fetchAssignment(req, res) {
    request(api.fetchUrl, function(error, response, body) {
        res.render('firstAssignment/form', JSON.parse(body));
    });
}

function postAssignment(req, res) {
    request.post({
        url : api.saveUrl,
        json : {
            firstName : req.body.firstName,
            lastName : req.body.lastName
        }
    }, function(error,response,body) {
        console.log(body);
        res.render('firstAssignment/result', body);
    });
}

module.exports = function(router) {
    router.get('/assignment1', fetchAssignment);
    router.post('/assignment1', postAssignment);
};