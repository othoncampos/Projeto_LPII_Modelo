
package ifba.exemplo.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifba.exemplo.model.Estado;
import ifba.exemplo.model.EstadoDAO;

@WebServlet(name = "EstadoController", urlPatterns = {"/EstadoController"})
public class EstadoController extends HttpServlet {

    private EstadoDAO estadoDAO;
    
    public static final String LIST = "./ListarEstado.jsp";
    public static final String INSERT_OR_EDIT = "./ManterEstado.jsp";

    public EstadoController() {
        super();
        estadoDAO = new EstadoDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String forward = "";
        String acao = request.getParameter("acao");

        try {
            if (acao.equalsIgnoreCase("deletar")) {
                forward = LIST;
                String id = (request.getParameter("ID"));
                estadoDAO.excluir(id);
            } else if (acao.equalsIgnoreCase("editar")) {
                forward = INSERT_OR_EDIT;
                String id = (request.getParameter("ID"));
                Estado est = estadoDAO.consultar(id);
                request.setAttribute("estado", est);
            } else if (acao.equalsIgnoreCase("inserir")) {
                forward = INSERT_OR_EDIT;
            } else {
                forward = LIST;
                request.setAttribute("estados", estadoDAO.consultar());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String sigla = request.getParameter("sigla");
        String nome = request.getParameter("nm_estado");
        String idEst = request.getParameter("idEst");

        System.out.println("TelaController - doPost - codigo: " + sigla);
        System.out.println("TelaController - doPost - nome..: " + nome);
        System.out.println("TelaController - doPost - idFab.: " + idEst);

        if (idEst == null) {
            idEst = "";
        }

        System.out.println("LoginController.doPost: Teste.");
        Estado e = null;
        String forward = LIST;
        try {
            if (idEst.trim().isEmpty()) {
                e = new Estado();
                e.setSigla_estado(sigla);
                e.setNome_estado(nome);
                estadoDAO.cadastrar(e);
            } else {
                e = estadoDAO.consultar(sigla);
                e.setNome_estado(nome);
                estadoDAO.alterar(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
