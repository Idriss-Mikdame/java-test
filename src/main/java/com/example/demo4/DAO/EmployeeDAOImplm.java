package com.example.demo4.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAOImplm implements EmployeeDAO {

    @Override
    public List<Employee> findAll() {
        Connection con =  DBOConnection.getConnection();
        if (con == null) {
            return null;
        }
        List<Employee> employees = new LinkedList<>();
        String query = "select * from employee";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("city"),resultSet.getString("jbob"),
                        resultSet.getDouble("salary"));
                employees.add(employee);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Connection con =  DBOConnection.getConnection();

        if (con == null) {
            return null;
        }
        String query = "select * from employee where id=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employee employee=new Employee(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("city"),resultSet.getString("jbob"),
                        resultSet.getDouble("salary"));
           return employee;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        Connection connection = DBOConnection.getConnection();
        if (connection == null) {
            return;
        }
        if (employee.getId() > 0) {
            String query ="UPDATE employee SET name=?, city=?, jbob=?, salary=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getCity());
                preparedStatement.setString(3, employee.getJbob());
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.setInt(5, employee.getId());
                preparedStatement.executeUpdate();
            }catch (SQLException se){
                se.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }else {
            String query ="INSERT INTO employee (name, city, jbob, salary) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getCity());
                preparedStatement.setString(3, employee.getJbob());
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.executeUpdate();
            }catch (SQLException se){
                se.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void deleteByid(int id) {

    }
}
