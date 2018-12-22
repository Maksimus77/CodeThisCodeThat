// Variables for inner working
var Timer;
var Button;
var Lap;
var isStop

// Variable for saving the state
var current_time;
var current_laps;

// When the page is loaded
function initialize(){
  Timer = document.getElementById("time");
  Button = document.getElementById("button");
  Lap = document.getElementById("lap_time");
  isStop = 0;
}


// Start the watch and print the final time
function start(){
  current_time = 0;
  current_laps = new Array();
  Timer.innerHTML = "0 seconds";

  Button.innerHTML = "Stop";
  Button.setAttribute('onclick','stop()');

  isStop = 0;
  setTimeout(increment,1000);
}

// Stop the watch and print the final time
function stop(){
  isStop = 1;
  Timer.innerHTML = "Your Finale time is: " + Timer.innerHTML;
  Button.innerHTML = "Start";
  Button.setAttribute('onclick','start()');
  while (Lap.firstChild) {
    Lap.removeChild(Lap.firstChild);
  }
  sendTime();
}

// Function that will increment the number on the Timer by one
function increment(){
  // Base case
  if(isStop == 1) return;

  current_time = current_time+1;
  Timer.innerHTML = current_time + " seconds";
  // Recurse
  setTimeout(increment, 1000);
}

function laps(){
  if(isStop == 0){
    current_laps.push(current_time);
    var node = document.createElement("P");
    var textnode = document.createTextNode("Time: " + Timer.innerHTML);
    node.appendChild(textnode);
    Lap.appendChild(node);
  }
}

// Helper function
function getCurrentTime(){
  return Number(Timer.innerHTML.split(" ")[0]);
}

function sendTime(){
  var xhttp = new XMLHttpRequest();
  var base_string = "php/io.php?time="+current_time;
  for (var i = 0; i < current_laps.length; i++) {
    base_string = base_string + "&l" + i + "="+current_laps[i];
  }
  xhttp.open("GET", base_string, true);
  xhttp.send();
}
