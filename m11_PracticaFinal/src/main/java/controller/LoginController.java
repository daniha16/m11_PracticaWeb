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
    private static String LOGIN_EMPLEADOS = "Empleados/main.html";
    private static String LOGIN_RRHH = "RRHH/main.html";
    private static String LOGIN_FAILED = "index.html";
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
        Log.log.info("Entramos por el doPost");
        String user = request.getParameter("nombre");
        System.out.println(user);
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
                if(user.equals(elem.getCorreo())){
                    System.out.println("EXISTE EL USUARIO");
                    if(pass.equals(elem.getContraseña())){
                        System.out.println("EXISTE LA PASSWORD");
                        if(elem.getTipo().equals("Empleado")){
                            System.out.println("LOGIN DE EMPLEADO");
                            RequestDispatcher view = request.getRequestDispatcher(LOGIN_EMPLEADOS);            
                            view.forward(request, response);
                            return;
                        }
                        else if(elem.getTipo().equals("RRHH")){
                            System.out.println("LOGIN DE RRHH");
                            RequestDispatcher view = request.getRequestDispatcher(LOGIN_RRHH);            
                            view.forward(request, response);
                            return;
                        }                 
                        
                        response(response,"Login succedeed");
                    }
                    else{
                        RequestDispatcher view = request.getRequestDispatcher(LOGIN_FAILED);            
                        view.forward(request, response);
                        response(response, "Login Failed");
                    }
                }
                else{
                    RequestDispatcher view = request.getRequestDispatcher(LOGIN_FAILED);            
                    view.forward(request, response);
                    response(response, "Login Failed");
                    
                }
            }
        }
    }
    
    private void response(HttpServletResponse resp, String msg)
			throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><head></head><body onload=\"alert("+msg+")\"></body></html>");
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
