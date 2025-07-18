/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package javaapplication3;

import java.sql.*;

public class UpdateJDBC {
    
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "2008";
        String url = "jdbc:mysql://127.0.0.1:3306/ejemJDBC";
        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            
            
            statement.executeUpdate("UPDATE usuarios SET rol = 'Senior Tester' WHERE nombre = 'Kevin' AND apellido = 'Ceballos'");
           
            rs = statement.executeQuery("SELECT * FROM usuarios");
            
            while (rs.next()) {
                System.out.println(rs.getInt("id_usuario") + ": " + rs.getString("nombre") + ": " + rs.getString("apellido") + ": " + rs.getString("rol"));
            }
                    
        } catch (SQLException | ClassNotFoundException e) {
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
            }
        }
    }
}


