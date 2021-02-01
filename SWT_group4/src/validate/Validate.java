/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import controller.UserManager;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import model.User;

/**
 *
 * @author admin2
 */
public class Validate {

    public int Login() {
        System.out.println("Enter username:");
        String username = checkString();
        System.out.println("Enter password:");
        String password = checkString();
        UserManager um = new UserManager();
        um.inputListUser();
        List<User> listUser = um.getListUser();
        for (User u : listUser) {
            if (username.equals(u.getUserName()) && password.equals(u.getPassword())) {
                return u.getType();
            }
        }
        return 0;
    }

    public Date checkDate() {
        do {
            try {
                Date date = Date.valueOf(checkString());
                return date;
            } catch (Exception e) {
                System.out.println("Error when checkDate " + e.getMessage());
            }
        } while (true);
    }

    public Date checkEndDate(Date startDate) {
        do {
            try {
                Date date = Date.valueOf(checkString());
                if (startDate.compareTo(date) > 0) {
                    System.out.println("Start date can not greater than End date! Enter again:");
                } else {
                    return date;
                }
            } catch (Exception e) {
                System.out.println("Error when checkEndDate " + e.getMessage());
            }
        } while (true);
    }
    public Date checkDueDate(){
        do{
            try {
                Date date= Date.valueOf(checkString());
                long millis=System.currentTimeMillis();  
                Date currentDate=new Date(millis);
                if(date.compareTo(currentDate) < 0){
                    System.out.println("The due date must be greater than or sequence the current date");
                }else{
                    return date;
                }
            } catch (Exception e) {
                System.out.println("Just enter yyyy-MM-dd. Enter again: ");
            }
        }while(true);
    }
    public String checkStatus(){
        do{
            try {
                String status=checkString();
                if(status.equalsIgnoreCase("Todo") || status.equalsIgnoreCase("Doing") || status.equalsIgnoreCase("Done") || status.equalsIgnoreCase("Cancelled") ){
                    return status;
                }else{
                    throw new Exception(" Doesn't exist this status! Enter again: ");
                }
            } catch (Exception e) {
                System.out.println("Error when checkStatus : "+e.getMessage());
            }
        }while(true);
    }
    public String checkString() {
        Scanner sc = new Scanner(System.in);
        do {
            String rs = sc.nextLine();
            if (!rs.equals("")) {
                return rs;
            }
        } while (true);
    }

    public int checkInt() {
        do {
            try {
                int n = Integer.parseInt(checkString());
                return n;
            } catch (Exception e) {
                System.out.println("Just enter id with int type! Enter again : ");
            }
        } while (true);
    }
    public static void main(String[] args) {
        Validate v= new Validate();
        int n=v.checkInt();
    }
}
