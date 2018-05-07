/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normalclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author kawas
 */
/*
タイムスタンプの表示

「2016年11月4日 10時0分0秒」の情報を持つタイムスタンプ（ミリ秒）を生成し，画面に表示してください。
その後，さらにこの情報を「2016-11-04 10:00:00」の形式で画面に表示してください。
*/
public class normalclass3 {
    public static void main(String[] args) {
    final String FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

    Calendar cal = Calendar.getInstance();
    cal.set(2016, 11, 4, 10, 0, 0);
    SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_STRING);
    System.out.print(sdf.format(cal.getTime()));
    }
}
