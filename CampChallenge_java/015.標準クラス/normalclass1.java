package normalclass;

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
タイムスタンプの作成
「2016年1月1日 0時0分0秒」の情報を持つタイムスタンプ（ミリ秒）を生成し，画面に表示してください。
*/

import java.util.Date;
import java.util.Calendar;

public class normalclass1 {
    public static void main(String[] args) {
        // カレンダーインスタンスの作成
        Calendar cal = Calendar.getInstance();
        cal.set(2016, 1, 1, 0, 0, 0);
        Date date = cal.getTime();
        System.out.print(cal.getTime());
        System.out.print(date);
        System.out.print(date.getTime());
    }
}
