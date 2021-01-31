/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import validate.Validate;

/**
 *
 * @author admin2
 */
public class View {

    public void checkAuthen() {
        validate.Validate v = new Validate();
        controller.Controller c = new Controller();
        int typeLogin = v.Login();
        int enterChoose=0;
        switch(typeLogin){
            case 1:{
                c.menu(typeLogin);
                enterChoose=c.enterChoose(1, 6);
                break;
            }
            case 2:{
                c.menu(typeLogin);
                enterChoose=c.enterChoose(1, 3);
                break;
            }
            case 3:{
                c.menu(typeLogin);
                enterChoose=c.enterChoose(1, 3);
                break;
            }
            default:{
                System.out.println("Doesn't exist this account!");
            }
        }
    }
}
