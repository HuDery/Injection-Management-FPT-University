package Menu;

import java.util.Scanner;

public class MenuAskUser {

    private String[] choices;
    private int length;
    private int n = 0;
    
    public MenuAskUser(int size) {
        if (size < 1) {
            size = 10;
        }
        this.length = size;
        choices = new String[size];
    }
   
    public void add(String choice) {
        if (n < choices.length) {
            choices[n++] = choice;
        }
    }
    
    public static int Choose(String name, String error, int min, int max) {
        Scanner sc = new Scanner(System.in);
        if (min > max) {
            int tmp = max;
            min = max;
            max = tmp;
        }
        int n;
        while (true) {
            try {
                System.out.print(name);
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }
    
        
}
