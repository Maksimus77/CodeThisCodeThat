<?php
  $time = $_REQUEST["time"];
  $myfile = fopen("../data.txt", "a") or die("Unable to open file!");
  fwrite($myfile, "End time: ".$time." seconds \n");
  $l = getIfSet($_REQUEST["l0"]);
  $index = 0;
  while(!empty($l)){
    fwrite($myfile, "Laps ".$index.": ".$l." seconds \n");
    $index = $index + 1;
    $l = getIfSet($_REQUEST["l".$index]);
  }
  fwrite($myfile,"-------------------\n");
  fclose($myfile);

  function getIfSet(&$value, $default = null){
    return isset($value) ? $value : $default;
  }
 ?>
