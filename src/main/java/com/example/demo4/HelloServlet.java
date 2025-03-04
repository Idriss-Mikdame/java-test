package com.example.demo4;

import com.example.demo4.DAO.DBOConnection;
import com.example.demo4.DAO.Employee;
import com.example.demo4.DAO.EmployeeDAO;
import com.example.demo4.DAO.EmployeeDAOImplm;

import java.sql.Connection;  // استيراد اتصال قاعدة البيانات
import java.sql.SQLException;

public class HelloServlet {
    public static void main(String[] args) {
        // محاولة الاتصال بقاعدة البيانات
        EmployeeDAO employeeDAO = new EmployeeDAOImplm();
        Employee employee = new Employee(0,"idriss","BM","CHEF",10000);
        employeeDAO.save(employee);
        //employeeDAO.findAll().forEach(System.out::println);
        //System.out.println("Employee saved");
       //Employee emp = employeeDAO.findById(3);
        //System.out.println(emp);

    }
}
