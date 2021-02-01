/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import model.ProjectTask;
import model.User;
import validate.Validate;

/**
 *
 * @author admin2
 */
public class UserManager {

    List<User> listUser = new ArrayList<>();
    private final static String FILE_URLUser = "C:\\Users\\admin2\\Documents\\NetBeansProjects\\SWT_group4\\inputUser.txt";

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    public void inputListUser() {
        try {
            File file = new File(FILE_URLUser);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            try {
                String line = "";
                while ((line = reader.readLine()) != null) {
                    String[] cut = line.split("\\|");
                    listUser.add(new User(Integer.parseInt(cut[0]), cut[1], cut[2], Integer.parseInt(cut[3])));
                }
            } catch (Exception e) {
                System.out.println("Error when split string " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error when inputListUser() " + e.getMessage());
        }
        setListUser(listUser);
    }

    public void addUser() {
        validate.Validate v = new Validate();
        System.out.println("Enter user name:");
        String name = v.checkString();
        System.out.println("Enter password:");
        String password = v.checkPassword();
        System.out.println("Enter type:");
        int type = v.checkType();
        User u = new User(listUser.size() + 1, name, password, type);
        listUser.add(u);
        updateFile();
    }
    
    public void updateListUser() {
        validate.Validate v = new validate.Validate();
        System.out.println("Enter id need to update :");
        int code = v.checkInt();
        for (User u : listUser) {
            if (u.getUserCode() == code) {
                //chỗ này hơi ngu, nên tìm đến dòng chứa id này trong file rồi replace thì độ phức tạp thuật toán sẽ giảm rất nhiều.
                u.setUserName(v.checkUserName());
                u.setPassword(v.checkPassword());
                u.setType(v.checkType());
                updateFile();
                return;
            }
        }
    }
    public void deleteUser() {
        validate.Validate v = new validate.Validate();
        System.out.println("Enter code need to delete :");
        int code = v.checkInt();
        for (User u : listUser) {
            if (u.getUserCode() == code) {
                listUser.remove(u);
                updateFile();
                return;
            }
        }
    }
    public void changePassword(){
        validate.Validate v = new validate.Validate();
        System.out.println("Enter username need to change password :");
        String username=v.checkUserName();
        for (User u : listUser) {
            if (u.getUserName().equalsIgnoreCase(username)) {
                u.setPassword(v.checkPassword());
                updateFile();
                return;
            }
        }
    }
    public void viewList(){
        for(User u:listUser){
            System.out.println(u);
        }
    }
    
    public void updateFile() {
        try {
            OutputStream outputStream = new FileOutputStream(FILE_URLUser);
            OutputStreamWriter write = new OutputStreamWriter(outputStream);
            for (User u : listUser) {
                write.write(u.getUserCode() + "|" + u.getUserName() + "|" + u.getPassword() + "|" + u.getType());
                write.write("\n");
            }
            write.flush();
        } catch (IOException e) {
            System.out.println("Error when uploadFile User");
        }
    }

}
