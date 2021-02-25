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
import validate.Validate;

/**
 *
 * @author admin2
 */
public class ProjectTaskManager {

    List<ProjectTask> listProjectTask = new ArrayList<>();
    private final static String FILE_URLProjectTask = "C:\\Users\\admin2\\Documents\\NetBeansProjects\\SWT_group4\\inputProjectTask.txt";

    public List<ProjectTask> getListProjectTask() {
        return listProjectTask;
    }

    public void setListProjectTask(List<ProjectTask> listProjectTask) {
        this.listProjectTask = listProjectTask;
    }
    
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
    
    public void addProjectTask() {
        validate.Validate v = new Validate();
        System.out.println("Enter name:");
        String name = v.checkString();
        System.out.println("Enter due date:");
        Date dueDate = v.checkDueDate();
        System.out.println("Enter planned from date:");
        Date plannedFromDate = v.checkEndDate(dueDate);
        System.out.println("Enter planned to date:");
        Date plannedToDate =v.checkEndDate(plannedFromDate);
        System.out.println("Enter Assignee's UserCode: ");
        int code = v.checkInt();
        System.out.println("Enter status:");
        String status=v.checkStatus();
        ProjectTask p= new ProjectTask(listProjectTask.size()+1, name, dueDate, plannedFromDate, plannedToDate, code, status);
        listProjectTask.add(p);
        updateFile();
    }
    public void updateListProjectTask() {
        validate.Validate v = new validate.Validate();
        System.out.println("Enter id need to update :");
        int id = v.checkInt();
        for (ProjectTask p : listProjectTask) {
            if (p.getId() == id) {
                //chỗ này hơi ngu, nên tìm đến dòng chứa id này trong file rồi replace thì độ phức tạp thuật toán sẽ giảm rất nhiều.
                System.out.println("Enter name:");
                p.setName(v.checkString());
                System.out.println("Enter Due date:");
                p.setDue_date(v.checkDueDate());
                System.out.println("Enter Planned from date:");
                p.setPlannedfromdate(v.checkEndDate(p.getDue_date()));
                System.out.println("Enter Planned to date:");
                p.setPlannedtodate(v.checkEndDate(p.getPlannedfromdate()));
                System.out.println("Enter Assginee's usercode:");
                p.setAssigneeusercode(v.checkInt());
                System.out.println("Enter status:");
                p.setStatus(v.checkStatus());
                updateFile();
                return;
            }
        }
    }
    public void deleteProjectTask() {
        validate.Validate v = new validate.Validate();
        System.out.println("Enter id need to delete :");
        int id = v.checkInt();
        for (ProjectTask p : listProjectTask) {
            if (p.getId() == id) {
                listProjectTask.remove(p);
                updateFile();
                return;
            }
        }
    }
    public void updateFile() {
        try {
            OutputStream outputStream = new FileOutputStream(FILE_URLProjectTask);
            OutputStreamWriter write = new OutputStreamWriter(outputStream);
            for (ProjectTask l : listProjectTask) {
                write.write(l.getId() + "|" + l.getName() + "|" + l.getDue_date() + "|" + l.getPlannedfromdate() + "|" + l.getPlannedtodate() + "|" + l.getAssigneeusercode()+"|"+l.getStatus());
                write.write("\n");
            }
            write.flush();
        } catch (IOException e) {
            System.out.println("Error when uploadFile ProjectTask()");
        }
    }
    public void tasksInEachStatus(){
        int todo=0;
        int doing=0;
        int done=0;
        int cancelled=0;
        for(ProjectTask p:listProjectTask){
            if(p.getStatus().equals("Todo")){
                todo++;
            }else if(p.getStatus().equals("Doing")){
                doing++;
            }else if(p.getStatus().equals("Done")){
                done++;
            }else{
                cancelled++;
            }
        }
        System.out.println("Todo : "+todo);
        System.out.println("Doing : "+doing);
        System.out.println("Done : "+done);
        System.out.println("Cancelled : "+cancelled);
    }

    public void inforMember(List<Project> list){
        listProjectTask.forEach((pt) -> {
            list.stream().filter((p) -> (pt.getId()==p.getPmusercode())).forEachOrdered((p) -> {
                System.out.println("Name: "+p.getName()+" Customer: "+p.getCustomer() +" Project: "+pt.getName());
            });
        });
    }
    
}
