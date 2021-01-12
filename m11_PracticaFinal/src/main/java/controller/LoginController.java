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
    private static String LOGIN = "/index.html";
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
        if(dao.getAllTrabajadores().isEmpty()){
            response(response, "No hay usuarios");
        }
        else{
            for(Trabajador elem:dao.getAllTrabajadores()){
                if(user == elem.getCorreo()){
                    if(pass == elem.getContraseña()){
                        response(response,"Login succedeed");
                    }
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
