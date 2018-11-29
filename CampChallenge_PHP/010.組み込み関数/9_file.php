<?php
//ファイルから読み出しと表示
//ファイルから自己紹介を読み出し、表示してください。

$fp = fopen('profile.txt', 'r');
// きちんと開けたら
if ($fp != false) {
    // １行読み出し
    echo fgets($fp);
    // 書いたら、閉じる
    fclose($fp);
}
