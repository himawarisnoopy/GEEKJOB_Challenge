<?php

//1. 戻り値として、人物のID、名前、生年月日、住所を配列にして返却する関数を作成してください。
//2. 作成した関数を呼び出し、戻り値のID以外を表示してください。

function profile(){
  return array('1',"川崎",'1996',"東京");
}

$data=profile();

for($i=1;$i<count($data);$i++){
  echo $data[$i]."<br>";
}
