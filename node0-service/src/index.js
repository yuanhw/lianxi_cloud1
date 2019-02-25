let http = require('http')
let url = require('url')
let path = require('path')

let server = http.createServer(function (req, res) {
    console.log('\nreq:\n')
    console.log(req.url)
    let paramName = url.parse(req.url).pathname;
    res.writeHead(200, {"Content-Type": "application/json;charset=utf-8"})
    if (paramName === '/') {
        res.end(JSON.stringify({index: "welcome index!"}))
    } else if (paramName === "/health.json") {
        res.end(JSON.stringify({status: "UP"}))
    } else {
        res.end("404")
    }
})

server.listen(9010, function () {
    console.log('node start, listen port 9010...')
})