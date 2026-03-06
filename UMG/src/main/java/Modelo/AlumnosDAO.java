/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Alumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Clase DAO (Data Access Object) encargada de manejar
// las operaciones CRUD de la tabla alumnos en la base de datos
public class AlumnosDAO {

    // Sentencia SQL para obtener todos los registros de la tabla alumnos
    private static final String SQL_SELECT = "SELECT AluCodigo, AluNombre, AluDireccion, AluEstatus FROM alumnos";

    // Sentencia SQL para insertar un nuevo alumno
     private static final String SQL_INSERT =  "INSERT INTO alumnos(AluNombre, AluDireccion, AluEstatus) VALUES(?,?,?)";

    // Sentencia SQL para actualizar los datos de un alumno por su código
    private static final String SQL_UPDATE =   "UPDATE alumnos SET AluNombre=?, AluDireccion=?, AluEstatus=? WHERE AluCodigo = ?";

    // Sentencia SQL para eliminar un alumno por su código
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE AluCodigo=?";

    // Sentencia SQL para consultar un alumno específico por su código
    private static final String SQL_QUERY = "SELECT AluCodigo, AluNombre, AluDireccion, AluEstatus FROM alumnos WHERE AluCodigo = ?";

    // Método que obtiene todos los registros de la tabla alumnos
    public List<Alumnos> select() {

        // Variables para la conexión y ejecución de la consulta
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        // Objeto alumno
        Alumnos alumnos = null;

        // Lista que almacenará todos los alumnos encontrados
        List<Alumnos> alumnoss = new ArrayList<>();

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
                int AluCodigo = rs.getInt("AluCodigo");
                String AluNombre = rs.getString("AluNombre");
                String AluDireccion = rs.getString("AluDireccion");
                String AluEstatus = rs.getString("AluEstatus");

                // Se crea un objeto alumno y se asignan los valores
                alumnos = new Alumnos();
                alumnos.setAluCodigo(AluCodigo);
                alumnos.setAluNombre(AluNombre);
                alumnos.setAluDireccion(AluDireccion);
                alumnos.setAluEstatus(AluEstatus);

                // Se agrega el alumno a la lista
                alumnoss.add(alumnos);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            // Se cierran los recursos utilizados
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        // Se devuelve la lista de alumnos
        return alumnoss;
    }


    // Método para insertar un nuevo alumno en la base de datos
    public int insert(Alumnos alumnos) {

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
            stmt.setString(1, alumnos.getAluNombre());
            stmt.setString(2, alumnos.getAluDireccion());
            stmt.setString(3, alumnos.getAluEstatus());

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


    // Método para actualizar los datos de un alumno
    public int update(Alumnos alumnos) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();

            System.out.println("ejecutando query: " + SQL_UPDATE);

            // Se prepara la consulta de actualización
            stmt = conn.prepareStatement(SQL_UPDATE);

            // Se asignan los nuevos valores
            stmt.setString(1, alumnos.getAluNombre());
            stmt.setString(2, alumnos.getAluDireccion());
            stmt.setString(3, alumnos.getAluEstatus());

            // Se especifica el código del alumno a actualizar
            stmt.setInt(4, alumnos.getAluCodigo());

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


    // Método para eliminar un alumno según su código
    public int delete(Alumnos alumnos) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {

            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_DELETE);

            // Se prepara la consulta de eliminación
            stmt = conn.prepareStatement(SQL_DELETE);

            // Se asigna el código del alumno a eliminar
            stmt.setInt(1, alumnos.getAluCodigo());

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


    // Método que busca un alumno específico por su código
    public Alumnos query(Alumnos alumnos) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_QUERY);

            // Se prepara la consulta
            stmt = conn.prepareStatement(SQL_QUERY);

            // Se establece el código del alumno a buscar
            stmt.setInt(1, alumnos.getAluCodigo());

            // Se ejecuta la consulta
            rs = stmt.executeQuery();

            // Si se encuentra el registro
            while (rs.next()) {

                int codigo = rs.getInt("AluCodigo");
                String nombre = rs.getString("AluNombre");
                String direccion = rs.getString("AluDireccion");
                String estatus = rs.getString("AluEstatus");

                // Se crea el objeto alumno con los datos encontrados
                alumnos = new Alumnos();
                alumnos.setAluCodigo(codigo);
                alumnos.setAluNombre(nombre);
                alumnos.setAluDireccion(direccion);
                alumnos.setAluEstatus(estatus);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            // Se cierran los recursos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        // Se devuelve el alumno encontrado
        return alumnos;
    }
}