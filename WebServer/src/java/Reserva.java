/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciawebservice;
import java.util.Date;
/**
 *
 * @author Maluz and Alex
 */
public class Reserva implements java.io.Serializable {
    private int numReserva;
    private Date ida;
    private Date vuelta;
    private String origen;
    private String destino;
    private Titular titular;

}
