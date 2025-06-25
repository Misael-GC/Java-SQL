package org.example;

import java.sql.*;

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

            int rowsAffected = myStamt.executeUpdate("UPDATE employees " + "set email='j.nador23@email.com' " + " WHERE first_name='Johana'");

            myRes = myStamt.executeQuery("SELECT *FROM employees order by pa_surname");
            while (myRes.next()){
                System.out.println(myRes.getString("first_name") + "," + myRes.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salió mal");
        }
    }
}