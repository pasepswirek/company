package pl.pawelsepko;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        for (Employee employee : readFile.readFileDat()) {
            System.out.println(employee.viewNameLastNameSexDate());
        }
//
//        StringBuilder str = new StringBuilder("Java Util Package");
//        System.out.println("string = " + str);
//
//        // replace substring from index 5 to index 9
//        str.replace(5, 9, "Lang");
//
//        // prints the StringBuilder after replacing
//        System.out.println("After replacing: " + str);
//    }
//    public static void main(String[] args) {
//        Map<Integer, String> mainMenu = new HashMap<>();
//        mainMenu.put(1, "List of employee");
//        mainMenu.put(2, "Add new employee");
//        mainMenu.put(3, "Export to file (date one employee)");
//        mainMenu.put(4, "Delete employee");
//        mainMenu.put(5, "Edit employee");
//        mainMenu.put(6, "Salary");
//        mainMenu.put(7, "Edit file");
//        mainMenu.put(8, "About the program");
//        mainMenu.put(9, "Rename file");
//        mainMenu.put(0, "EXIT");
//        Scanner scanner = new Scanner(System.in);
//        boolean exit = false;
//        while (!exit){
//        for(Map.Entry<Integer, String> entry: mainMenu.entrySet()){
//
//            System.out.println(entry.getKey()+" - "+entry.getValue());
//        }
//            int menu = scanner.nextInt();
//        exit = true;
//
//    }
   }
}
