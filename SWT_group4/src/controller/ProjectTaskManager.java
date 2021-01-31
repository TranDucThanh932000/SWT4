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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.ProjectTask;

/**
 *
 * @author admin2
 */
public class ProjectTaskManager {

    List<ProjectTask> listProjectTask = new ArrayList<>();
    private final static String FILE_URLProjectTask = "C:\\Users\\admin2\\Documents\\NetBeansProjects\\SWT_group4\\inputProjectTask.txt";

    public void inputListProjectTask() {
        try {
            File file = new File(FILE_URLProjectTask);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            try {
                String line = "";
                while ((line = reader.readLine()) != null) {
                    String[] cut = line.split("\\|");
                    listProjectTask.add(new ProjectTask(Integer.parseInt(cut[0]), cut[1], Date.valueOf(cut[2]), Date.valueOf(cut[3]), Date.valueOf(cut[4]), Integer.parseInt(cut[5]), cut[6]));
                }
            } catch (Exception e) {
                System.out.println("Error when split string " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error when inputListProjectTask() " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        ProjectTaskManager ptm=new ProjectTaskManager();
        ptm.inputListProjectTask();
        List<ProjectTask> list = ptm.listProjectTask;
        for(ProjectTask l:list){
            System.out.println(l);
        }
    }
}
