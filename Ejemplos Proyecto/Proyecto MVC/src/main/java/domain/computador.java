package domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author reyes
 */
public class computador {
    
    private String marca; 
    private String color;
    private String Software; 
    
    public computador() {
    }
        
    public computador(String marca, String color, String Software) {
        this.marca = marca;
        this.color = color;
        this.Software = Software;
}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSoftware() {
        return Software;
    }

    public void setSoftware(String Software) {
        this.Software = Software;
    }
    
    
}
