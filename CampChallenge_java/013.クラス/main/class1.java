package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kawas
 */
/*
以下の仕様を満たすクラスを作成してください。 
また，処理が正しく書かれていることを確認するために，作成したクラスを呼び出すクラス（以下，実行クラスといいます）を別途作成し，実行クラスからインスタンス化・メソッド呼び出し等を行ってください。 

■フィールド 
２つのフィールドを用意する。フィールドがどんな情報を持つかは，自由とする。 
■メソッド 
①以下の条件を満たすメソッド 
・引数 
　２つの引数を取る。データ型は，それぞれフィールドのデータ型と同じものとする。 
・戻り値　なし 
・処理内容 
　引数として受け取った２つの変数を，フィールドに格納する。 
②以下の条件を満たすメソッド 
・引数　なし 
・戻り値　なし 
・処理内容 
　２つのフィールドの値をそれぞれ画面に表示する。
*/
public class class1 {
    public String name;
    public String course;

    public void setStudent(String n, String c) {
        name = n;
        course = c;
    }

    public void printStudent() {
        System.out.println("名前: " + name);
        System.out.println("コース: " + course);
    }
}