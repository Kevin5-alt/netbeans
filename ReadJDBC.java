/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

import java.sql.*;

public class ReadJDBC {

    public static void main(String[] args) {

        String usuario  = "root";
        String password = "2008";
        String url      = "jdbc:mysql://127.0.0.1:3306/ejemJDBC";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             Statement statement = conexion.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM usuarios ORDER BY nombre DESC")  
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_usuario") + ": " +
                    rs.getString("nombre") + ": " +
                    rs.getString("apellido") + ": " +
                    rs.getString("rol")
                );
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
