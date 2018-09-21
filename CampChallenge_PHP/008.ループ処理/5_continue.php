<?php
//1. 二重のforeachを利用して、九九表を作成してください。
//2. continueを利用して、5の段だけ表示されない様にしてみましょう。

$num1 = array(1,2,3,4,5,6,7,8,9);
$num2 = array(1,2,3,4,5,6,7,8,9);

$num=0;
foreach($num1 as $value1) {
    foreach($num2 as $value2){
      if($value1==5){
        continue;
      }
      $num=$value1*$value2;
      echo $num."&ensp;";
    }
    echo "<br>";
}
