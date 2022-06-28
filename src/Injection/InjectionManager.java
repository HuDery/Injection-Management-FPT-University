package Injection;

import Menu.Menu;

public class InjectionManager {

    public static void main(String[] args) {   
        Menu menu = new Menu();
        menu.add("\nWelcome to Injection Management - @ 2021 by <SE150233 - Le Ha Duy >");
        menu.add("Select the options below:");
        menu.add("1. Show information all students have been injected");
        menu.add("2. Add student's vaccine injection information");
        menu.add("3. Updating information of students' vaccine injection");
        menu.add("4. Delete student vaccine injection information");
        menu.add("5. Search for injection information by studentID");
        menu.add("6. Store injection data to file");
        menu.add("7. Others- Quit");
        int choice;
        InjectionList list = new InjectionList();
        do {
            choice = menu.getUserChoice();
            switch(choice){
                case 1: list.printAllStudent();break;
                case 2: list.addInjection(); break;
                case 3: list.updateInjectionbyID(); break;
                case 4: list.deletedbyInjectionID(); break;
                case 5: list.searchAllInforStudent(); break;
                case 6: list.saveFile("injection.dat"); break;
            }
        } while (choice > 0 && choice < 7);
    }
}
