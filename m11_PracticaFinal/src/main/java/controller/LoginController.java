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
import javax.servlet.http.HttpSession;
import model.Trabajador;
import util.Log;
import util.TrabajadorDao;

/**
 *
 * @author danih
 */
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String LOGIN_EMPLEADOS = "/Empleados/main.jsp";
    private static String LOGIN_RRHH = "/RRHH/main.jsp";
    private static String LOGIN_FAILED = "/index.jsp";
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
        //String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        String action = request.getParameter("action");
        HttpSession sesion = request.getSession();
        if(action.equals("Logout")){
            sesion.invalidate();
            RequestDispatcher view = getServletContext().getRequestDispatcher("/index.jsp");            
            view.forward(request, response);
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
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("usuario")!=null){
            Trabajador user = (Trabajador)sesion.getAttribute("usuario");
            System.out.println("CORREO "+user.getCorreo());
            sesion.invalidate();
            sesion = request.getSession();
        }
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
                System.out.println(elem.getCorreo());
                if(correo.equals(elem.getCorreo())&& pass.equals(elem.getContraseña()) && sesion.getAttribute("usuario") == null){
                    System.out.println("El usuario se encuentra en la bd");
                    if(elem.getTipo().equals("Empleado")){
                        System.out.println("LOGIN DE EMPLEADO");
                        forward=LOGIN_EMPLEADOS;
                        sesion.setAttribute("usuario", elem); 
                        RequestDispatcher view = getServletContext().getRequestDispatcher(forward);            
                        view.forward(request, response);
                        return;
                    }
                    else if(elem.getTipo().equals("RRHH")){
                        sesion.setAttribute("usuario", elem);
                        System.out.println("LOGIN DE RRHH");
                        forward=LOGIN_RRHH;
                        request.setAttribute("usuario",elem);
                        RequestDispatcher view = getServletContext().getRequestDispatcher(forward);            
                        view.forward(request, response);
                        return;
                    }                   
                }
                
            }
            if(pass != null || correo != null){
                System.out.println("FALLO DE CONTRASEÑA");
                forward=LOGIN_FAILED;                      
                RequestDispatcher view = getServletContext().getRequestDispatcher(forward);            
                view.forward(request, response);
                return;
            }
                
        }
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
