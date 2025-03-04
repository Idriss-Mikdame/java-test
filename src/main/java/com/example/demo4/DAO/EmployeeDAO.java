package com.example.demo4.DAO;

import java.util.List;

public interface EmployeeDAO {
     List<Employee> findAll();
     Employee findById(int id);
     void save(Employee employee);
     void deleteByid(int id);
}
