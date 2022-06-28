package Input;

import Menu.Menu;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Input {

    public static int inputinteger(String name, String error) {
        Scanner sc = new Scanner(System.in);
        int integer;
        do {
            try {
                System.out.print(name);
                integer = Integer.parseInt(sc.nextLine());
                if (integer < 0 || integer > 7) {
                    throw new Exception();
                }
                return integer;
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
    }

//////////////////////////////////////////////////////////////////////////////////
    public static String inputstring(String name, String error) {
        Scanner sc = new Scanner(System.in);
        String arr;
        do {
            try {
                System.out.print(name);
                arr = sc.nextLine();
                if (arr.isEmpty() || arr.isBlank()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
        return arr;
    }
/////////////////////////////////////////////////////////////////////////////////

    public static String inputStringWith_REGEX(String name, String ktra, String error) {
        String a;
        boolean kt;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(name);
            a = sc.nextLine().trim();
            if (a.isEmpty() || a.isBlank()) {
                System.out.println("ID can not empty/blank");
            } else {
                kt = a.matches(ktra);
                if (a.length() == 0 || kt == false || a.isEmpty()) {
                    System.out.println(error);
                } else {
                    return a;
                }
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////
    public static int inputASK(String name, String error) {
        Scanner sc = new Scanner(System.in);
        int integer;
        do {
            try {
                System.out.print(name);
                integer = Integer.parseInt(sc.nextLine());
                if (integer != 1 && integer != 2) {
                    throw new Exception();
                }
                return integer;
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
    }
////////////////////////////////////////////////////////////////////////////////////

    public static int ktrDate(String nd) {
        try {
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
//            sf.setLenient(false);
            Date dd = sf.parse(nd);
            if (dd.compareTo(sf.parse(sf.format(date))) >= 0) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
//////////////////////////////////////////////////////////////////////////////////////

    public static String inputFielName() {
        System.out.println("Your file will be saved as 'file.txt' ");
        String fileName = inputstring("Only enter name of File: ", "Name of file can't be empty/blank").toUpperCase();
        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }
        return fileName;
    }

////////////////////////////////////////////////////////////////////////////////////
    public static String inputDate1() {
        Scanner sc = new Scanner(System.in);
        String inputdate;
        Date workdate;
        Date today = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        sf.setLenient(false);
        do {
            try {
                inputdate = inputstring("Enter the date of the first vaccination (dd/MM/yyyy): ", "Date can not be empty!");
                workdate = sf.parse(inputdate);
                
                return inputdate;

            } catch (Exception e) {
                System.out.println("--> Invalid date!!!");
                System.out.println("--> Please input the correct date and must be in the format (dd/MM/yyyy)");
            }
        } while (true);
    }

    public static String inputDate2() {
        Scanner sc = new Scanner(System.in);
        String inputdate;
        Date workdate;
        Date today = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        sf.setLenient(false);
        do {
            try {
                inputdate = inputstring("Enter the date of the second vaccination (dd/MM/yyyy): ", "Date can not be empty!");
                workdate = sf.parse(inputdate);

                return inputdate;

            } catch (Exception e) {
                System.out.println("--> Invalid date!!!");
                System.out.println("--> Please input the correct date and must be in the format (dd/MM/yyyy)");
            }
        } while (true);
    }
///////////////////////////////////////////////////////////////////////////////////

    public boolean askmenu() {
        Menu menu = new Menu();
        boolean option = false;
        menu.add("Yes");
        menu.add("No");
        int choice;
        do {
            choice = menu.getASKuser();
            switch (choice) {
                case 1:
                    option = true;
                    break;
                case 2:
                    option = false;
                    break;
            }
        } while (choice != 1 && choice != 2);
        return option;
    }
}
