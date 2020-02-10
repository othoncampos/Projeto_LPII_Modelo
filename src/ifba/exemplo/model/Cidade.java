package ifba.exemplo.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name="cidade")
public class Cidade {
	
	@Id
	@Column(name="cd_cidade")
	private int cd_cidade;
	
	@Column(name="nm_cidade")
	private String nm_cidade;
	
	@Column(name="sigla_estado")
	private String sigla_estado;
	
	public Cidade() {
		super();
	}
	
	public Cidade(int cd_cidade, String nm_cidade, String sigla_estado) {
		super();
		this.cd_cidade = cd_cidade;
		this.nm_cidade = nm_cidade;
		this.sigla_estado = sigla_estado;
	}

	public int getCd_cidade() {
		return cd_cidade;
	}

	public void setCd_cidade(int cd_cidade) {
		this.cd_cidade = cd_cidade;
	}

	public String getNm_cidade() {
		return nm_cidade;
	}

	public void setNm_cidade(String nm_cidade) {
		this.nm_cidade = nm_cidade;
	}

	public String getSigla_estado() {
		return sigla_estado;
	}

	public void setSigla_estado(String sigla_estado) {
		this.sigla_estado = sigla_estado;
	}

	public static void main(String[] args) {
		ArrayList<String> s = new ArrayList<String>();
		s.add("Othon");
		s.add("Stuart");
		s.add("Ferreira");
		s.add("Campos");
		
		int i = 0;
		System.out.println( "---: WHILE" );
		while( i < s.size() ) {
			System.out.println( s.get( i++ ) );
		}
		
		System.out.println( "\n---: FOR" );
		for(i=0; i<s.size();i++) {
			System.out.println( s.get( i ) );
		}
		System.out.println( "\n---: FOREACH" );
		for (String aux : s) {
			System.out.println( aux );
		}
		
		
	}
	
}
