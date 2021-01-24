/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Proyecto;
import model.Trabajador;
import model.TrabajadorProyecto;
import util.Log;
import util.ProyectoDao;
import util.TrabajadorProyectoDao;

/**
 *
 * @author danih
 */
public class ProyectoController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String EDIT = "/RRHH/editProyecto.jsp";
    private static String PROYECTOS_RRHH = "/RRHH/proyectosRRHH.jsp";
    private static String TIME_PROYECTO = "/Empleados/proyectos.jsp";
    private static String ADD_TIME = "/Empleados/addTimeProyectos.jsp";
    private static String LISTA_TPROYECTOS = "/Empleados/proyectos.jsp";
    private static String LISTA_PROYECTOS = "/Empleados/proyectos.jsp";
    private static String SERV_PROYECTOS_RRHH = "/ProyectoController?action=listProyectosRRHH";
    private static String SERV_PROYECTOS = "/ProyectoController?action=listTrabajadorProyectos";
    private static String INICIO = "index.jsp";
    private ProyectoDao dao;
    private TrabajadorProyectoDao dao2;
    private Log log;

    public ProyectoController() {
        super();
        dao = new ProyectoDao();
        dao2 = new TrabajadorProyectoDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        System.out.println("Comprobando sesiones");
        if(sesion.getAttribute("usuario") == null){
            System.out.println("NO HAY SESIOOOOON");
            response.sendRedirect(INICIO);
        }
        else{
            String forward = "";
            System.out.println(sesion.getAttribute("usuario"));
            Trabajador userNombre = (Trabajador)sesion.getAttribute("usuario");
            System.out.println("NOMBRE: "+userNombre.getNombre());
            Log.log.info("Entramos en el doGet");
            String action = request.getParameter("action");
            Log.log.info("Recogemos el parametro action con valor " + action);
            if (action.equalsIgnoreCase("delete")) {
                System.out.println("POS 1");
                Log.log.info("Parametro valor DELETE");
                dao.deleteProyecto(request.getParameter("proyectoId"));
                forward = PROYECTOS_RRHH;
                request.setAttribute("listaProyectos", dao.getAllProyectos());
            } else if (action.equalsIgnoreCase("edit")) {
                System.out.println("POS 2");
                Log.log.info("Parametro valor EDIT");
                forward = EDIT;
                String id = request.getParameter("id");
                System.out.println("ID: "+id);
                Proyecto proyecto = dao.getProyectoById(id);
                request.setAttribute("proyecto", proyecto);
            } else if (action.equalsIgnoreCase("update")) {
                Log.log.info("Parametro valor UPDATE");
                System.out.println("ENTRO EN PROYECTOS UPDATE");
                String id = request.getParameter("id");
                Proyecto proyecto = dao.getProyectoById(id);
                proyecto.setDescripcion(request.getParameter("desc"));
                proyecto.setCif_empresa(request.getParameter("cif"));
                System.out.println("desc: "+request.getParameter("desc"));
                System.out.println("cif: "+request.getParameter("cif"));
                dao.updateProyecto(proyecto);
                response.sendRedirect(request.getContextPath()+SERV_PROYECTOS_RRHH);
                return;
            }else if (action.equalsIgnoreCase("listProyectosRRHH")) {
                System.out.println("POS 3");
                System.out.println("LISTADO CON PROYECTOS........");
                Log.log.info("Parametro valor LIST");
                forward = PROYECTOS_RRHH;
                System.out.println(dao.getAllProyectos());
                request.setAttribute("listaProyectos", dao.getAllProyectos());
            }else if (action.equalsIgnoreCase("addTime")) {
                System.out.println("ESTOY EN ADDTIME");
                Log.log.info("Parámetro valor ADDTIME");
                forward = ADD_TIME;
                String id = request.getParameter("id");
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                int iden = user.getIden();
                Proyecto proyecto = dao.getProyectoById(id);
                System.out.println("ID: "+proyecto.getId());
                float horas = dao2.getTimeProyectoIden(iden,id);
                System.out.println("HORAS: "+horas);
                proyecto.setTiempo(horas);
                request.setAttribute("proyecto", proyecto);   
            }else if (action.equalsIgnoreCase("updateTime")) {
                Log.log.info("Parametro valor UPDATE");
                System.out.println("ENTRO EN PROYECTOS UPDATE");
                String id = request.getParameter("id");
                System.out.println("ID: "+id);
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                int iden = user.getIden();
                System.out.println("IDEN: "+iden);
                float horas = Float.parseFloat(request.getParameter("horas"));
                System.out.println("HORAS: "+horas);
                float addedTime = Float.parseFloat(request.getParameter("addedTime"));
                System.out.println("ADDED: "+addedTime);
                float result = horas+addedTime;
                System.out.println("RESULT: "+result);
                TrabajadorProyecto tp = dao2.getTrabajadorProyecto(iden,id);
                System.out.println("TP: "+tp);
                System.out.println("TP: "+tp.getId_proyecto());
                System.out.println("TP: "+tp.getIden_trabajador());
                System.out.println("TP: "+tp.getHoras());
                tp.setHoras(result);
                dao2.updateTimeTrabajadorProyecto(tp);
                response.sendRedirect(request.getContextPath()+SERV_PROYECTOS);
                return;
            }else if (action.equalsIgnoreCase("listTrabajadorProyectos")){
                System.out.println("POS 5");
                Log.log.info("Parámetro valor LIST PROYECTOS TRABAJADOR");
                forward = LISTA_TPROYECTOS;
                System.out.println("FLAG1");
                Trabajador user = (Trabajador)sesion.getAttribute("usuario");
                int iden = user.getIden();
                System.out.println(iden);
                List<TrabajadorProyecto> idenList = dao2.getProyectoByIden(iden);
                System.out.println("FLAG2");
                List<Proyecto> listaProyectos = new  ArrayList<Proyecto>();
                for(TrabajadorProyecto elem:idenList){
                    Proyecto proyecto = dao.getProyectoById(elem.getId_proyecto());
                    proyecto.setTiempo(elem.getHoras());
                    listaProyectos.add(proyecto);
                }
                request.setAttribute("proyectosTrabajador", listaProyectos);
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
        else{
    /*          processRequest(request, response); */
            Proyecto proyecto = new Proyecto();
            proyecto.setId(request.getParameter("id"));
            proyecto.setDescripcion(request.getParameter("descripcion"));                
            proyecto.setCif_empresa(request.getParameter("cif_empresa"));
            proyecto.setId(request.getParameter("id"));
            request.setAttribute("proyecto", dao.getAllProyectos());
            RequestDispatcher view = request.getRequestDispatcher(LISTA_PROYECTOS);            
            view.forward(request, response);
            return;
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
}
