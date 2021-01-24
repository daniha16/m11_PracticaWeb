/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Peticion;
import util.Log;
import util.PeticionesDao;

/**
 *
 * @author danih
 */
public class PeticionesController extends HttpServlet {
    private static String INICIO = "index.jsp";
    private static String LIST_PETICIONES = "/RRHH/peticiones.jsp";
    private static String INSERT_OR_EDIT = "/RRHH/peticiones.jsp";
    private PeticionesDao dao;
    public PeticionesController() {
        super();
        dao = new PeticionesDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log.log.info("Entramos en el doGet");
        HttpSession sesion = request.getSession();
        System.out.println("Comprobando sesiones");
        if(sesion.getAttribute("usuario") == null){
            response.sendRedirect(INICIO);
            return;
        }
        else{
            String forward = "";
            String action = request.getParameter("action");
            Log.log.info("Recogemos el parametro action con valor " + action);
            if (action.equalsIgnoreCase("delete")) {
                Log.log.info("Parametro valor DELETE");
                int reqId = Integer.parseInt(request.getParameter("peticionId"));
                dao.deletePeticion(reqId);
                forward = LIST_PETICIONES;
                request.setAttribute("peticiones", dao.getAllPeticiones());
            } else if (action.equalsIgnoreCase("edit")) {
                Log.log.info("Parametro valor EDIT");
                forward = INSERT_OR_EDIT;
                int reqId = Integer.parseInt(request.getParameter("peticionId"));
                Peticion peticion = dao.getPeticionById(reqId);
                request.setAttribute("peticion", peticion);
            } else if (action.equalsIgnoreCase("listPeticiones")) {
                Log.log.info("Parametro valor LIST");
                System.out.println("ESTOY EN LISTA PETICIONES");
                forward = LIST_PETICIONES;
                request.setAttribute("listaPeticiones", dao.getAllPeticiones());
                System.out.println(dao.getAllPeticiones());
                for(Peticion i:dao.getAllPeticiones()){
                    System.out.println(i.getReqid());
                }
            } else if (action.equalsIgnoreCase("denegar")) {
                Log.log.info("Parametro valor LIST");
                System.out.println("ESTOY EN DENEGAR");
                forward = LIST_PETICIONES;
                System.out.println("Antes de petar");
                int reqId = Integer.parseInt(request.getParameter("reqId"));
                System.out.println("REQID: "+reqId);
                dao.denegarPeticion(reqId);
                request.setAttribute("listaPeticiones", dao.getAllPeticiones());
                System.out.println(dao.getAllPeticiones());
                for(Peticion i:dao.getAllPeticiones()){
                    System.out.println(i.getReqid());
                }
            }else if (action.equalsIgnoreCase("aceptar")) {
                Log.log.info("Parametro valor LIST");
                System.out.println("ESTOY EN ACEPTAR");
                forward = LIST_PETICIONES;
                System.out.println("Antes de petar");
                int reqId = Integer.parseInt(request.getParameter("reqId"));
                System.out.println("REQID: "+reqId);
                dao.aceptarPeticion(reqId);
                request.setAttribute("listaPeticiones", dao.getAllPeticiones());
                System.out.println(dao.getAllPeticiones());
                for(Peticion i:dao.getAllPeticiones()){
                    System.out.println(i.getReqid());
                }
            }else {
                Log.log.info("Parametro valor vacio vamos a insertar");
                forward = INSERT_OR_EDIT;
            }
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
            return;
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log.log.info("Entramos por el doPost");
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("usuario") == null){
            response.sendRedirect(INICIO);
        }
/*        processRequest(request, response); */
        return;
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
