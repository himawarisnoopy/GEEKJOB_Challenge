/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
現在の日時の表示

現在の日時を「1988年5月21日 1時23分45秒」といった形式で表現してください。
*/
package normalclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author kawas
 */
public class normalclass2_1 {
    
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        System.out.print(cal.get(Calendar.YEAR)+"年"+cal.get(Calendar.MONTH)+"月"+cal.get(Calendar.DAY_OF_MONTH)+"日"+
                cal.get(Calendar.HOUR_OF_DAY)+"時"+cal.get(Calendar.MINUTE)+"分"+cal.get(Calendar.SECOND)+"秒");
    }
       
}
