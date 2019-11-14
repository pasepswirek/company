package pl.pasepswirek;

import lombok.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
//Usuwanie pracowników – pozycja 4 w menu
//Po wyświetleniu wszystkich danych o wszystkich pracownikach następuje wybór pracownika do usunięcia.

public class DeleteEmployee {

    private Scanner scanner = new Scanner(System.in);
    private ViewEmployee viewEmployee = new ViewEmployee();
    private List<Employee> employeeList = viewEmployee.getEmployeeList();

    public void deleteEmployee() {
        List<Employee> employeeListAfterRemove;
        try {

            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println(i + ". " + employeeList.get(i).viewNameLastNameSexDate());
            }
            System.out.println("Select employee to delete: ");
            int index = scanner.nextInt();
 employeeList.remove(index);
            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println(i + ". " + employeeList.get(i).viewNameLastNameSexDate());
            }
            WriteToFile writeToFile = new WriteToFile();
            writeToFile.writeToFile(employeeList);

            System.out.println("Deleted successfully. \nDelete next employee (y/n):");
            String decision = scanner.next();
            if (decision.equals("y")) {
                deleteEmployee();
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index not exist!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
