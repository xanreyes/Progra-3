/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.Alumnos;
import Modelo.AlumnosDAO;
import java.util.List;
import Controlador.Jornadas;
import Modelo.JornadasDAO;
import java.util.List;
/**
 *
 * @author reyes
 */
public class Principal {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    //ALUMNOS
    
    // Creación de un objeto Alumno con nombre, dirección y estatus
    Alumnos alumnos = new Alumnos("Angel Roquel","Palencia, Azacualpilla","Activo");
    
    // Creación del objeto DAO que se encargará de interactuar con la base de datos
    AlumnosDAO alumnosdao = new AlumnosDAO();
    
    // INSERT
    
    // Inserta el objeto alumno en la base de datos
    alumnosdao.insert(alumnos);
    
    // Muestra en consola la información del alumno insertado
    System.out.println(alumnos.toString());
       
    // QUERY
    
    // Se asigna el código del alumno que se quiere buscar
    alumnos.setAluCodigo(1);
    
    // Se realiza la consulta del alumno en la base de datos usando su código
    alumnos = alumnosdao.query(alumnos);
    
    // Se muestra la información del alumno obtenido
    System.out.println(alumnos.toString());
                         
    // UPDATE
    
    // Se vuelve a consultar el alumno con código 1
    alumnos.setAluCodigo(1);
    alumnos = alumnosdao.query(alumnos);
    
    // Se modifican los datos del alumno
    alumnos.setAluNombre("Dulce Reyes");
    alumnos.setAluDireccion("Zona 6");
    alumnos.setAluEstatus("Activo");
    
    // Se actualizan los datos del alumno en la base de datos
    alumnosdao.update(alumnos);
    
    // Se imprime el alumno con los datos actualizados
    System.out.println(alumnos.toString());
    
    // SELECT
    
    // Obtiene todos los alumnos registrados en la base de datos
    List<Alumnos> alumnoss = alumnosdao.select();
    
    // Recorre la lista de alumnos y muestra cada uno en consola
    for(Alumnos a : alumnoss){
        System.out.println(a);
    } 

    // DELETE
    
    // Se crea un objeto alumno para eliminarlo usando su código
    Alumnos alumnosEliminar = new Alumnos();
    
    // Se establece el código del alumno que se desea eliminar
    alumnosEliminar.setAluCodigo(5);
    
    // Se ejecuta la eliminación del alumno en la base de datos
    alumnosdao.delete(alumnosEliminar);
    
    // Mensaje de confirmación en consola
    System.out.println("Alumno eliminado");
    
    
    
    //JORNADAS
    
    
       // Creación de un objeto Jornadas con nombre
    Jornadas jornadas = new Jornadas("Matutina");
    
    // Creación del objeto DAO que se encargará de interactuar con la base de datos
    JornadasDAO jornadasdao = new JornadasDAO();
    
     // INSERT
    
    // Inserta el objeto jornada en la base de datos
    jornadasdao.insert(jornadas);
    
    // Muestra en consola la información de la jornada insertado
    System.out.println(jornadas.toString());
       
    // QUERY
    
    // Se asigna el código de la jornada que se quiere buscar
    jornadas.setJorCodigo(1);
    
    // Se realiza la consulta de la jornada en la base de datos usando su código
    jornadas = jornadasdao.query(jornadas);
    
    // Se muestra la información de la jornada obtenido
    System.out.println(jornadas.toString());
                         
    // UPDATE
    
    // Se vuelve a consultar la jornada con código 1
    jornadas.setJorCodigo(1);
    jornadas = jornadasdao.query(jornadas);
    
    // Se modifican los datos de la jornada
    jornadas.setJorNombre("Matutina");
    
    // Se actualizan los datos de la jornada en la base de datos
    jornadasdao.update(jornadas);
    
    // Se imprime la jornada con los datos actualizados
    System.out.println(jornadas.toString());
    
    // SELECT
    
    // Obtiene todos las jornadas registrados en la base de datos
    List<Jornadas> jornadass = jornadasdao.select();
    
    // Recorre la lista de jornadas y muestra cada uno en consola
    for(Jornadas a : jornadass){
        System.out.println(a);
    } 

    // DELETE
    
    // Se crea un objeto jornadas para eliminarlo usando su código
    Jornadas jornadasEliminar = new Jornadas();
    
    // Se establece el código de la jornada que se desea eliminar
    jornadasEliminar.setJorCodigo(5);
    
    // Se ejecuta la eliminación de la jornada en la base de datos
    jornadasdao.delete(jornadasEliminar);
    
    // Mensaje de confirmación en consola
    System.out.println("Jornada eliminado");
    }
}
   
