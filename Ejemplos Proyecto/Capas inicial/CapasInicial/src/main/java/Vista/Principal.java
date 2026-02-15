/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Empresa;
import Modelo.EmpresaDAO;

/**
 *
 * @author Soporte
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empresa empresa = new Empresa("COCA COLA");
        System.out.println(empresa.toString());
        EmpresaDAO empresadao = new EmpresaDAO();
        empresadao.insert(empresa);
        
          //QUERY
        empresadao.query(empresa);
        empresa.setCodigoEmpresa(7);
        empresa=empresadao.query(empresa);
        System.out.println(empresa.toString());
        
        //UPDATE
         empresa.setCodigoEmpresa(9); 
        empresa = empresadao.query(empresa); 
        empresa.setNombreEmpresa("NINTENDO");
        empresadao.update(empresa); 
        System.out.println(empresa.toString());
        
        //SELECT
         empresadao.select();
        empresa.setCodigoEmpresa(4);
        empresa = empresadao.query(empresa);
        System.out.println(empresa.toString());
        
        //DELETE
        Empresa empresaEliminar = new Empresa();
        empresa.setCodigoEmpresa(5);
        empresa = empresadao.query(empresa);
        empresadao.delete(empresa);
        System.out.println(empresa.toString());
      
    }
}