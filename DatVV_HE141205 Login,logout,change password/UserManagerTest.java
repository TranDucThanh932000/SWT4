/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoath
 */
public class UserManagerTest {

    public UserManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String name = "dat1";
        String pass = "123456as";
        int type = 1;
        UserManager instance = new UserManager();
        instance.inputListUser();
        instance.addUser(name, pass, type);
        int size = instance.getListUser().size();
        assertEquals(7, size);
    }

    /**
     * Test of updateListUser method, of class UserManager.
     */
    @Test
    public void testUpdateListUser() {
        System.out.println("updateListUser");
        UserManager instance = new UserManager();
        int code = 1;
        String username = "tranducthanh";
        String password = "a123456";
        int type = 1;
        instance.inputListUser();
        instance.updateListUser(code, username, password, type);
        boolean f = instance.getListUser().get(1).getPassword().equals("a123456");
        assertEquals("a12345", f);
    }

    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        UserManager instance = new UserManager();
        int id = 7;
        instance.inputListUser();
        instance.deleteUser(id);
        List<User> list = instance.getListUser();
        for (User u : list) {
            if (id == u.getUserCode()) {
                assertEquals(false, true);
                return;
            }
        }
        assertEquals(true, true);
    }

    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        UserManager instance = new UserManager();
        String username = "goodgame";
        String rePassword = "a12345";
        instance.inputListUser();
        instance.changePassword(username, rePassword);

        List<User> list = instance.getListUser();
        for (User u : list) {
            if (username.equals(u.getUserName())) {
                if (rePassword.equals(u.getPassword())) {
                    assertEquals(true, true);
                    return;
                } else {
                    assertEquals(true, false);
                }
            }
        }
    }

    @Test
    public void testViewList() {
        System.out.println("View list user");
        UserManager instance = new UserManager();
        instance.inputListUser();
        int size = instance.getListUser().size();
        assertEquals(6, size);
    }

}
