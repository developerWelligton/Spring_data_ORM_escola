package br.com.welligton.spring.data.escola.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.welligton.spring.data.escola.orm.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer>{

}
	