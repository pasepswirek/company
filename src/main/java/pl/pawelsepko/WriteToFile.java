package pl.pawelsepko;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {

    public void writeToFile(List<Employee> employeeList) throws IOException {
try{
        FileWriter fileWriter = new FileWriter("src\\main\\resources\\baza.dat");
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
    }catch (FileNotFoundException e){
    e.printStackTrace();
}
    }
}
