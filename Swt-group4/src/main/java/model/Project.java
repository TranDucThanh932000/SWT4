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
public class Project {
    private int id;
    private String name;
    private String customer;
    private Date start_date;
    private Date end_date;
    private int pmusercode;

    public Project() {
    }

    public Project(int id, String name, String customer, Date start_date, Date end_date, int pmusercode) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.start_date = start_date;
        this.end_date = end_date;
        this.pmusercode = pmusercode;
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getPmusercode() {
        return pmusercode;
    }

    public void setPmusercode(int pmusercode) {
        this.pmusercode = pmusercode;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + customer + "\t" + start_date + "\t" + end_date + "\t" + pmusercode;
    }
    
}
