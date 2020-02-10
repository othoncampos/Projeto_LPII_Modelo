package ifba.exemplo.view;

import java.util.List;

import ifba.exemplo.model.Cidade;
import ifba.exemplo.model.CidadeDAO;

public class CidadeView {
	public CidadeView() {
		super();
	}
	
	public List<Cidade> getCidades() throws Exception {
        List<Cidade> list = null;
        try {
        	CidadeDAO dao = new CidadeDAO();
        	list = dao.consultar();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar estados!");
        }
        return list;
    }

	public List<Cidade> getCidadesByEstado(String idEstado) throws Exception {
        List<Cidade> list = null;
        try {
        	CidadeDAO dao = new CidadeDAO();
        	list = dao.consultarByEstado(idEstado);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar estados!");
        }
        return list;
    }
	
	public Integer getQuantidade() throws Exception {
		int qtd = 0;
        try {
            qtd = (new CidadeDAO()).getNumeroCidadesCadastradas();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar estados!");
        }
        return qtd;
    }
	
	
	/*
	 *  public void cadastrar(EstadoTO estado) throws Exception {
        try {
           
            new EstadoDAO().cadastrar(estado);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao cadastrar estado!");
        }
    }

    public void excluir(EstadoTO m) throws Exception {
        try {
            new EstadoDAO().excluir(m);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao excluir estado!");
        }
    }


    public void excluir(String sigla) throws Exception {
        try {
            new EstadoDAO().excluir(sigla);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao excluir estado!");
        }
    }

    public void alterar(EstadoTO m) throws Exception {
        try {
            new EstadoDAO().alterar(m);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao alterar estado!");
        }
    }


    public List<EstadoTO> getEstados()
            throws Exception {
        List<EstadoTO> list = null;
        try {
            list = (new EstadoDAO()).getEstados();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar estados!");
        }
        return list;
    }

    public EstadoTO consultarPeloCodigo(String sigla) throws Exception {
        try {
            EstadoTO f = new EstadoDAO().getEstadoPorCodigo(sigla);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar estado!");
        }
    }

	 */
}
