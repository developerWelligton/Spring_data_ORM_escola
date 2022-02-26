package br.com.welligton.spring.data.escola.orm;

import java.util.List;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
 
 

@Entity
@Table(name = "turmas")
public class Turma {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sala;
	 
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	
	@Override
	public String toString() {
		return "Turma [id=" + id + ", sala=" + sala + "]";
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
	
}
