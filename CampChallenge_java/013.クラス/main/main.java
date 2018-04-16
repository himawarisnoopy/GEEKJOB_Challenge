/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author kawas
 */
public class main {
    public static void main(String args[]){
        class2 hito1 = new class2();
        hito1.setStudent("川崎","メンター1");
        hito1.printStudent();
        hito1.clearStudent();
        hito1.printStudent();
        
        class2 hito2 =new class2();
        hito2.setStudent("美乃里","メンター2");
        hito2.printStudent();
        hito2.clearStudent();
        hito2.printStudent();
    }
}
