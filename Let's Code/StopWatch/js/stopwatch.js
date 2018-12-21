var Timer;
var Button;
var Lap;
var isStop;
var current_path = 'C:\\Users\\biapt\\Documents\\GitHub\\CodeThisCodeThat\\Let\'s Code\\StopWatch';

function initialize(){
  Timer = document.getElementById("time");
  Button = document.getElementById("button");
  Lap = document.getElementById("lap_time");
  isStop = 0;
}

// Start the watch and print the final time
function start(){
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
}

// Function that will increment the number on the Timer by one
function increment(){
  if(isStop == 1) return;
  // Get the current time, increment it and set it back
  var time = getCurrentTime();
  time = time + 1;
  Timer.innerHTML = time + " seconds";

  // Recurse
  setTimeout(increment, 1000);
}

function laps(){
  if(isStop == 0){
    var node = document.createElement("P");                 // Create a <li> node
    var textnode = document.createTextNode("Time: " + Timer.innerHTML);         // Create a text node
    node.appendChild(textnode);                              // Append the text to <li>
    Lap.appendChild(node);
  }
}

// Helper function
function getCurrentTime(){
  return Number(Timer.innerHTML.split(" ")[0]);
}
