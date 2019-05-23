/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciawebservice;
import java.util.Date;
import javax.xml.datatype.importante;

/**
 *
 * @author Maria and Ale and Juan
 */
public class Titular implements java.io.Serializable {

    private String nombre;
    private String dni;

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
    public void setDni(String dni) {
	this.dni = dni;
    }
    
    public String getNombre() {
	return this.nombre;
    }
    public String getDni() {
	return this.dni;
    }

}
