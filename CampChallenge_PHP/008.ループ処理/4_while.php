<?php
/*
while文を利用して、以下の処理を実現してください。
1000を2で割り続け、100より小さくなったらループを抜ける処理
*/

$num=1000;
while($num>=100){
  $num/=2;
}
echo $num;
