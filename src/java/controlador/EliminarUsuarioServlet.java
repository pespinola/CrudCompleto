/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import datos.Crud;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pathy
 */
@WebServlet(name = "EliminarUsuarioServlet", urlPatterns = {"/eliminar.do"})
public class EliminarUsuarioServlet extends HttpServlet {

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
            throws ServletException, IOException {
      
        String id = request.getParameter("id");
        
        if(id.isEmpty()==true){
            String error = "Campo id vacío";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }else{
            Crud crudUsuario = new Crud();
            crudUsuario.eliminarUsuario(Integer.parseInt(id));
            
            if(crudUsuario.eliminarUsuario(Integer.parseInt(id)) == true){
                String mensaje = "Se elimino correctamente el usuario ";
                request.getSession().setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
            }else{
                String mensaje = "Hubo problemas al eliminar ";
                request.getSession().setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
