package br.com.welligton.spring.data.escola.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.welligton.spring.data.escola.orm.Aluno;
import br.com.welligton.spring.data.escola.orm.Turma;
import br.com.welligton.spring.data.escola.repository.AlunoRepository;
import br.com.welligton.spring.data.escola.repository.TurmaRepository;

@Service
public class CrudAlunoService {
	
	private AlunoRepository alunoRepository;
	private TurmaRepository turmaRepository;
	private boolean system = true;
	
	public CrudAlunoService(AlunoRepository alunoRepository,
			TurmaRepository turmaRepository) {
		 this.alunoRepository = alunoRepository;
		 this.turmaRepository = turmaRepository;
	}
	
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("ALUNO - ESCOLHA UMA AÇÃO!");
			System.out.println("0 - SAIR");
			System.out.println("1 - CADASTRAR MATRICULA COM SUA TURMA");
			System.out.println("2 - LISTAR MATRICULAS");
			
		 
			
			int acao = scanner.nextInt();
			switch (acao) {
			case 1:
				cadastrarMatricula(scanner);
				break;
			case 2:
				listarMatriculas(scanner);
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


	private void listarMatriculas(Scanner scanner) {
		Iterable<Aluno> alunos = alunoRepository.findAll();
		alunos.forEach(aluno -> System.out.println(aluno));
		
	}


	private void cadastrarMatricula(Scanner scanner) {
		System.out.println("DIGITE A MATRICULA ");
		String matricula = scanner.next();
		
		 System.out.println("DIGITE A TURMA-ID DO ALUNO");
	     Integer turmaId = scanner.nextInt();
	     Optional<Turma> turma= turmaRepository.findById(turmaId);
		 
		Aluno aluno = new Aluno();
	 
		aluno.setMatricula(matricula);
		aluno.setTurma(turma.get());
		
		
		alunoRepository.save(aluno);
		
		System.out.println("ALUNO SALVO!\n\n");
		
		
	}

	
}
