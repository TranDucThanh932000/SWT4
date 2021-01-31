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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import validate.Validate;

/**
 *
 * @author admin2
 */
public class ProjectManager {

    List<Project> listProject = new ArrayList<>();
    private final static String FILE_URLProject = "C:\\Users\\admin2\\Documents\\NetBeansProjects\\SWT_group4\\inputProject.txt";

    public List<Project> getListProject() {
        return listProject;
    }

    public void setListProject(List<Project> listProject) {
        this.listProject = listProject;
    }

    public void inputListProject() {
        try {
            File file = new File(FILE_URLProject);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            try {
                String line = "";
                while ((line = reader.readLine()) != null) {
                    String[] cut = line.split("\\|");
                    listProject.add(new Project(Integer.parseInt(cut[0]), cut[1], cut[2], Date.valueOf(cut[3]), Date.valueOf(cut[4]), Integer.parseInt(cut[5])));
                }
            } catch (Exception e) {
                System.out.println("Error when split string " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error when inputListProject() " + e.getMessage());
        }
    }

    public void addProject() {
        validate.Validate v = new Validate();
        System.out.println("Enter name:");
        String name = v.checkString();
        System.out.println("Enter customer:");
        String customer = v.checkString();
        System.out.println("Enter start date:");
        Date startDate = v.checkDate();
        System.out.println("Enter end date:");
        Date endDate = v.checkEndDate(startDate);
        System.out.println("Enter PM's UserCode");
        int code = Integer.parseInt(v.checkString());
        Project p = new Project(listProject.size() + 1, name, customer, startDate, endDate, code);
        listProject.add(p);
        updateFile();
    }

    public void updateFile() {
        try {
            OutputStream outputStream = new FileOutputStream(FILE_URLProject);
            OutputStreamWriter write = new OutputStreamWriter(outputStream);
            for(Project l:listProject){
                write.write(l.getId()+"|"+l.getName()+"|"+l.getCustomer()+"|"+l.getStart_date()+"|"+l.getEnd_date()+"|"+l.getPmusercode());
                write.write("\n");
            }
            write.flush();
        } catch (Exception e) {
            System.out.println("Error when uploadFile()");
        }
    }
    public static void main(String[] args) {
        ProjectManager pm= new ProjectManager();
        pm.inputListProject();

        pm.addProject();
    }
}
