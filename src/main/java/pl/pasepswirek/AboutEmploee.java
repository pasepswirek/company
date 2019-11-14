package pl.pasepswirek;

import java.io.*;
import java.util.List;

//Dodatkowe funkcje dla plików tekstowych – pozycja 7 w menu.
public class AboutEmploee {
    private ViewEmployee viewEmployee = new ViewEmployee();
    private List<Employee> employeeList = viewEmployee.getEmployeeList();
    private WriteToFile writeToFile = new WriteToFile();
    private ReadFile readFile = new ReadFile();

    public void exportFileToTXT() throws FileNotFoundException {
        employeeList = readFile.readFileDat();
        try {
            FileWriter fileWriter = new FileWriter("src\\main\\resources\\baza1");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (int i = 0; i < employeeList.size(); i++) {
                bw.write(
                        employeeList.get(i).getName() + ";" +
                                employeeList.get(i).getLastName() + ";" +
                                employeeList.get(i).getSex() + ";" +
                                employeeList.get(i).getDepartmentID() + ";" +
                                employeeList.get(i).getSalary() + ";" +
                                employeeList.get(i).getAge() + ";" +
                                employeeList.get(i).getNumberOfKids() + ";" +
                                employeeList.get(i).isMaritalStatus());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Wyświetlenie danych (linii z pliku) o osobie z najdłuższym nazwiskiem. Jeśli kilka osób ma taką samą długość
    //nazwiska wystarczy wyświetlić jedną. // procedura bez dodatkowych parametrów
    public void longerLastName() {
        int maxLenght = 0;
        String longLastName = null;
        for (Employee employee : employeeList) {
            if (employee.getLastName().length() > maxLenght) {
                maxLenght = employee.getLastName().length();
                longLastName = employee.viewAllDate();
            }
        }
        System.out.println(longLastName);
    }

    //Obliczenie średniego wieku osób posiadających dzieci. // funkcja bez dodatkowych parametrów.
    public void haveKidsAverageAge() {
        int averageAge = 0;
        int count = 0;
        int sumAge = 0;
        for (Employee employee : employeeList) {
            if (employee.getNumberOfKids() != 0) {
                sumAge = sumAge + employee.getAge();
                count++;
            }
        }
        averageAge = sumAge / count;
        System.out.println("Average age of parents; " + averageAge);

    }

    //Zakodowanie niektórych danych w pliku (tym samym – tekstowym) w ten sposób, że nazwisko wpisane
    //zostaje na zasadzie:
    //N********i zamiast Nowakowski
    //Należy zakodować nazwiska tylko tych osób, których zarobek jest niższy od średniego zarobku wszystkich
    //pracowników.
    public void encryptLastName() throws IOException {
        for (Employee employee : employeeList) {
            if (employee.getSalary() < averageSalary()) {
                int lenght = employee.getLastName().length();
                String lastName = employee.getLastName();
                String encryptLastName;
                encryptLastName = lastName.substring(0, 1) + replace(lastName, 1, lenght - 1) +
                        lastName.substring(lenght - 1);
                employee.setLastName(encryptLastName);
                System.out.println(employee.viewNameLastNameSexDate());
            }
        }
        writeToFile.writeToFile(employeeList);

    }

    //do metody encryptLastName()
    public double averageSalary() {
        double sumSalary = 0;
        int couEmployee = 0;
        double avarageSalary = 0;

        for (Employee employee : employeeList) {
            sumSalary = sumSalary + employee.getSalary();
            couEmployee++;
        }
        avarageSalary = sumSalary / couEmployee;
        return avarageSalary;
    }

    //do metody encryptLastName()
    public String replace(String str, int start, int end) {
        String[] temp = new String[end - start];
        String str2 = "";
        for (int i = start; i < end; i++) {
            temp = str.substring(start, end).split("");
        }
        for (int i = 0; i < temp.length; i++) {
            temp[i] = "*";
        }
        for (int i = 0; i < temp.length; i++) {
            str2 = str2 + temp[i];
        }

        return str2;
    }

    //Utworzenie pliku 'pracownicy.html' (tekstowy), w którym na podstawie pliku tekstowego o pracownikach
//tworzona jest tabela zapisana w HTML w taki sposób, na początku nazwane zostają nagłówki (w apostrofach
//wyróżnione zostały kolejne kolumny):
//'Nazwisko' 'Imię' 'Płeć' 'Numer działu' 'Płaca' 'Wiek'
    public void htmlFileGenerator() throws IOException {
        try {
            FileWriter fileWriterHtml = new FileWriter("src\\main\\resources\\pracownicy.html");
            BufferedWriter bw = new BufferedWriter(fileWriterHtml);
            bw.write("<table BORDER>");
            bw.newLine();
            bw.write("<tr><td>'LastName'</td><td>'Name'</td><td>'Sex'</td><td>'Department ID'" +
                    "</td><td>'Salary'</td><td>'Age'</td></tr>");
            for (Employee employee : employeeList) {
                bw.write("<tr><td>" + employee.getLastName() + "</td><td>" + employee.getName() + "</td>" +
                        "<td>" + employee.getSex() + "</td><td>" + employee.getDepartmentID() + "</td>" +
                        "<td>" + employee.getSalary() + "</td><td>" + employee.getAge() + "</td></tr>");
                bw.newLine();
            }
            bw.write("</table>");
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku");
        }
    }
}
