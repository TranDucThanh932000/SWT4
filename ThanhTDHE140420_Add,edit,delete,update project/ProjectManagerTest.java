/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Project;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin2
 */
public class ProjectManagerTest {
    
    public ProjectManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getListProject method, of class ProjectManager.
     */
    //@Test

    /**
     * Test of inputListProject method, of class ProjectManager.
     */
    @Test
    public void testInputListProject() {
        System.out.println("inputListProject");
        ProjectManager instance = new ProjectManager();
        instance.inputListProject();
        int size = instance.getListProject().size();
        assertEquals(8, size);
    }

    /**
     * Test of addProject method, of class ProjectManager.
     */
    @Test
    public void testAddProject() {
        System.out.println("addProject");
        int id = 10;
        String namee = "test";
        String customerr = "test";
        String startdate = "2020-9-9";
        String enddate = "2020-9-9";
        int pm = 10;
        ProjectManager instance = new ProjectManager();
        instance.inputListProject();
        instance.addProject(id, namee, customerr, startdate, enddate, pm);
        int size=instance.getListProject().size();
        assertEquals(10, size);
    }

    /**
     * Test of viewListProject method, of class ProjectManager.
     */
    @Test
    public void testViewListProject() {
        System.out.println("viewListProject");
        ProjectManager instance = new ProjectManager();
        instance.inputListProject();
        int size=instance.getListProject().size();
        assertEquals(9, size);
    }


    /**
     * Test of updateListProject method, of class ProjectManager.
     */
    @Test
    public void testUpdateListProject() {
        System.out.println("updateListProject");
        int idd = 3;
        String name = "test";
        String customer = "testunit";
        String start = "2020-10-10";
        String end = "2020-12-12";
        int pm = 4;
        ProjectManager instance = new ProjectManager();
        instance.inputListProject();
        instance.updateListProject(idd, name, customer, start, end, pm);
        boolean f=instance.getListProject().get(2).getName().equals("test");;
        if(f==true){
            assertEquals(true, true);
        }else{
            assertEquals(false, true);
        }
    }

    /**
     * Test of deleteProject method, of class ProjectManager.
     */
    @Test
    public void testDeleteProject() {
        System.out.println("deleteProject");
        ProjectManager instance = new ProjectManager();
        int idd=9;
        instance.inputListProject();
        instance.deleteProject(idd);
        List<Project> list=instance.getListProject();
        for(Project p:list){
            if(idd==p.getId()){
                assertEquals(false, true);
                return;
            }
        }
        assertEquals(true, true);
    }

    /**
     * Test of updateFile method, of class ProjectManager.
     */
    @Test
    public void testUpdateFile() {
        System.out.println("updateFile");
        ProjectManager instance = new ProjectManager();
        instance.inputListProject();
        int size1 = instance.getListProject().size();
        int id = 9;
        String namee = "test";
        String customerr = "test";
        String startdate = "2020-9-9";
        String enddate = "2020-9-9";
        int pm = 9;
        instance.addProject(id, namee, customerr, startdate, enddate, pm);
        instance.updateFile();
        instance.inputListProject();
        int size2=instance.getListProject().size();
        if(size1==size2){
            assertEquals(true, false);
        }else{
            assertEquals(true, true);
        }
    }
    
}
