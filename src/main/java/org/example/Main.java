package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
//            MyConnection myConnection = new MyConnection();
//            Connection conn = myConnection.getConn();
//            System.out.println(conn);

            EmployeeRepository employeeRepository = new EmployeeRepository();
            List<EmployeeDTO> result = employeeRepository.getEmployees(10);

            result.forEach((item) -> {
                String str = String.format("%d: %s", item.getEmpId(), item.getName());
                System.out.println(str);
            });

            System.out.println("--------------------------");

            result = employeeRepository.getEmployeesLimit(2);
            result.forEach((item) -> {
                String str = String.format("%d: %s", item.getEmpId(), item.getName());
                System.out.println(str);
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}