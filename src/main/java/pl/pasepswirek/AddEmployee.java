package pl.pasepswirek;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//Możliwość dodawania nowych pracowników – pozycja 2 w menu.
public class AddEmployee {
    private Scanner scanner = new Scanner(System.in);
    private ViewEmployee viewEmployee = new ViewEmployee();

    public void addEmployee() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("src\\main\\resources\\baza", true);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            List<Employee> employeeList = viewEmployee.getEmployeeList();

            System.out.println("Add new employee");
            System.out.println("Give name");
            String name = scanner.next();
            System.out.println("Give last name");
            String lastName = scanner.next();
            System.out.println("Give sex");
            char sex = scanner.next().toUpperCase().charAt(0);
            System.out.println("Give department ID");
            int departmentId = scanner.nextInt();
            System.out.println("Give salary");
            double salary = scanner.nextDouble();
            System.out.println("Give age");
            int age = scanner.nextInt();
            System.out.println("Give number of kids");
            int kids = scanner.nextInt();
            System.out.println("Give marital status");
            boolean maritalStatus = scanner.nextBoolean();
            Employee employee = new Employee(name, lastName, sex, departmentId, salary, age, kids, maritalStatus);
            bw.write(name + ";" + lastName + ";" + sex + ";" + departmentId + ";" + salary + ";" + age + ";" + kids + ";" + maritalStatus);
            bw.newLine();
            bw.close();
            System.out.println("Add employee: ");
            System.out.println(employee.viewAllDate());
            System.out.println("Add next employee(y/n):");
            String decysion = scanner.next().toLowerCase();
            if (decysion.equals("y")) {
                addEmployee();
            }
            employeeList.add(employee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
