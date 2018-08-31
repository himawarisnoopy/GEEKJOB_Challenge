/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author kawas
 */
public class UserDataBeans implements Serializable{
    
    //フィールドのカプセル化
    private String name;
    private int year;
    private int month;
    private int day;
    private int type;
    private String tell ;
    private String comment;
    
    //コンストラクタ
    public UserDataBeans(){
        this.name = "";
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.tell = "";
        this.type = 0;
        this.comment= "";
    }
    
    //入力に何もないなら（空白のみも）フィールドに空文字をセット
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        
        //trimは空白消去
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }

    public int getYear() {
        return year;
    }
    public void setYear(String year) {
        //初期選択状態の場合0をセット
        if(year.equals("")){
            this.year = 0;
        }else{
            this.year = Integer.parseInt(year);
        }
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(String month) {
        if(month.equals("")){
            this.month = 0;
        }else{
            this.month = Integer.parseInt(month);
        }
    }

    public int getDay() {
        return day;
    }
    public void setDay(String day) {
        if(day.equals("")){
            this.day = 0;
        }else{
            this.day = Integer.parseInt(day);
        }
    }

    public String getTell() {
        return tell;
    }
    public void setTell(String tell) {
        if(tell.trim().length()==0){
            this.tell = "";
        }else{
            this.tell = tell;
        }
    }

    public int getType() {
        return type;
    }
    public void setType(String type) {
        if(type == null){
            this.type = 0;
        }else{
            this.type = Integer.parseInt(type);
        }

    }
    
    public String getTypeName() {
        switch(this.type) {
            case 1:
                return "エンジニア";
            case 2:
                return "営業";
            case 3:
                return "その他";
        }
        
        return "";
    }
    
    public void setComment(String cmt) {
        this.comment = cmt;
    }
    public String getComment() {
        return this.comment;
    }
    
    public boolean check(){
        if(this.name.equals("") || this.tell.equals("") || this.comment.equals("") ||this.year == 0 || this.month == 0 || this.day == 0 || this.type == 0){
            return false;
        }
        return true;
    }
    public Calendar getBirthday() {
        Calendar c = Calendar.getInstance();
        c.set(this.year, this.month-1, this.day);
        return c;
    }
    
}
