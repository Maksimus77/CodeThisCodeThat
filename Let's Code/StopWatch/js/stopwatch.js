var Timer;
var Button;
var isStop;

function initialize(){
  Timer = document.getElementById("time");
  Button = document.getElementById("button");
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

// Helper function
function getCurrentTime(){
  return Number(Timer.innerHTML.split(" ")[0]);
}
