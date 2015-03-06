describe('primeFactors', function () {
    describe('when parsing forms', function() {
    
        beforeEach(function() {
            document.body.innerHTML = '<html><body><form><input id="number" value="12" /></form></body></html>';
        });

        it('gets the input number', function(){
            var actualNumber = getNumber();
            assert.equal(actualNumber, '12');
        });
    });
    
    describe('when displaying result', function() {
        
        beforeEach(function() {
            document.body.innerHTML = '<html><body><p id="result"></p></body></html>';
        });
    
        it('displays the result correctly', function(){
            displaysResult('12',[2,2,3]);
            var resultElement = document.getElementById("result");
            assert.include(resultElement.innerHTML, '12 = 2 x 2 x 3')
        });
    });
    
    describe('when sending the request', function() {
        var server;
        beforeEach(function(){
            // Load the http module to create an http server.
            var http = require('http');

            // Configure our HTTP server to respond with Hello World to all requests.
            var server = http.createServer(function (request, response) {
              response.writeHead(200, {"Content-Type": "text/json"});
              response.end('{"number":12,"decomposition":[2,2,3]}');
            });

            // Listen on port 8000, IP defaults to 127.0.0.1
            server.listen(8000);
        });
        
        afterEach(function () {
            server.close();
        })
        
        it('gets the api result', function() {
            var response = sendNumber('http://127.0.0.1:8000', 12);
            assert.include(response, "[2,2,3]")
        });
    });
    
});