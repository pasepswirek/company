package pl.pawelsepko;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
//Dodatkowe funkcje – pozycja 6 w menu.
public class PaymentCalculations {
    private Scanner scanner = new Scanner(System.in);
    private ViewEmployee viewEmployee = new ViewEmployee();
    private List<Employee> employeeList = viewEmployee.getEmployeeList();
   private WriteToFile writeToFile = new WriteToFile();
//a) Obliczanie liczby pracowników z pensją nie mniejszą niż podana przez użytkownika // funkcja z parametrem
//float – podana pensja.
    public void getLowerSalary(){
        System.out.println("Enter the amount: ");
        double amount = scanner.nextDouble();
        int countEmployee=0;
        for (Employee employee : employeeList) {
            if(employee.getSalary()>=amount){
                countEmployee++;
            }
        }
        System.out.println("Number of employees with a salary less than "+amount+" : " +countEmployee);
    }
    //Obliczanie średniej płacy w dziale (numer działu podaje użytkownik) // funkcja z parametrem int – podany
    //numer działu.
    public void avarageSalaryInDepartment(){
        System.out.println("Enter the department number: ");
        int departmentId = scanner.nextInt();
        System.out.println(departmentId);
        double average;
        int count = 0;
        double suma = 0;
        for (Employee employee : employeeList) {
            if(employee.getDepartmentID()==departmentId){
                count++;
                suma=suma+employee.getSalary();
            }
        }
        average=suma/count;
        System.out.println("Average salary in the department "+departmentId+": "+average);
    }

    //Wyświetlanie największych pensji z wszystkich kobiety i wszystkich mężczyzny // procedura bez
    //dodatkowych parametrów.
    public void largestSalary(){
        double maxSalaryMen = 0;
        double maxSalarWomen = 0;
        for (int i=0; i<employeeList.size(); i++) {
            if(employeeList.get(i).getSex()=='F'){
                if(employeeList.get(i).getSalary()>maxSalarWomen){
                    maxSalarWomen=employeeList.get(i).getSalary();
             }
                 }
            if(employeeList.get(i).getSex()=='M'){
                if(employeeList.get(i).getSalary()>maxSalaryMen){
                    maxSalaryMen=employeeList.get(i).getSalary();
                }
            }
        }
        System.out.println("Max salary to women: " +maxSalarWomen);
        System.out.println("Max salary to men: " +maxSalaryMen);
    }
    //Wyświetlenie stosunku średniej płacy kobiet do średniej płacy mężczyzn // funkcja bez dodatkowych
    //parametrów.
    public void avaregeSalaryWomenMen(){
        double averageSalaryMen;
        double averageSalaryWomen;
        int countMen = 0;
        int countWomen = 0;
        double sumaMen = 0;
        double sumaWomen = 0;
        for (Employee employee : employeeList) {
            if(employee.getSex()=='F'){
                countWomen++;
                sumaWomen = sumaWomen+employee.getSalary();
            }
            if (employee.getSex()=='M'){
                countMen++;
                sumaMen=sumaMen+employee.getSalary();
            }
        }
        averageSalaryMen = sumaMen/countMen;
        averageSalaryWomen = sumaWomen/countWomen;
        double ratio = averageSalaryWomen/averageSalaryMen;

        System.out.println("Average salary women: "+averageSalaryWomen+"\nAverage salary man: "
                +averageSalaryMen+"\nRatio: "+ ratio);
        System.out.println(String.format("Average salary women: %.2f \nAverage salary man: %.2f"+
               " \nRatio: %.2f", averageSalaryWomen, averageSalaryMen, ratio));

    }
    //Zwiększanie pensji wszystkim pracownikom o 10 procent oraz dodatkowo za specjalne cechy (zgodnie z
    //metodą obiektu).
    public void riseSalary() throws IOException {
        for (Employee employee : employeeList) {
            employee.setSalary(employee.calculateRise(10));
        }

        writeToFile.writeToFile(employeeList);

    }
    //Zwiększenie pensji wszystkim pracownikom o kwotę podaną przez użytkownika, wyświetlona zostaje suma
    //podwyżek oraz stosunek podwyżek dla kobiet i mężczyzn. // funkcja z parametrem float – podana kwota
    //podwyżki. Suma podwyżek wyświetlona zostaje w funkcji, natomiast zwrócony zostaje wymagany stosunek.
    public double riseSalaryAmount() throws IOException {
        System.out.println("Enter amount of rise salary");
        double amount = scanner.nextDouble();
        double sumAmountF = 0;
        double sumAmountM= 0;
        for (Employee employee : employeeList) {
            employee.setSalary(employee.getSalary() + amount);
            if(employee.getSex()=='F'){
                sumAmountF = sumAmountF+amount;
            }else{
                sumAmountM = sumAmountM+amount;
            }
        }
        double ratio =sumAmountF/sumAmountM;
        System.out.println("Sum of rise salary women: "+sumAmountM+"\n Sum of rise salary men; "+sumAmountM);
        writeToFile.writeToFile(employeeList);
        return ratio;
    }
    //Sortowanie pracowników (w pliku) według nazwiska // procedura z parametrem booelan – true, to rosnącą;
    //false, to malejąco.
    public void sortLastName() throws IOException {
        System.out.println("Select type of sort(increase - true, descending - false) ");
        boolean decision = scanner.nextBoolean();
        if(decision){
       List<Employee> employeeList1= employeeList.stream().
               sorted(Comparator.comparing(Employee::getLastName)).collect(Collectors.toList());
        writeToFile.writeToFile(employeeList1);}
        else {
            List<Employee> employeeList1 = employeeList.stream().sorted(Comparator.comparing(Employee::getLastName).
                    reversed()).collect(Collectors.toList());
            writeToFile.writeToFile(employeeList1);
        }
    }
    //Sortowanie pracowników (w pliku) według wysokości ich pensji. // procedura z parametrem booelan – true, to
    //rosnącą; false, to malejąco.
    public void sortSalary() throws IOException {
        System.out.println("Select type of sort(increase - true, descending - false) ");
        boolean decision = scanner.nextBoolean();
        if(decision){
            List<Employee> employeeList1= employeeList.stream().
                    sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
            writeToFile.writeToFile(employeeList1);
          }
        else {
            List<Employee> employeeList1 = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).
                    reversed()).collect(Collectors.toList());
            writeToFile.writeToFile(employeeList1);
        }
    }

}
