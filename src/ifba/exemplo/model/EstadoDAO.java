package ifba.exemplo.model;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import ifba.exemplo.util.HibernateUtil;

public class EstadoDAO 
{
	/**
	 * Método para cadastrar um estado
	 * @param est - Um objeto do tipo Estado 
	 */
	public void cadastrar(Estado est) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(est);
		s.getTransaction().commit();
		s.close();
	}
	
	/**
	 * Método para excluir um estado 
	 * @param est - Um objeto do tipo Estado
	 */
	public void excluir(Estado est) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.delete(est);
		s.getTransaction().commit();
		s.close();
	}

	public void excluir(String idEstado) {
		Estado e = consultar(idEstado);
		if( e != null )
			excluir(e);
	}
	
	/**
	 * Método para modificar um estado 
	 * @param est - Um objeto do tipo Estado
	 */
	public void alterar(Estado est) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.update(est);
		s.getTransaction().commit();
		s.close();
	}
	
	public Estado consultar(String idEstado) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select * from estado where sigla_estado = :idEstado");
		query.addEntity(Estado.class);
		query.setParameter("idEstado", idEstado);
		Estado e = (Estado) query.uniqueResult();
		s.close();
		return e;
	}

	public List<Estado> consultar() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select * from estado");
		query.addEntity(Estado.class);
		List<Estado> lista = query.list();
		s.close();
		return lista;
	}
	
	public BigInteger getNumeroEstadosCadastrados() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select count(*) from estado;");
		BigInteger qtd = (BigInteger) query.uniqueResult();
		s.close();
		return qtd;
	}
	
	public static void main(String[] args) {
		EstadoDAO d = new EstadoDAO();
		System.out.println("LISTANDO TODOS OS ESTADOS:");
		for (Estado aux : d.consultar()) {
			System.out.println(aux.getSigla_estado() + " - " + aux.getNome_estado());
		}
		System.out.println();
		System.out.println("EXIBINDO APENAS O ESTADO DA BAHIA:");
		System.out.println("Estado: " + d.consultar("BA").getNome_estado() );
		
		d.excluir("PE");
		for (Estado aux : d.consultar()) {
			System.out.println(aux.getSigla_estado() + " - " + aux.getNome_estado());
		}
		
		Estado e = new Estado("PE", "Pernambucoooo");
		d.cadastrar(e);
		for (Estado aux : d.consultar()) {
			System.out.println(aux.getSigla_estado() + " - " + aux.getNome_estado());
		}
		
		e = new Estado("PE", "Pernambuco");
		d.alterar(e);
		
		for (Estado aux : d.consultar()) {
			System.out.println(aux.getSigla_estado() + " - " + aux.getNome_estado());
		}
		
		System.out.println("Quant: " + d.getNumeroEstadosCadastrados() );
	}
}
