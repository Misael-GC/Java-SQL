package org.example;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;

        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Misael_12");
            System.out.println("Conexión exitosa");

            myStamt = myConn.createStatement();
            myRes = myStamt.executeQuery("select * from employees");

            while (myRes.next()){
                System.out.println(myRes.getString("first_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salió mal");
        }
    }
}