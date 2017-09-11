function index(req, res) {
    res.render('index', { title: 'Udemy AWS Serverless Course' });
}

module.exports = function(router) {
    router.get('/', index);
};
