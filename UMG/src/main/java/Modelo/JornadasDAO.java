/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Jornadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reyes
 */
public class JornadasDAO {

// Clase DAO (Data Access Object) encargada de manejar
// las operaciones CRUD de la tabla jornadas en la base de datos

    // Sentencia SQL para obtener todos los registros de la tabla jornadas
    private static final String SQL_SELECT = "SELECT JorCodigo, JorNombre FROM jornadas";

    // Sentencia SQL para insertar una nuevo jornada
     private static final String SQL_INSERT =  "INSERT INTO Jornadas(JorNombre) VALUES(?,?,?)";

    // Sentencia SQL para actualizar los datos de una jornada por su código
    private static final String SQL_UPDATE =   "UPDATE Jornadas SET JorNombre=? WHERE JorCodigo = ?";

    // Sentencia SQL para eliminar una jornada por su código
    private static final String SQL_DELETE = "DELETE FROM Jornadas WHERE JorCodigo=?";

    // Sentencia SQL para consultar una jornada específico por su código
    private static final String SQL_QUERY = "SELECT JorCodigo, JorNombre FROM Jornadas WHERE JorCodigo = ?";

    // Método que obtiene todos los registros de la tabla jornadas
    public List<Jornadas> select() {

        // Variables para la conexión y ejecución de la consulta
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        // Objeto jornadas
        Jornadas jornadas = null;

        // Lista que almacenará todos las jornadas encontrados
        List<Jornadas> jornadass = new ArrayList<>();

        try {
            // Se obtiene la conexión a la base de datos
            conn = Conexion.getConnection();

            // Se prepara la consulta SQL
            stmt = conn.prepareStatement(SQL_SELECT);

            // Se ejecuta la consulta
            rs = stmt.executeQuery();

            // Se recorren todos los registros obtenidos
            while (rs.next()) {

                // Se obtienen los valores de cada columna
                int JorCodigo = rs.getInt("JorCodigo");
                String JorNombre = rs.getString("JorNombre");

                // Se crea un objeto jornadas y se asignan los valores
                jornadas = new Jornadas();
                jornadas.setJorCodigo(JorCodigo);
                jornadas.setJorNombre(JorNombre);

                // Se agrega la jornada a la lista
                jornadass.add(jornadas);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            // Se cierran los recursos utilizados
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        // Se devuelve la lista de jornadas
        return jornadass;
    }


    // Método para insertar una nuevo jornada en la base de datos
    public int insert(Jornadas jornadas) {

        Connection conn = null;
        PreparedStatement stmt = null;

        // Variable que indica cuántos registros fueron afectados
        int rows = 0;

        try {

            // Se obtiene la conexión
            conn = Conexion.getConnection();

            // Se prepara la consulta
            stmt = conn.prepareStatement(SQL_INSERT);

            // Se asignan los valores a los parámetros de la consulta
            stmt.setString(1, jornadas.getJorNombre());

            // Se muestra la consulta en consola
            System.out.println("Ejecutando query:" + SQL_INSERT);

            // Se ejecuta la inserción
            rows = stmt.executeUpdate();

            // Se muestran los registros afectados
            System.out.println("Registros afectados:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            // Se cierran los recursos
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    // Método para actualizar los datos de una jornada
    public int update(Jornadas jornadas) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();

            System.out.println("ejecutando query: " + SQL_UPDATE);

            // Se prepara la consulta de actualización
            stmt = conn.prepareStatement(SQL_UPDATE);

            // Se asignan los nuevos valores
            stmt.setString(1, jornadas.getJorNombre());

            // Se especifica el código de la jornada a actualizar
            stmt.setInt(4, jornadas.getJorCodigo());

            // Se ejecuta la actualización
            rows = stmt.executeUpdate();

            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    // Método para eliminar una jornada según su código
    public int delete(Jornadas jornadas) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_DELETE);

            // Se prepara la consulta de eliminación
            stmt = conn.prepareStatement(SQL_DELETE);

            // Se asigna el código de la jornada a eliminar
            stmt.setInt(1, jornadas.getJorCodigo());

            // Se ejecuta la eliminación
            rows = stmt.executeUpdate();

            System.out.println("Registros eliminados:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    // Método que busca una jornada específico por su código
    public Jornadas query(Jornadas jornadas) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_QUERY);

            // Se prepara la consulta
            stmt = conn.prepareStatement(SQL_QUERY);

            // Se establece el código de la jornada a buscar
            stmt.setInt(1, jornadas.getJorCodigo());

            // Se ejecuta la consulta
            rs = stmt.executeQuery();

            // Si se encuentra el registro
            while (rs.next()) {

                int codigo = rs.getInt("JorCodigo");
                String nombre = rs.getString("JorNombre");

                // Se crea el objeto jornadas con los datos encontrados
                jornadas = new Jornadas();
                jornadas.setJorCodigo(codigo);
                jornadas.setJorNombre(nombre);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            // Se cierran los recursos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        // Se devuelve la jornada encontrado
        return jornadas;
    }
}
