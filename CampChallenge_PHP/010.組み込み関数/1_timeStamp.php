<?php
//2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。

// // 2017年1月1日 0時0分0秒のタイムスタンプ
// $stamp = mktime(0, 0, 0, 1, 1, 2017);
//
// // タイプスタンプを表示
// echo $stamp;

// 2017年11月9日 18時23分12秒のタイムスタンプ
$stamp = mktime(18, 23, 12, 11, 9, 2017);

// タイプスタンプを表示
// 「1510248192」と秒数で表示されます
echo $stamp;
