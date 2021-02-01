/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author admin2
 */
public class ProjectTask {
    private int id;
    private String name;
    private Date due_date;
    private Date plannedfromdate;
    private Date plannedtodate;
    private int assigneeusercode;
    private String status;

    public ProjectTask() {
    }

    public ProjectTask(int id, String name, Date due_date, Date plannedfromdate, Date plannedtodate, int assigneeusercode, String status) {
        this.id = id;
        this.name = name;
        this.due_date = due_date;
        this.plannedfromdate = plannedfromdate;
        this.plannedtodate = plannedtodate;
        this.assigneeusercode = assigneeusercode;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getPlannedfromdate() {
        return plannedfromdate;
    }

    public void setPlannedfromdate(Date plannedfromdate) {
        this.plannedfromdate = plannedfromdate;
    }

    public Date getPlannedtodate() {
        return plannedtodate;
    }

    public void setPlannedtodate(Date plannedtodate) {
        this.plannedtodate = plannedtodate;
    }

    public int getAssigneeusercode() {
        return assigneeusercode;
    }

    public void setAssigneeusercode(int assigneeusercode) {
        this.assigneeusercode = assigneeusercode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    @Override
    public String toString() {
        return name + "\t" + due_date + "\t" + plannedfromdate + "\t" + plannedtodate + "\t" + assigneeusercode + "\t" + status;
    }
    
}
