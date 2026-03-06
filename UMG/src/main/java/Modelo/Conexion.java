/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author reyes
 */
import java.sql.*;

// Clase encargada de gestionar la conexión con la base de datos
// Contiene métodos para abrir y cerrar conexiones JDBC
public class Conexion {

    // URL de conexión a la base de datos MySQL
    // localhost → servidor local
    // umg → nombre de la base de datos
    // useSSL=false → desactiva conexión SSL
    // serverTimezone=UTC → establece la zona horaria del servidor
    private static final String JDBC_URL = "jdbc:mysql://localhost/umg?useSSL=false&serverTimezone=UTC";

    // Usuario de la base de datos
    private static final String JDBC_USER = "usuprueba";

    // Contraseña del usuario de la base de datos
    private static final String JDBC_PASS = "123456";


    // Método que establece y devuelve una conexión con la base de datos
    // Utiliza DriverManager para conectarse usando la URL, usuario y contraseña
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }


    // Método para cerrar un ResultSet
    // ResultSet contiene los resultados de una consulta SQL
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }


    // Método para cerrar un PreparedStatement
    // PreparedStatement se usa para ejecutar consultas SQL preparadas
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }


    // Método para cerrar una conexión a la base de datos
    // Es importante cerrarla para liberar recursos del sistema
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}

