<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ナベアツ課題</title>
</head>
<body>
	<h1>ナベアツ課題</h1>
       <?php
        //　----------ここから下へソースコードを書く------------
				$num = 1;
        while($num<=20){
					echo $num;
					if( ($num %3 == 0||strpos($num,'3') !== false)&&$num%5==0){
						echo "アホ犬になる";
					}else if($num %3 == 0||strpos($num,'3') !== false){
						echo "アホになる";
					}else if($num%5==0){
						echo "犬っぽくなる";
					}
			 echo "<br>";
       $num++;
    }


       //　-------------------------ここまで------------------------------
        ?>
</body>
</html>
