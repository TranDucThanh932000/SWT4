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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import model.User;

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
}
