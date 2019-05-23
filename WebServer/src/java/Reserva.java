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
 * @author Maria and Ale and juan
 */
public class Reserva implements java.io.Serializable {
    private int numReserva;
    private Date ida;
    private Date vuelta;
    private String origen;
    private String destino;
    private Titular titular;

    public void setNumReserva(int numCuenta) {
	this.numReserva = numReserva;
    }
    public void setTitular(Titular titular) {
	this.titular = titular;
    }
    public void setIda(Date ida) {
	this.ida = ida;
    }
    public void setVuelta(Date vuelta) {
	this.vuelta= vuelta;
    }
    public void setOrigen(String origen) {
	this.origen= origen;
    }
     public void setDestino(String destino) {
	this.destino= destino;
    }
    
    public int getNumReserva() {
	return this.numReserva;
    }
    public Titular getTitular() {
	return this.titular;
    }
    public Date getIda() {
	return this.ida;
    }
    public Date getVuelta() {
	return this.vuelta;
    }
    public String getOrigen() {
	return this.origen;
    }
    public String getDestino() {
	return this.destino;
    }

    

}
