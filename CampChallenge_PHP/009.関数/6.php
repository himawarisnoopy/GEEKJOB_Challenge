<?php
/*
引数が２つの関数を作成してください。１つ目の引数に３人分のプロフィールを、２つ目の引数に検索文字を受け取ります。
関数の中では、１つ目の引数で得た３人分のプロフィール（項目は戻り値2と同様）から、検索文字列を名前に含む（部分一致）プロフィールを探し、該当１件を返却する。
それ以降は課題「戻り値2」と同じ処理にしてください。
*/
function profile($array,$a){
  foreach ($array as $value) {
    foreach($value as $key => $value2 ){
      $search = strpos($value2,$a);
      if($search !== false){
        return $value;
      }
    }
  }
}
$arr1 = array(
  'id' => 1000,
  'name' => '川崎',
  'bd' => 1996,
  'ad' => '東京',
);
$arr2 = array(
  'id' => 1001,
  'name' => '佐藤',
  'bd' => 2000,
  'ad' => '大阪',
);
$arr3 = array(
  'id' => 1002,
  'name' => '山田',
  'bd' => 2001,
  'ad' => '北海道',
);

$array = array($arr1,$arr2,$arr3);

$result = profile($array,'山');

foreach($result as $key => $value2){
  echo $value2."<br>";
}
