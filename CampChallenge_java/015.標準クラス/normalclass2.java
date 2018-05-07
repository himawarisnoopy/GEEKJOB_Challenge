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
現在の日時の表示

現在の日時を「1988年5月21日 1時23分45秒」といった形式で表現してください。
*/

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class normalclass2 {
    
    public static void main(String[] args) {
    final String FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

    SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_STRING);
    Calendar cal = Calendar.getInstance();
    System.out.print(sdf.format(cal.getTime()));
    }
}
