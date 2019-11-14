package pl.pasepswirek;

import lombok.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor

public class EditDate {
//5. Edycja danych – pozycja 5 w menu
//Po wyświetleniu wszystkich danych o wszystkich pracownikach następuje wybór pracownika do edycji. Wybrany
//pracownik zostaje wyświetlony jeszcze raz (wyświetlanie specjalne), a użytkownik z nowego menu wybiera pole
//które chce edytować (istnieje możliwość edycji wszystkich pól poza płcią i imieniem, a nazwisko może być
//edytowane tylko w przypadku kobiet).
    private Scanner scanner = new Scanner(System.in);
    private ViewEmployee viewEmployee = new ViewEmployee();
    private List<Employee> employeeList = new ArrayList<>();
    public void editDate() throws IOException {
        employeeList = viewEmployee.getEmployeeList();
        for(int i =0; i<employeeList.size(); i++){
            System.out.println(i+". " +employeeList.get(i).viewAllDate());
        }

        try{
        System.out.println("Select the employee to edit");
        int index = scanner.nextInt();
        System.out.println(employeeList.get(index).viewAllDate());
        boolean exit =false;
        while (!exit){
            System.out.println("Select the field to edit");
            System.out.println("1 - Edit last name (only women)");
            System.out.println("2 - Edit departmend ID");
            System.out.println("3 - Edit salary");
            System.out.println("4 - Edit age");
            System.out.println("5 - Edit number of kids");
            System.out.println("6 - Edit marital status");
            System.out.println("0- BACK");
            int menu = scanner.nextInt();
            switch (menu){
                case 1:
                    if(employeeList.get(index).getSex() == 'F'){
                            System.out.println("New last name:");
                            String lastName = scanner.next().toUpperCase();
                        employeeList.get(index).setLastName(lastName);
                        System.out.println(employeeList.get(index).viewNameLastName());

                    }else{
                            System.out.println("Couldn't change last name for men!!");
                        }
                    break;
                case 2:
                    System.out.println("New departmend ID:");
                    int departmentID = scanner.nextInt();
                    employeeList.get(index).setDepartmentID(departmentID);

                    break;
                case 3:
                    System.out.println("New salary amount:");
                    double salary = scanner.nextDouble();
                    employeeList.get(index).setSalary(salary);
                    break;
                case 4:
                    System.out.println("New age value:");
                    int age = scanner.nextInt();
                    employeeList.get(index).setAge(age);
                    break;
                case 5:
                    System.out.println("New number of kids:");
                    int numberOfKids = scanner.nextInt();
                    employeeList.get(index).setNumberOfKids(numberOfKids);
                    break;
                case 6:
                    System.out.println("New marital status");
                    boolean maritalStatus = scanner.nextBoolean();
                    employeeList.get(index).setMaritalStatus(maritalStatus);
                    break;
                case 0:
                    exit =true;
                    break;
            }

        }
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.writeToFile(employeeList);


    }catch (IndexOutOfBoundsException e){
            System.out.println("No such index");
        }
    }
}
