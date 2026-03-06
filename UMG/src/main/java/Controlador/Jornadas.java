/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
/**
 *
 * @author reyes
 */
public class Jornadas {
    
    // Atributos de la clase que representan las columnas de la tabla jornadas
    private int JorCodigo;       // Código o identificador único de la jornada
    private String JorNombre;    // Nombre de la jornada

    @Override
    public String toString() {
        return "Jornadas{" + "JorCodigo=" + JorCodigo + ", JorNombre=" + JorNombre + '}';
    }
    
    // Constructor vacío
    // Se utiliza cuando se crea un objeto sin inicializar sus valores
    public Jornadas() {
    }

    
    // Constructor con parámetros
    // Permite crear un objeto jornada inicializando sus atributos principales
    public Jornadas(String JorNombre) {
        this.JorNombre = JorNombre;
    }
    
    // Método getter para obtener el código de la jornada
    public int getJorCodigo() {
        return JorCodigo;
    }

    
    // Método setter para asignar el código de la jornada
    public void setJorCodigo(int JorCodigo) {
        this.JorCodigo = JorCodigo;
    }

    
    // Getter para obtener el nombre de la jornada
    public String getJorNombre() {
        return JorNombre;
    }

    
    // Setter para modificar el nombre de la jornada
    public void setJorNombre(String JorNombre) {
        this.JorNombre = JorNombre;
    }
    
    // Método toString
    // Se utiliza para mostrar los datos del objeto jornada en forma de texto
  
    
    }
