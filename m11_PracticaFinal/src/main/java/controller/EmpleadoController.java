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
import model.Trabajador;
import util.Log;
import util.EmpleadoDao;
import util.TrabajadorDao;

/**
 *
 * @author danih
 */
public class EmpleadoController extends HttpServlet {
    private static String INICIO = "index.jsp";
    private static String LIST_EMPLEADOS = "/RRHH/trabajadoresRRHH.jsp";
    private static String INSERT_OR_EDIT = "/RRHH/editEmpleado.jsp";
    private static String SERV_EMPLEADOS = "/EmpleadoController?action=listEmpleados";
    private EmpleadoDao dao;
    private TrabajadorDao dao2;
    public EmpleadoController() {
        super();
        dao = new EmpleadoDao();
        dao2 = new TrabajadorDao();
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
                System.out.println("ENTRANDO EN DELETE");
                String id = request.getParameter("trabajadorIden");
                System.out.println(id);
                int userId = Integer.parseInt(request.getParameter("trabajadorIden"));
                System.out.println("LA BARRERA");
                dao.deleteTrabajador(userId);
                forward = LIST_EMPLEADOS;
                request.setAttribute("listaEmpleados", dao.getAllEmpleados());
            } else if (action.equalsIgnoreCase("edit")) {
                Log.log.info("Parametro valor EDIT");
                forward = INSERT_OR_EDIT;
                int userId = Integer.parseInt(request.getParameter("trabajadorIden"));
                Trabajador trabajador = dao.getTrabajadorByIden(userId);
                request.setAttribute("empleado", trabajador);
            } else if (action.equalsIgnoreCase("update")) {
                Log.log.info("Parametro valor EDIT");
                int iden = Integer.parseInt(request.getParameter("iden"));
                Trabajador empleado = dao2.getTrabajadorByIden(iden);
                empleado.setDni(request.getParameter("dni"));
                empleado.setNombre(request.getParameter("nombre"));
                System.out.println("NOMBRE: "+request.getParameter("nombre"));
                empleado.setApellidos(request.getParameter("apellidos"));
                empleado.setTelefono(Integer.parseInt(request.getParameter("telefono")));
                dao.updateTrabajador(empleado);
                response.sendRedirect(request.getContextPath()+SERV_EMPLEADOS);
                return;
            }else if (action.equalsIgnoreCase("listEmpleados")) {
                Log.log.info("Parametro valor LIST");
                System.out.println("ESTOY EN LISTA EMPLEADOS");
                forward = LIST_EMPLEADOS;
                request.setAttribute("listaEmpleados", dao.getAllEmpleados());
                System.out.println(dao.getAllEmpleados());
                for(Trabajador i:dao.getAllEmpleados()){
                    System.out.println(i.getNombre());
                }
            } else {
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
        Trabajador user = new Trabajador();
        user.setNombre(request.getParameter("firstName"));
        user.setApellidos(request.getParameter("lastName"));                
        user.setCorreo(request.getParameter("email"));
        String userid = request.getParameter("userid");
        if (userid == null || userid.isEmpty()) {
            Log.log.info("Vamos a añadir el usuario");
            dao.addTrabajador(user);
        } else {
            user.setIden(Integer.parseInt(userid));
            dao.updateTrabajador(user);
        }
        request.setAttribute("empleados", dao.getAllEmpleados());
        RequestDispatcher view = request.getRequestDispatcher(LIST_EMPLEADOS);            
        view.forward(request, response);
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
