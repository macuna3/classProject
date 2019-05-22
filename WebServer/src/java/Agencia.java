/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenciawebservice;

import java.util.Date;
import java.util.Vector;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author Maluz and Alex
 */
@WebService(serviceName = "Agencia")
public class Agencia {
      private Vector reservas = null;
  public int numreservas=0;
  public Agencia()
  {

    reservas = new Vector();
  
  }

  public int crearReserva(Date ida, Date vuelta, String origen,
                          String destino, Titular titular) throws Exception
  {

  }

  public void cancelarReserva(int numreserva,
                              Titular titular) throws Exception
  {

  }

  public void modificarReserva(int num, int control,
                               Date nueva) throws Exception
  {

  }


  public Reserva[] ReservasDelTitular(String dni) throws Exception
  {

    
}
