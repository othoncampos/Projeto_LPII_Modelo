package ifba.exemplo.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado {
	
	@Id
	@Column(name="sigla_estado")
	private String sigla_estado;
	
	@Column(name="nome_estado")
	private String nome_estado;
	
	public Estado() {
		super();
	}

	public Estado(String sigla_estado, String nome_estado) {
		super();
		this.sigla_estado = sigla_estado;
		this.nome_estado = nome_estado;
	}

	public String getSigla_estado() {
		return sigla_estado;
	}

	public void setSigla_estado(String sigla_estado) {
		this.sigla_estado = sigla_estado;
	}

	public String getNome_estado() {
		return nome_estado;
	}

	public void setNome_estado(String nome_estado) {
		this.nome_estado = nome_estado;
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
