package pl.pasepswirek;

import java.io.IOException;
import java.util.Scanner;

public class AppCompany {

    public static void main(String[] args) throws IOException {
        System.out.println("Application supporting the organization in the company");
        Scanner scanner = new Scanner(System.in);
        ViewEmployee viewEmployee = new ViewEmployee();
        ExportFile exportFile = new ExportFile();


        boolean exit = false;
        while (!exit) {
            System.out.println("-- MENU --");
            System.out.println("1 - List of employee");//name, last name/ sex
            System.out.println("2 - Add new employee");
            System.out.println("3 - Export to file");
            System.out.println("4 - Delete employee");
            System.out.println("5 - Edit employee");
            System.out.println("6 - Salary");
            System.out.println("7 - Edit file");
            System.out.println("8 - About the program");
            System.out.println("9 - Rename file");
            System.out.println("0 - EXIT");
            System.out.println();
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    for (Employee employee : viewEmployee.getEmployeeList()) {
                        System.out.println(employee.viewNameLastNameSexDate());
                    }
                    break;
                case 2:
                    AddEmployee newEmployee = new AddEmployee();
                    newEmployee.addEmployee();
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Entry file name: ");
                    String fileName = scanner.nextLine();
                    exportFile.exportFileToTxt(fileName);
                    break;
                case 4:
                    DeleteEmployee deleteEmployee = new DeleteEmployee();
                    deleteEmployee.deleteEmployee();
                    break;
                case 5:
                    EditDate editDate = new EditDate();
                    editDate.editDate();
                    break;
                case 6:
                    PaymentCalculations paymentCalculations = new PaymentCalculations();
                    boolean exit1 = false;
                    while (!exit1) {
                        System.out.println("1 - Employees with a salary no less");
                        System.out.println("2 - Average salary in the department");
                        System.out.println("3 - Largest salary men/women");
                        System.out.println("5 - Average salary women/men");
                        System.out.println("6 - Incraase salary 10%");
                        System.out.println("7 - Incraase salary amount...:");
                        System.out.println("8 - Sort by last name");
                        System.out.println("9 - Sort by salary");
                        System.out.println("0 - BACK");
                        int menu1 = scanner.nextInt();
                        switch (menu1) {
                            case 1:
                                paymentCalculations.getLowerSalary();
                                break;
                            case 2:
                                paymentCalculations.avarageSalaryInDepartment();
                                break;
                            case 3:
                                paymentCalculations.largestSalary();
                                break;
                            case 5:
                                paymentCalculations.avaregeSalaryWomenMen();
                                break;
                            case 6:
                                paymentCalculations.riseSalary();
                                break;
                            case 7:
                                System.out.println(paymentCalculations.riseSalaryAmount());
                                break;
                            case 8:
                                paymentCalculations.sortLastName();
                                break;
                            case 9:
                                paymentCalculations.sortSalary();
                                break;
                            case 0:
                                exit1 = true;
                                break;
                        }
                    }

                    break;
                case 7:
                    AboutEmploee aboutEmploee = new AboutEmploee();
                    aboutEmploee.exportFileToTXT();
                    boolean exit2 = false;
                    while (!exit2) {
                        System.out.println("1 - View longer last name employee");
                        System.out.println("2 - Average age employees have kids");
                        System.out.println("3 - Encrypt last name");
                        System.out.println("4 - Html file");
                        System.out.println("0 - BACK");
                        int menu1 = scanner.nextInt();
                        switch (menu1) {
                            case 1:
                                aboutEmploee.longerLastName();
                                break;
                            case 2:
                                aboutEmploee.haveKidsAverageAge();
                                break;
                            case 3:
                                aboutEmploee.encryptLastName();
                                break;
                            case 4:
                                aboutEmploee.htmlFileGenerator();
                                break;
                            case 0:
                                exit2 = true;
                                break;
                        }
                    }
                    break;
                case 8:
                    AboutProgram aboutProgram = new AboutProgram();
                    aboutProgram.aboutProgram();
                    break;
                case 9:
                    RenameFile renameFile = new RenameFile();
                    renameFile.renameFile();
                    break;
                case 0:
                    exit = true;
                    System.out.println("EXIT PROGRAM");
                    break;
            }
        }
    }
}
