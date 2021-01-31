/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.Scanner;
import model.User;
import validate.Validate;

/**
 *
 * @author admin2
 */
public class Controller {

    public void menu(int type) {
        if (type == 1) {
            System.out.println("1- View list, add, update, delete project");
            System.out.println("2- Add, update, delete task information of a specific project");
            System.out.println("3- Query task information for a specific member, group by project");
            System.out.println("4- View list, add, update, delete user; change user’s password");
            System.out.println("5- Query & print out the projects task statistics: project effort,\n"
                    + "number of tasks in each status (Todo, Doing, Done, Cancelled)");
            System.out.println("6- Login, Logout, change user’s password");
        }
        if (type == 2) {
            System.out.println("1- Add, update, delete task information of a specific project");
            System.out.println("2- Query task information for a specific member, group by project");
            System.out.println("3- Query & print out the projects task statistics: project effort,\n"
                    + "number of tasks in each status (Todo, Doing, Done, Cancelled)");
        }
        if (type == 3) {
            System.out.println("1- Query task information for a specific member, group by project");
            System.out.println("2- Query & print out the projects task statistics: project effort,\n"
                    + "number of tasks in each status (Todo, Doing, Done, Cancelled)");
            System.out.println("3- Login, Logout, change user’s password");
        }
    }

    public int enterChoose(int min, int max) {
        Scanner sc = new Scanner(System.in);
        validate.Validate v= new Validate();
        int n = 0;
        do {
            try {
                System.out.println("Enter your choose:");
                n = Integer.parseInt(v.checkString());
                if(n< min || n > max){
                    System.out.println("Warning: n >= "+min+" && n <= "+max);
                }
            } catch (Exception e) {
                System.out.println("Error when input enterChoose, Enter again! "+e.getMessage());
            }
        } while (n < min || n > max);
        return n;
    }
    public static void main(String[] args) {
        UserManager u= new UserManager();
        u.inputListUser();
        List<User> list=u.getListUser();
        for(User l:list){
            System.out.println(l);
        }
    }
}
