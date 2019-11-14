package pl.pawelsepko;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void testEmployee(){

        //given
        Employee employee = new Employee();

        //when
    employee.setLastName("Sepko");
    employee.setName("Pawel");
    employee.setSalary(3000);
    employee.setMaritalStatus(false);
    employee.setNumberOfKids(0);
    employee.setAge(33);
    employee.setSex('M');
    employee.setDepartmentID(2);
    //then
        assertEquals(false, employee.isMaritalStatus());
        assertEquals("Sepko", employee.getLastName());
        assertEquals(3000, employee.getSalary(),0);
        assertEquals('M', employee.getSex());
        assertEquals("Pawel", employee.getName());
        assertEquals(33, employee.getAge());
        assertEquals(2, employee.getDepartmentID());
        assertEquals(0, employee.getNumberOfKids());
    }
    @Test
    public void testcalculateRis(){
        //given
        Employee employee = new Employee();
        //when
        employee.setSalary(3000);
        employee.setNumberOfKids(2);
        employee.setMaritalStatus(true);
       // employee.calculateRise(10);
        //then
        assertEquals(3510,employee.calculateRise(10), 0 );
    }
    @Test
    public void  testCompareSalary(){
        //given
        Employee employee = new Employee();
        //when
        employee.setSalary(3000);
        String compare = employee.compareSalary(2500);
        //then
        assertEquals("True, 2500,00", compare);

    }
    @Test
    public void testReadFile() throws FileNotFoundException {
        //given
        List<Employee> employeeList = new ArrayList<>();
        ReadFile readFile = new ReadFile();
        //when
        employeeList = readFile.readFileDat();

        //then
        assertEquals("Employee:: Adam Kowalski, sex: M.", employeeList.get(0).viewNameLastNameSexDate());
        assertEquals('M', employeeList.get(0).getSex());

    }
}