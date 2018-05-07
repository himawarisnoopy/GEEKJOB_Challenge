/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normalclass;

/**
 *
 * @author kawas
 */
/*
バイト数と文字数の取得
自分の氏名について，バイト数と文字数を取得してください。また，それぞれの値を画面に表示してください。
*/
public class normalclass5 {
    public static void main(String[] args){
        String name = "川崎美乃里";
        System.out.println("バイト数: " + name.getBytes().length);
        System.out.print("文字数：" + name.length());
        
    }
    
}
