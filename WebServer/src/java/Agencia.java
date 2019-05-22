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
 * @author Maluz y Alex
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

    
    if (titular != null)
      {
        Reserva newreserva = new Reserva();
          newreserva.setNumReserva(numreservas);
          newreserva.setTitular(titular);
          newreserva.setIda(ida);
          newreserva.setVuelta(vuelta);
          newreserva.setOrigen(origen);
          newreserva.setDestino(destino);
          reservas.add(newreserva);
          
      }
    else
      {
        throw new Exception("Titular invalido!");
      }
    numreservas++;
    return numreservas-1;
  }

  public void cancelarReserva(int numreserva,
                              Titular titular) throws Exception
  {
  int encontrado=0;
    

      for (int i = 0; i < reservas.size(); i++)
        {

          Reserva n = (Reserva) reservas.get(i);

          if (n.getNumReserva() == numreserva)
            {
              if (n.getTitular().getNombre() == titular.getNombre())
                {
                  reservas.remove(i);
                  System.out.println("Se ha eliminado la reserva");
                  encontrado=1;
                }
              else
                {
                  throw new
                    Exception
                    ("El titular proporcionado y el de la reserva no coinciden!");
                }
            }
        }
    if (encontrado==0)
    {
    throw new Exception("No existe una reserva con ese numero!");
    }
  }

  public void modificarReserva(int num, int control,
                               Date nueva) throws Exception
  {

    int encontrado=0;
      for (int i = 0; i < reservas.size(); i++)
        {

          Reserva n = (Reserva) reservas.get(i);

          if (num == n.getNumReserva())
            {
              encontrado=1;
              if (control == 1)
                {
                  n.setIda(nueva); 
                  System.out.println("Se ha modificado la fecha de ida");
                }
              else
                {
                  n.setVuelta(nueva);
                  System.out.println("Se ha modificado la fecha de vuelta");
                }
            }
        }

    
    if(encontrado==0)
    {
      throw new Exception("No existe una reserva con ese numero!");
    }

  }


  public Reserva[] ReservasDelTitular(String dni) throws Exception
  {

    Vector v = new Vector();


    for (int i = 0; i < reservas.size(); i++)
      {

        Reserva n = (Reserva) reservas.get(i);

        if (n.getTitular().getDni().indexOf(dni) != -1)
          {
            v.add(n);
          }
      }

    if (v.size() > 0)
      {

        Reserva vn[] = new Reserva[v.size()];

        for (int k = 0; k < v.size(); k++)
          {
            vn[k] = (Reserva) v.get(k);
          }

        return vn;

      }
    else
      throw new Exception("DNI no encontrado.");

  }


    
}
