package br.com.welligton.spring.data.escola.service;

import java.util.Scanner;
 
import org.springframework.stereotype.Service;
 
import br.com.welligton.spring.data.escola.orm.Turma;
import br.com.welligton.spring.data.escola.repository.TurmaRepository;

@Service
public class CrudTurmaService {
	
	private TurmaRepository turmaRepository;
	private boolean system = true;
	
	public CrudTurmaService(TurmaRepository turmaRepository) {
		 this.turmaRepository = turmaRepository;
	}
	
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("TURMA - ESCOLHA UMA AÇÃO!");
			System.out.println("0 - SAIR");
			System.out.println("1 - CADASTRAR SALA");
			System.out.println("2 - LISTAR SALA");
			
			int acao = scanner.nextInt();
			switch (acao) {
			case 1:
				cadastrarSala(scanner);
				break;
			case 2:
				listarSala();
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


	private void listarSala() {
		Iterable<Turma> turmas = turmaRepository.findAll();
		turmas.forEach(turma -> System.out.print(turma)); 
		
	}


	private void cadastrarSala(Scanner scanner) {
		
		System.out.println("Digite o numero da sala!!");
		String sala = scanner.next();
		
		Turma turma = new Turma();
		turma.setSala(sala);
		
		turmaRepository.save(turma);
		
		System.out.println("turma salva!"); 
		
	}
	
}
