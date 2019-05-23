/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import agenciawebservice.Agencia_Service;
import agenciawebservice.Exception_Exception;
import agenciawebservice.Reserva;
import agenciawebservice.Titular;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.importante;


/**
 *
 * @author María and Alex and Juan
 */
@WebServlet(urlPatterns = {"/Cliente"})
public class Cliente extends HttpServlet {


    @WebServiceRef(wsdlLocation = "http://maluz-pc:8080/Servicioweb/Agencia?wsdl")
    private Agencia_Service service_1;

    
  
    private String nombre=null;
    private String DNI=null;
 
     
    private  String idas=null;
    private  String vueltas=null;
     //Date ida= new Date();
  
   // Date vuelta = new Date();
    private  String origen=null;
    private String destino=null;
    Titular titular7 =new Titular();
    
    List<Reserva> consul;
    int devuelto=0;
    int opcion=0;
    int reserva=0;
    int control=0;
  
   
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DatatypeConfigurationException, Exception_Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(opcion==1){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
  
 

            out.println("<h1>Se ha creado la reserva con estos datos:</h1>");
          
             java.sql.Date ida=java.sql.Date.valueOf(idas);
             java.sql.Date vuelta=java.sql.Date.valueOf(vueltas);
             titular7.setNombre(nombre);
             titular7.setDni(DNI);
             
            out.println("<h1>Nombre: "+ nombre+"</h1>"); 
            out.println("<h1>DNI: "+ DNI+"</h1>");
            out.println("<h1> Fecha ida:"+ ida +"</h1>");
            out.println("<h1>Fecha vueltas:"+ vuelta+"</h1>");
            out.println("<h1>Origen:"+ origen+"</h1>");
            out.println("<h1>Destino:"+ destino+"</h1>");
            
            devuelto=crearReserva(getXmlGregorianCalendarFromDate(ida),getXmlGregorianCalendarFromDate(vuelta),origen,destino,titular7);
            out.println("<h3> TU RESERVA ES (guarda este numero es importante):"+devuelto+"</h3>");
            out.println("</body>");
            out.println("</html>");
        }
            if(opcion==2)
                {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User del Servicio Cancelar</title>");            
            out.println("</head>");
            out.println("<body>");
  
 

            out.println("<h1>Cancelación del viaje</h1>");
          
        
          
            //out.println("<h1>Nombre: "+ nombre+"</h1>"); 
             //out.println("<h1>DNI: "+ DNI+"</h1>");
         
             titular7.setNombre(nombre);
             titular7.setDni(DNI);
             cancelarReserva(reserva, titular7);
            out.println("<h3> Reserva Cancelada</h3>");
            out.println("</body>");
            out.println("</html>");
        }
            if(opcion==3)
                {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servicio Modificar</title>");            
            out.println("</head>");
            out.println("<body>");
  
 

            out.println("<h1>Modificación de la fecha</h1>");
          
        
          java.sql.Date ida=java.sql.Date.valueOf(idas);
            out.println("<h1>Nombre: "+ nombre+"</h1>"); 
             out.println("<h1>DNI: "+ DNI+"</h1>");
             out.println("<h1>DNI: "+ reserva+"</h1>");
         
             titular7.setNombre(nombre);
             titular7.setDni(DNI);
            
            try{ modificarReserva(reserva, control, getXmlGregorianCalendarFromDate(ida));
            out.println("<h3> Reserva Modificada</h3>");}
            catch (Exception_Exception exe){
            out.println("<h3> No se ha encontrado Reserva</h3>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
             if(opcion==4)
                {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consultar Reserva</title>");            
            out.println("</head>");
            out.println("<body>");
  
 

            out.println("<h1>Consultar Rerserva</h1>");
          
        
          
            //out.println("<h1>Nombre: "+ nombre+"</h1>"); 
            //out.println("<h1>DNI: "+ DNI+"</h1>");
         
             titular7.setNombre(nombre);
             titular7.setDni(DNI);
           
             //out.println(reservasDelTitular(DNI));
              try {
                  consul=reservasDelTitular(DNI);
            for (int i = 0; i < consul.size(); i++)
        {
         out.println("<h1>" + consul.get(i).getTitular().getNombre() + "</h1>");   
         //out.println("<h1>" + consul.get(i).getNumReserva() + "</h1>");   
         out.println("<h1>" + consul.get(i).getIda() + "</h1>");
         out.println("<h1>" + consul.get(i).getVuelta() + "</h1>");
         
        }
          
          //out.println("<h1>" + consul + "</h1>");
        } catch (Exception_Exception ex) {
             out.println("<h3> DNI no encontrado </h3>");
        }
            
            out.println("</body>");
            out.println("</html>");
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request,response);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        opcion= Integer.parseInt(request.getParameter("categoria"));
        if (opcion==1){
            nombre = request.getParameter("nombre");
         DNI = request.getParameter("DNI");
         idas= request.getParameter("fechaorigen");
         vueltas=request.getParameter("fechafinal");
         origen= request.getParameter("origen");
         destino= request.getParameter("destino");
        }
        if (opcion == 2){
          nombre = request.getParameter("nombre");
         DNI = request.getParameter("DNI");
         reserva= Integer.parseInt(request.getParameter("numreserva"));
        }
        if (opcion==3)
        {
         nombre = request.getParameter("nombre");
         DNI = request.getParameter("DNI");
          control= Integer.parseInt(request.getParameter("fecha"));
         idas= request.getParameter("fechamodif");
        
        
          reserva= Integer.parseInt(request.getParameter("numreserva"));
        }
        if (opcion==4){
             nombre = request.getParameter("nombre");
         DNI = request.getParameter("DNI");
         reserva= Integer.parseInt(request.getParameter("numreserva"));
        }
         
         
         
        try {
            processRequest(request, response);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception_Exception ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   

    private int crearReserva(javax.xml.datatype.XMLGregorianCalendar arg0, javax.xml.datatype.XMLGregorianCalendar arg1, java.lang.String arg2, java.lang.String arg3, agenciawebservice.Titular arg4) throws Exception_Exception {
  
    }
    
    public static XMLGregorianCalendar getXmlGregorianCalendarFromDate(final Date date) throws DatatypeConfigurationException{
	
   
}

    private void cancelarReserva(int arg0, agenciawebservice.Titular arg1) throws Exception_Exception {
  
    }


}
