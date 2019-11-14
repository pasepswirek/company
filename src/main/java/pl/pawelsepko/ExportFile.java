package pl.pawelsepko;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//Eksport – pozycja 3 w menu. Eksport pliku elementowego (obiektów) do pliku tekstowego (nazwa pliku
//tekstowego jest podawana przez użytkownika) w postaci:
//nazwisko imię płeć numer_działu płaca wiek liczba_dzieci
public class ExportFile {
    private ReadFile readFile = new ReadFile();
    private List<Employee> employeeList = new ArrayList<>();

    public void exportFileToTxt(String fileName) throws FileNotFoundException {
        employeeList = readFile.readFileDat();
       fileName= fileName.replace(" ", "_");
        try{
            FileWriter fileWriter = new FileWriter("src\\main\\resources\\"+fileName+".txt");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for(int i=0; i<employeeList.size(); i++){
                bw.write(
                        employeeList.get(i).getName()+";"+
                                employeeList.get(i).getLastName()+";"+
                                employeeList.get(i).getSex()+";"+
                                employeeList.get(i).getDepartmentID()+";"+
                                employeeList.get(i).getSalary()+";"+
                                employeeList.get(i).getAge()+";"+
                                employeeList.get(i).getNumberOfKids()+";"+
                                employeeList.get(i).isMaritalStatus());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
