<?php

//ファイルの書き出しと保存
//ファイルに自己紹介を書き出し、保存してください。

$fp = fopen('profile.txt', 'w');
if ($fp != false) {
    // ファイルに書き込み
    fwrite($fp, '川崎美乃里です');
    // 書いたら、閉じる
    fclose($fp);
}
