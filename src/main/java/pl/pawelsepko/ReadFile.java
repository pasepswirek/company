package pl.pawelsepko;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    private List<Employee> employeeList = new ArrayList<>();
    public List<Employee> readFileDat() throws FileNotFoundException {
        try{
        Scanner file = new Scanner(new File("src\\main\\resources\\baza.dat"));
        while (file.hasNext()){
            String read = file.nextLine();
            String[] split = read.split(";");
            try{
                employeeList.add( new Employee(
                        split[0],
                        split[1],
                        split[2].charAt(0),
                        Integer.valueOf(split[3]),
                        Double.valueOf(split[4]),
                        Integer.valueOf(split[5]),
                        Integer.valueOf(split[6]),
                        Boolean.parseBoolean(split[7])
                ));

            }catch (NumberFormatException e) {
                System.out.println("Nie moge odczytac pozycji: '" + read + "'");
            }
        }
        return employeeList;
    }catch (FileNotFoundException e){
        e.printStackTrace();
    }
        return null;
    }
}
