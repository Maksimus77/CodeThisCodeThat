var timer = document.getElementById("time");
var button = document.getElementById("button");
var isStop = 0;

function start(){
  document.getElementById("time").innerHTML = "0 seconds";

  document.getElementById("button").innerHTML = "Stop";
  document.getElementById("button").setAttribute('onclick','stop()');

  isStop = 0;
  setTimeout(increment,1000);
}

function stop(){
  isStop = 1;
  document.getElementById("time").innerHTML = "Your Finale time is: " + document.getElementById("time").innerHTML;
  document.getElementById("button").innerHTML = "Start";
  document.getElementById("button").setAttribute('onclick','start()');
}

function increment(){
  if(isStop == 1){
    return;
  }
  var time = Number(document.getElementById("time").innerHTML.split(" ")[0]);
  time = time + 1;
  document.getElementById("time").innerHTML = time + " seconds";
  setTimeout(increment, 1000);
}
