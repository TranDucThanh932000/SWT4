/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UserManager;
import java.util.List;
import java.util.Scanner;
import model.User;
import validate.Validate;

/**
 *
 * @author admin2
 */
public class Menu {

    public void menu(int type) {
        if (type == 1) {
            System.out.println("1- View list, add, update, delete project");
            System.out.println("2- Add, update, delete task information of a specific project");
            System.out.println("3- Query task information for a specific member, group by project");
            System.out.println("4- View list, add, update, delete user; change user’s password");
            System.out.println("5- Query & print out the projects task statistics: project effort, "
                    + "number of tasks in each status (Todo, Doing, Done, Cancelled)");
            System.out.println("6- Login, Logout, change user’s password");
        }
        if (type == 2) {
            System.out.println("1- Add, update, delete task information of a specific project");
            System.out.println("2- Query task information for a specific member, group by project");
            System.out.println("3- Query & print out the projects task statistics: project effort, "
                    + "number of tasks in each status (Todo, Doing, Done, Cancelled)");
        }
        if (type == 3) {
            System.out.println("1- Query task information for a specific member, group by project");
            System.out.println("2- Query & print out the projects task statistics: project effort, "
                    + "number of tasks in each status (Todo, Doing, Done, Cancelled)");
            System.out.println("3- Login, Logout, change user’s password");
        }
    }
    public void menuAdminOne(){
        System.out.println("1- View list");
        System.out.println("2- Add project");
        System.out.println("3- Update project");
        System.out.println("4- Delete project");
    }
    public void menuAdminTwo(){
        System.out.println("1- Add project task");
        System.out.println("2- Update project task");
        System.out.println("3- Delete project task");
    }
    public void menuAdminFour(){
        System.out.println("1- View list user");
        System.out.println("2- Add user");
        System.out.println("3- Update user");
        System.out.println("4- Delete user");
        System.out.println("5- Change user's password");
    }
    public void menuAdminSix(){
        System.out.println("1- Logout");
        System.out.println("2- Change user's password");
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
