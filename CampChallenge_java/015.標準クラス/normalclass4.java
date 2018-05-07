/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normalclass;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author kawas
 */
/*
タイムスタンプの表示
2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示してください。
*/
public class normalclass4 {
    public static void main(String[] args){
    Calendar cal1 = Calendar.getInstance();
    cal1.set(2015, 1, 1, 0, 0, 0);
    Date date1 = cal1.getTime();
    Calendar cal2 = Calendar.getInstance(); 
    cal2.set(2015, 12, 31, 23, 59, 59);
    Date date2 = cal2.getTime();
    System.out.print(date1.getTime() - date2.getTime());
        
    }
    
}
