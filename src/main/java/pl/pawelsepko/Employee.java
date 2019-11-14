package pl.pawelsepko;

import lombok.*;

import java.io.Serializable;
import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor

public class Employee  {

    private String name;
    private String lastName;
    private char sex;
    private int departmentID;
    private double salary;
    private int age;
    private int numberOfKids;
    private boolean maritalStatus;
    private final int percentRiseForKid = 2;
    private final int percentRiseBeRelationship = 3;



    public String viewAllDate(){
        String s = String.format("Employee:: %s %s, sex: %c, department ID: %d, " +
                "salary: %.2f, age: %d, number of kids: %d, marital status: %b.",
                name, lastName, sex, departmentID, salary, age, numberOfKids, maritalStatus);
        return new StringJoiner("\n").add(s).toString();

    }
    public String viewNameLastNameSexDate(){
        String s = String.format("Employee:: %s %s, sex: %c.",
                name, lastName, sex);
        return new StringJoiner("\n").add(s).toString();

    }
    public String viewNameLastName(){
        String s = String.format("Employee::  %s %s.",
                name, lastName);
        return new StringJoiner("\n").add(s.toUpperCase()).toString();
    }

    public String compareSalary(double suma){
        String s;
        if(salary > suma){
            return  s = String.format("True, %.2f", suma);
        }
        else {
            return s = String.format("False, %.2f", suma);
        }
    }
    public double calculateRise(int percentRise){

        if(numberOfKids !=0){
            percentRise = percentRise + numberOfKids*percentRiseForKid;
        }
        if(maritalStatus){
            percentRise = percentRise + percentRiseBeRelationship;
        }
        salary = salary+salary * percentRise/100;
        return salary;

    }

}
