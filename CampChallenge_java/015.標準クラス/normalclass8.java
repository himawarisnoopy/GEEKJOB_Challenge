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
ファイルの書き出しと保存
自己紹介の記述されたテキストファイルを作成してください。ファイルの作成は，File クラスなどを利用することによって行ってくださ
*/
public class normalclass8 {
    public static void main (String[] args){
     try{
         File fp = new File("myprofile.txt");
         // FileWriter作成
        FileWriter fw = new FileWriter(fp);
        // 書き込み
        fw.write("川崎美乃里です");
        // クローズ
        fw.close();
    }catch (IOException e){
        e.printStackTrace();
    }
     }

        
    
}
