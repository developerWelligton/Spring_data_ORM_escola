package br.com.welligton.spring.data.escola.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.welligton.spring.data.escola.orm.Professor;
import br.com.welligton.spring.data.escola.orm.Turma;
import br.com.welligton.spring.data.escola.repository.ProfessorRepository;
import br.com.welligton.spring.data.escola.repository.TurmaRepository;

@Service
public class CrudProfessorService {
	
	private ProfessorRepository professorRepository;
	private TurmaRepository turmaRepository;
	private boolean system = true;
	
	public CrudProfessorService(ProfessorRepository professorRepository,
			TurmaRepository turmaRepository) {
		 this.professorRepository = professorRepository;
		 this.turmaRepository = turmaRepository;
	}
	
	
	public void inicial(Scanner scanner) {
		while(system) {
			
			System.out.println("PROFESSOR - ESCOLHA UMA AÇÃO!");
			System.out.println("0 - SAIR");
			System.out.println("1 - CADASTRAR NOME PROFESSOR COM SUA TURMA"); 
			System.out.println("2 - LISTAR PROFESSORES"); 
			
		 
			
			int acao = scanner.nextInt();
			switch (acao) {
			case 1:
				cadastrarNomeProfessor(scanner);
				break; 
			case 2:
				listarProfessores();
				break;
			case 0:
				system = false;
				break; 
			default:
				system = false;
				break;
			}
		}
		
	}


	private void listarProfessores() { 
		
		Iterable<Professor> professores = professorRepository.findAll();
		professores.forEach(professor -> System.out.println(professor));
		
	}


	private void cadastrarNomeProfessor(Scanner scanner) {
		
		System.out.println("DIGITE O NOME DO PROFESSOR");
		String nome = scanner.next();
		
		Professor professor = new Professor();
		professor.setNome(nome);
		
		
		System.out.println("PROFESSOR DISPONÍVEL \n\n");
		Iterable<Turma> turmas = turmaRepository.findAll();
		turmas.forEach(turma -> System.out.println(turma));
		System.out.println("\n");
		
		System.out.println("\nDIGITE UM ID DA TURMA!");
	    Integer id = scanner.nextInt();
	    
	    
	    //ERRO DE ASSOCIAR AS ENTIDADES
//	    Optional<Turma> Turma = turmaRepository.findById(id);
//	    professor.setTurma(Turma.get());
		 
		
		professorRepository.save(professor);
		
		System.out.println("NOME SALVO");
		
	}
  	
}
