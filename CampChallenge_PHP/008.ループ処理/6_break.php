<?php

//課題「continue」の処理において、7の段でforeachの処理を抜ける様にしてみましょう。

$num1 = array(1,2,3,4,5,6,7,8,9);
$num2 = array(1,2,3,4,5,6,7,8,9);


$num=0;
foreach($num1 as $value1) {
  if($value1==7){
    break;
  }
  foreach($num2 as $value2){
    if($value1==5){
        continue;
      }
      $num=$value1*$value2;
      echo $num."&ensp;";
    }
    echo "<br>";
}
