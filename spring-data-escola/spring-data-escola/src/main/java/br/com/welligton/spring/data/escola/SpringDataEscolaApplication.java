package br.com.welligton.spring.data.escola;

 
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.welligton.spring.data.escola.service.CrudAlunoService;
import br.com.welligton.spring.data.escola.service.CrudProfessorService;
import br.com.welligton.spring.data.escola.service.CrudTurmaService;

@SpringBootApplication
public class SpringDataEscolaApplication implements CommandLineRunner{
	
	private boolean system = true;
	private CrudTurmaService crudTurmaService;
	private CrudAlunoService crudAlunoService;
	private CrudProfessorService crudProfessorService;
	 
	public SpringDataEscolaApplication(CrudTurmaService crudTurmaService,
			CrudAlunoService crudAlunoService,
			CrudProfessorService crudProfessorService) {
		this.crudTurmaService = crudTurmaService;
		this.crudAlunoService = crudAlunoService;
		this.crudProfessorService = crudProfessorService;	
	}
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(SpringDataEscolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 
		Scanner scanner = new Scanner(System.in);
		
		
		while(system) {
			System.out.println("0  - Sair");
			System.out.println("1  - Turma");
			System.out.println("2  - Aluno");
			System.out.println("3  - Professor");
			int acao = scanner.nextInt();
			
				switch (acao) {
				case 1:
					crudTurmaService.inicial(scanner);
					break;
				case 2:
					crudAlunoService.inicial(scanner);
					break;
				case 3:
					crudProfessorService.inicial(scanner);
					break;

				default:
					system = false;
					break;
				}
			
		}
		
		
	}

}
 