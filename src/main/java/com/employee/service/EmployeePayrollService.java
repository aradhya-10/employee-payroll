package com.employee.service;

import com.employee.entity.EmployeePayrollData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {}
    public EmployeePayrollService (List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    private void readEmployeePayrollData (Scanner consoleInputReader) {
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    private void writeEmployeePayrollData() {
        System.out.println("\nWriting Employee Payroll Console\n");
        employeePayrollList.forEach(employeePayrollData -> {
            System.out.println(employeePayrollData.toString());
        });
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);

        int choice = 0;

        while(choice!=3){
            System.out.println("1. Add Employee Data");
            System.out.println("2. View Employee Data");
            System.out.println("3. Exit");
            System.out.println("Enter choice: ");
            choice = consoleInputReader.nextInt();

            switch (choice){
                case 1:
                    employeePayrollService.readEmployeePayrollData(consoleInputReader);
                    break;
                case 2:
                    employeePayrollService.writeEmployeePayrollData();
                    break;
                case 3:
                    System.out.println("Exiting!");
                    break;
                default:
                    System.out.println("Enter valid input");
            }
        }
//        UC4: Write into file
        PayrollFileI0Service payrollFileI0Service = new PayrollFileI0Service();
        payrollFileI0Service.writeData(employeePayrollList);
    }
}

