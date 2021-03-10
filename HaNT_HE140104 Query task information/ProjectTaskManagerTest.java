/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Project;
import model.ProjectTask;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin2
 */
public class ProjectTaskManagerTest {
    
    public ProjectTaskManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    /**
     * Test of inforMember method, of class ProjectTaskManager.
     */
    @Test
    public void testInforMember() {
        System.out.println("inforMember");
        ProjectTaskManager ptm = new ProjectTaskManager();
        ProjectManager pm = new ProjectManager();
        ptm.inputListProjectTask();
        List<ProjectTask> list1 = ptm.getListProjectTask();
        pm.inputListProject();
        List<Project> list2 = pm.getListProject();
        if(list1.isEmpty() || list2.isEmpty()){
            assertEquals(false, true);
        }else{
            assertEquals(true, true);
            ptm.inforMember(list2);
        }
    }
    
}
