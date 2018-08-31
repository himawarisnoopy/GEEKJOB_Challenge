<?php
 $data = array();

 for($j=1; $j<10; $j++){
    $data[$j] = mt_rand(0,9999);
 }
 var_dump($data);

 $time_start = microtime(true);
// 計測したい処理
　for($i=0; $i<count($data); $i++){
  $target = count($data)-$i;
    for($j=1; $j<$target; $j++){
        if($array[$j]<$array[$j-1]){
          $swap = $data[$j];
          $data[$j] = $data[$j-1];
          $data[$j-1] = $swap;
        }
    }
  }

 $time = microtime(true) - $time_start;
 echo "{$time} 秒";
?>
