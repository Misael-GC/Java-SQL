package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        PreparedStatement myStamt = null;


        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Misael_12");
            System.out.println("Conexión exitosa");

            String sql = ("INSERT INTO employees (first_name, pa_surname) VALUES (?, ?)");
            myStamt = myConn.prepareStatement(sql);
            myStamt.setString(1, "Johana");
            myStamt.setString(2, "Dorantes");

            int rowsAffected = myStamt.executeUpdate();

            if (rowsAffected>0){
                System.out.println("Se ha creado un nuevo registro");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salió mal");
        }
    }
}