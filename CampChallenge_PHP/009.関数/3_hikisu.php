<?php
/*
1. ３つの引数を持ち、渡された数値で掛け算をする関数を作成します。
関数は、１つ目の引数と２つ目の引数を掛け算し、３つ目の引数がtrueの場合は結果を２乗させてください。
また、２つ目の引数は5、３つ目の引数はfalseをデフォルト値として設定してください。
2. 作成した関数を呼び出し、結果を表示してください。
*/

function cal($num1,$num2=5,$flag=false){
  $num=$num1*$num2;
  if($flag==true){
    $num=$num*$num;
  }
  echo $num;
}

cal(2);
cal(2,3,true);
