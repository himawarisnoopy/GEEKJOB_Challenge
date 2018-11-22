<?php
/*課題「ユーザー定義関数」、課題「引数1」のユーザー定義関数を含んだutil.phpを作成し、
requireで呼び出して利用してください。*/

function judge($num){
  if($num%2==0){
    echo "$num は偶数です";
  }
  if($num%2==1){
    echo "$num は奇数です";
  }
}
