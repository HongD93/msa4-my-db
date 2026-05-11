package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private MyConnection myConnection;

    public EmployeeRepository() {
        this.myConnection = new MyConnection();
    }

    public List<EmployeeDTO> getEmployees(int limit) {
        List<EmployeeDTO> list = new ArrayList<>();

        String sql =
              " SELECT "
            + "    * "
            + " FROM "
            + "    employees "
            + " LIMIT 10 "
        ;

        try(
            // Connection 객체 획득 (DB 연결)
            Connection conn = this.myConnection.getConn();

            // Statement 객체 회득 (Query 실행 준비)
            Statement stmt = conn.createStatement();

            // ResultSet 객체 획득 (Query 실행)
            ResultSet result = stmt.executeQuery(sql);
        ) {
            while(result.next()) {
                EmployeeDTO employee = new EmployeeDTO();

                employee.setEmpId(result.getLong("emp_id"));
                employee.setBirth(result.getString("birth"));
                employee.setName(result.getString("name"));
                employee.setGender(result.getString("gender"));
                employee.setDeletedAt(result.getString("deleted_at"));
                employee.setCreatedAt(result.getString("created_at"));
                employee.setFireAt(result.getString("fire_at"));
                employee.setHireAt(result.getString("hire_at"));
                employee.setSupId(result.getLong("sup_id"));
                employee.setUpdatedAt(result.getString("updated_at"));

                list.add(employee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public List<EmployeeDTO> getEmployeesLimit(int limit) {
        List<EmployeeDTO> list = new ArrayList<>();

        String sql =
              " SELECT "
            + "    * "
            + " FROM "
            + "    employees "
            + " LIMIT ? "
        ;

        try(
            // Connection 객체 획득 (DB 연결)
            Connection conn = this.myConnection.getConn();

            // PreparedStatement 객체 획득 (Query 실행 준비)
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, limit); // Prepared Statement Set

            try(
                // ResultSet 객체 획득 (Query 실행)
                ResultSet result = pstmt.executeQuery();
            ) {
                while(result.next()) {
                    EmployeeDTO employee = new EmployeeDTO();

                    employee.setEmpId(result.getLong("emp_id"));
                    employee.setBirth(result.getString("birth"));
                    employee.setName(result.getString("name"));
                    employee.setGender(result.getString("gender"));
                    employee.setDeletedAt(result.getString("deleted_at"));
                    employee.setCreatedAt(result.getString("created_at"));
                    employee.setFireAt(result.getString("fire_at"));
                    employee.setHireAt(result.getString("hire_at"));
                    employee.setSupId(result.getLong("sup_id"));
                    employee.setUpdatedAt(result.getString("updated_at"));

                    list.add(employee);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
