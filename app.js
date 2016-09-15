var express = require('express');
var app = express();
var fs = require('fs');


function getFilesFromLastHour () {
  var paths = ['./runs'];
  for (var i = 0; i < 3; i++) {
    var currentPath = paths.join('/');
    var files = fs.readdirSync(currentPath);
    files.sort(function(a, b) {
        return parseInt(b) - parseInt(a);
     });
    paths.push(files[0])
  }
  var path = paths.join('/') + '/'
  var files = fs.readdirSync(path);
  files.sort(function(a, b) {
      return fs.statSync(path + b).mtime.getTime() - fs.statSync(path + a).mtime.getTime();
   });
  return files.map(function(file) { return path + file }).map(function(file) {
    var contents = fs.readFileSync(file, 'utf8')
    if (contents.match(/11 passing/g)) {
      return {result: 'passed', name: file}
    } else {
      return {result: 'failed', name: file}
    }
  })
}

app.get('/runs/*', function (req, res) {
  var contents = fs.readFileSync('.' + req.url, 'utf8')
  res.send(contents)
})

app.get('/', function (req, res) {
  str = '<html>';
  getFilesFromLastHour().forEach(function(file) {
    str += '<a href="' + file.name + '">' + file.name + '</a><br/>'
  })
  res.send(str)
});

app.listen(6005, function () {
  console.log('Example app listening on port 6005!');
});
