/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author reyes
 */
// Clase que representa la entidad Alumno
// Esta clase modela los datos de un alumno que se almacenan en la base de datos
public class Alumnos {

    // Atributos de la clase que representan las columnas de la tabla alumnos
    private int AluCodigo;       // Código o identificador único del alumno
    private String AluNombre;    // Nombre del alumno
    private String AluDireccion; // Dirección del alumno
    private String AluEstatus;   // Estado del alumno (Activo, Inactivo, etc.)

    
    // Constructor vacío
    // Se utiliza cuando se crea un objeto sin inicializar sus valores
    public Alumnos() {
    }

    
    // Constructor con parámetros
    // Permite crear un objeto alumno inicializando sus atributos principales
    public Alumnos(String AluNombre, String AluDireccion, String AluEstatus) {
        this.AluNombre = AluNombre;
        this.AluDireccion = AluDireccion;
        this.AluEstatus = AluEstatus;
    }

    
    // Método getter para obtener el código del alumno
    public int getAluCodigo() {
        return AluCodigo;
    }

    
    // Método setter para asignar el código del alumno
    public void setAluCodigo(int AluCodigo) {
        this.AluCodigo = AluCodigo;
    }

    
    // Getter para obtener el nombre del alumno
    public String getAluNombre() {
        return AluNombre;
    }

    
    // Setter para modificar el nombre del alumno
    public void setAluNombre(String AluNombre) {
        this.AluNombre = AluNombre;
    }

    
    // Getter para obtener la dirección del alumno
    public String getAluDireccion() {
        return AluDireccion;
    }

    
    // Setter para modificar la dirección del alumno
    public void setAluDireccion(String AluDireccion) {
        this.AluDireccion = AluDireccion;
    }

    
    // Getter para obtener el estatus del alumno
    public String getAluEstatus() {
        return AluEstatus;
    }

    
    // Setter para modificar el estatus del alumno
    public void setAluEstatus(String AluEstatus) {
        this.AluEstatus = AluEstatus;
    }

    
    // Método toString
    // Se utiliza para mostrar los datos del objeto alumno en forma de texto
    @Override
    public String toString() {
        return "Alumnos{" + "AluCodigo=" + AluCodigo +", AluNombre=" + AluNombre +  ", AluDireccion=" + AluDireccion +  ", AluEstatus=" + AluEstatus +  '}';
    }

}
