package br.com.welligton.spring.data.escola.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.welligton.spring.data.escola.orm.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer>{

}
	