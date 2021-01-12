/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import static java.lang.System.out;
import static java.sql.JDBCType.NULL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Trabajador;
import util.Log;
import util.TrabajadorDao;

/**
 *
 * @author danih
 */
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String LOGIN_EMPLEADOS = "/Empleados/main.html";
    private static String LOGIN_RRHH = "RRHH/main.html";
    private static String LOGIN_FAILED = "/index.html";
    private TrabajadorDao dao;
    private Log log;
    
    public LoginController(){
        super();
        dao = new TrabajadorDao();
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
        String forward = "";
        Log.log.info("Entramos por el doPost");
        String correo = request.getParameter("correo");
        System.out.println(correo);
        String pass = request.getParameter("pwd");
        System.out.println(pass);
        System.out.println("HELLO THERE!");
        System.out.println(dao.getAllTrabajadores());
        if(dao.getAllTrabajadores()== null){
            System.out.println("NO HAY USUARIOS");
            response(response, "No hay usuarios");
        }
        else{
            for(Trabajador elem:dao.getAllTrabajadores()){
                if(correo.equals(elem.getCorreo())){
                    System.out.println("EXISTE EL USUARIO");
                    if(pass.equals(elem.getContraseña())){
                        System.out.println("EXISTE LA PASSWORD");
                        if(elem.getTipo().equals("Empleado")){
                            System.out.println("LOGIN DE EMPLEADO");
                            forward=LOGIN_EMPLEADOS;
                            response.sendRedirect("../m11_PracticaFinal/Empleados/main.html");
                            return;
                        }
                        else if(elem.getTipo().equals("RRHH")){
                            System.out.println("LOGIN DE RRHH");
                            forward=LOGIN_RRHH;
                            response.sendRedirect("../m11_PracticaFinal/RRHH/main.html");
                            return;
                        }                   
                    }
                    else if(pass != null){
                        System.out.println("FALLO DE CONTRASEÑA");
                        forward=LOGIN_FAILED;
                        response.sendRedirect("../m11_PracticaFinal/index.html");
                        return;
                    }
                }
                else if(correo != null){
                    forward=LOGIN_FAILED;
                    response.sendRedirect("../m11_PracticaFinal/index.html");
                    return;
                }
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);            
        view.forward(request, response);
    }
    
    private void response(HttpServletResponse resp, String msg)
			throws IOException {

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
