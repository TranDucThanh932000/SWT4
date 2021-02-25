/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProjectManager;
import controller.ProjectTaskManager;
import controller.UserManager;
import validate.Validate;

/**
 *
 * @author admin2
 */
public class View {

    public void runSystem() {
        validate.Validate v = new Validate();
        view.Menu m = new Menu();
        ProjectManager pm = new ProjectManager();
        ProjectTaskManager ptm = new ProjectTaskManager();
        UserManager um = new UserManager();
        pm.inputListProject();
        ptm.inputListProjectTask();
        um.inputListUser();
        int typeLogin = v.Login();
        int enterChoose = 0;
        switch (typeLogin) {
            case 1: {
                m.menu(typeLogin);
                enterChoose = v.enterChoose(1, 6);
                switch (enterChoose) {
                    case 1: {
                        m.menuAdminOne();
                        enterChoose = v.enterChoose(1, 4);
                        switch (enterChoose) {
                            case 1: {
                                pm.viewListProject();
                                break;
                            }
                            case 2: {
                                pm.addProject();
                                break;
                            }
                            case 3: {
                                pm.updateListProject();
                                break;
                            }
                            case 4: {
                                pm.deleteProject();
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        m.menuAdminTwo();
                        enterChoose = v.enterChoose(1, 3);
                        switch (enterChoose) {
                            case 1: {
                                ptm.addProjectTask();
                                break;
                            }
                            case 2: {
                                ptm.updateListProjectTask();
                                break;
                            }
                            case 3: {
                                ptm.deleteProjectTask();
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        ptm.inforMember(pm.getListProject());
                        break;
                    }
                    case 4: {
                        m.menuAdminFour();
                        enterChoose = v.enterChoose(1, 5);
                        switch (enterChoose) {
                            case 1: {
                                um.viewList();
                                break;
                            }
                            case 2: {
                                um.addUser();
                                break;
                            }
                            case 3: {
                                um.updateListUser();
                                break;
                            }
                            case 4: {
                                um.deleteUser();
                                break;
                            }
                            case 5: {
                                um.changePassword();
                                break;
                            }
                        }
                        break;
                    }
                    case 5: {
                        ptm.tasksInEachStatus();
                        break;
                    }
                    case 6: {
                        m.menuAdminSix();
                        enterChoose = v.enterChoose(1, 2);
                        switch (enterChoose) {
                            case 1: {
                                System.exit(0);
                                break;
                            }
                            case 2: {
                                um.changePassword();
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case 2: {
                m.menu(typeLogin);
                enterChoose = v.enterChoose(1, 3);
                switch (enterChoose) {
                    case 1: {
                        m.menuAdminTwo();
                        break;
                    }
                    case 2: {
                        ptm.inforMember(pm.getListProject());
                        break;
                    }
                    case 3: {
                        ptm.tasksInEachStatus();
                        break;
                    }
                }
                break;
            }
            case 3: {
                m.menu(typeLogin);
                enterChoose = v.enterChoose(1, 3);
                switch (enterChoose) {
                    case 1: {
                        um.viewList();
                        break;
                    }
                    case 2: {
                        ptm.tasksInEachStatus();
                        break;
                    }
                    case 3: {
                        m.menuAdminSix();
                        enterChoose = v.enterChoose(1, 2);
                        switch (enterChoose) {
                            case 1: {
                                System.exit(0);
                                break;
                            }
                            case 2: {
                                um.changePassword();
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            default: {
                System.out.println("Doesn't exist this account!");
            }
        }
    }
}
