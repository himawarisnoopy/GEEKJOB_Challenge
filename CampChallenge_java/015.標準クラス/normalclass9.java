/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normalclass;
import java.io.*;

/**
 *
 * @author kawas
 */
/*
ファイルから読み出しと表示
課題「ファイルの書き出しと保存」で作成したテキストファイルを読み込み，その内容を画面に表示してください。
*/
public class normalclass9 {
   public static void main (String[] args){
     try{
         File fp = new File("myprofile.txt");
         // FileReader作成
         FileReader fr = new FileReader(fp);
        // 書き込み
        // BufferedReader作成
        BufferedReader br = new BufferedReader(fr);
        System.out.print(br.readLine());
        // クローズ
        fr.close();
    }catch (IOException e){
        e.printStackTrace();
    }
   }
    
}
