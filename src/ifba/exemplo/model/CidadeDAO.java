package ifba.exemplo.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import ifba.exemplo.util.HibernateUtil;

public class CidadeDAO 
{
	/**
	 * Método para cadastrar um cidade
	 * @param est - Um objeto do tipo Cidade 
	 */
	public void cadastrar(Cidade cid) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.save(cid);
		s.getTransaction().commit();
		s.close();
	}
	
	/**
	 * Método para excluir um estado 
	 * @param est - Um objeto do tipo Estado
	 */
	public void excluir(Cidade cid) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.delete(cid);
		s.getTransaction().commit();
		s.close();
	}

	public void excluir(int idCidade) {
		Cidade c = consultar(idCidade);
		if( c != null )
			excluir(c);
	}
	
	/**
	 * Método para modificar um estado 
	 * @param est - Um objeto do tipo Estado
	 */
	public void alterar(Cidade cid) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.update(cid);
		s.getTransaction().commit();
		s.close();
	}
	
	public Cidade consultar(int idCidade) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select * from cidade where cd_cidade = :idCidade");
		query.addEntity(Cidade.class);
		query.setParameter("idCidade", idCidade);
		Cidade c = (Cidade) query.uniqueResult();
		s.close();
		return c;
	}
	
	public List<Cidade> consultarByEstado(String idEstado) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select * from cidade where sigla_estado = :idEstado");
		query.addEntity(Cidade.class);
		query.setParameter("idEstado", idEstado);
		List<Cidade> list = query.list();
		s.close();
		return list;
	}

	public List<Cidade> consultar() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select * from cidade");
		query.addEntity(Cidade.class);
		List<Cidade> lista = query.list();
		s.close();
		return lista;
	}
	
	public int getNumeroCidadesCadastradas() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		SQLQuery query = s.createSQLQuery("select count(*) from cidade");
		int qtd = (int) query.uniqueResult();
		s.close();
		return qtd;
	}
	
	public static void main(String[] args) {
		Cidade cidade = new Cidade();
		CidadeDAO d = new CidadeDAO();
		System.out.println("LISTANDO TODOS OS ESTADOS:");
		cidade.setCd_cidade(1);
		cidade.setNm_cidade("Cidade");
		cidade.setSigla_estado("SE");
		
		d.cadastrar( cidade );

		
		
	}
}
