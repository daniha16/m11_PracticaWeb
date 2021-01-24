/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Empresa;
import util.Log;
import util.EmpresaDao;

/**
 *
 * @author danih
 */
public class EmpresaController extends HttpServlet{
    private static String INICIO = "index.jsp";
    private static String EMPRESAS_RRHH = "/RRHH/empresasRRHH.jsp";
    private static String DELETE_EMPRESAS = "/RRHH/empresasRRHH.jsp";
    private static String INSERT_OR_EDIT = "/RRHH/editEmpresas.jsp";
    private EmpresaDao dao;
    
    public EmpresaController() {
        super();
        dao = new EmpresaDao();
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
                System.out.println("ESTOY EN DELETE");
                dao.deleteEmpresa(request.getParameter("empresaCif"));
                forward = DELETE_EMPRESAS;
                request.setAttribute("listaEmpresas", dao.getAllEmpresas());
            } else if (action.equalsIgnoreCase("edit")) {
                Log.log.info("Parametro valor EDIT");
                forward = INSERT_OR_EDIT;
                int userId = Integer.parseInt(request.getParameter("empresaCif"));
                Empresa empresa = dao.getEmpresaByCif(userId);
                request.setAttribute("empresa", empresa);
            } else if (action.equalsIgnoreCase("listEmpresas")) {
                Log.log.info("Parametro valor LIST");
                System.out.println("ESTOY EN LISTA EMPRESAS");
                forward = EMPRESAS_RRHH;
                request.setAttribute("listaEmpresas", dao.getAllEmpresas());
                System.out.println(dao.getAllEmpresas());
                for(Empresa elem:dao.getAllEmpresas()){
                    System.out.println("PARTE2: "+elem.getCif());
                    System.out.println("PARTE2: "+elem.getNombre());
                    System.out.println("PARTE2: "+elem.getCodigo_postal());
                    System.out.println("PARTE2: "+elem.getDireccion());
                    System.out.println("PARTE2: "+elem.getPoblacion());
                    System.out.println("PARTE2: "+elem.getProvincia());
                    System.out.println("PARTE2: "+elem.getTelefono());
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
}
