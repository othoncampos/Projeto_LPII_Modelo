package ifba.exemplo.view;

import java.math.BigInteger;
import java.util.List;


import ifba.exemplo.model.Estado;
import ifba.exemplo.model.EstadoDAO;

public class EstadoView {
	public List<Estado> getEstados() throws Exception {
        List<Estado> list = null;
        try {
            list = (new EstadoDAO()).consultar();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar estados!");
        }
        return list;
    }
	
	public int getQuantidade() throws Exception {
		int qtd = 0;
        try {
        	BigInteger bi = (new EstadoDAO()).getNumeroEstadosCadastrados();
        	qtd = bi.intValue();
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
