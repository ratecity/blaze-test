var express = require('express');
var app = express();
var fs = require('fs');

function getFilesFromHour(path) {
  var files = fs.readdirSync(path);
  files.sort(function(a, b) {
      return fs.statSync(path + b).mtime.getTime() - fs.statSync(path + a).mtime.getTime();
   });
  return files.map(function(file) { return path + file }).map(function(file) {
    var contents = fs.readFileSync(file, 'utf8')
    if (contents.match(/9 passing/g)) {
      return {result: 'passed', name: file}
    } else {
      return {result: 'failed', name: file}
    }
  })
}

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
  return getFilesFromHour(path)
}

app.get('/runs/*', function (req, res) {
  var contents = fs.readFileSync('.' + req.url, 'ascii')
  res.send(contents.replace(/\n/g, "<br/>").replace(/\[[0-9];*[0-9]*m/g, '').replace(/b\$/g, ''))
})

app.get('/previous/:month/:day/:hour', function (req, res) {
  var path = './runs/' + req.params.month + '/' + req.params.day + '/' + req.params.hour + '/';
  console.log(path)
  str = '<html>';
  getFilesFromHour(path).forEach(function(file) {
    if (file.result === 'passed') {
      str += '<a style="color: green" href="/' + file.name + '">' + file.name + '</a><br/>'
    } else {
      str += '<a style="color: red" href="/' + file.name + '">' + file.name + '</a><br/>'
    }
  })
  res.send(str)
})

app.get('/', function (req, res) {
  str = '<html>';
  getFilesFromLastHour().forEach(function(file) {
    if (file.result === 'passed') {
      str += '<a style="color: green" href="/' + file.name + '">' + file.name + '</a><br/>'
    } else {
      str += '<a style="color: red" href="/' + file.name + '">' + file.name + '</a><br/>'
    }
  })
  res.send(str)
});

app.listen(6005, function () {
  console.log('Example app listening on port 6005!');
});
