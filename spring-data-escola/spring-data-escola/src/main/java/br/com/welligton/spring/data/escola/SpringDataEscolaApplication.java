package br.com.welligton.spring.data.escola;

<<<<<<< HEAD
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.welligton.spring.data.escola.service.CrudAlunoService;
import br.com.welligton.spring.data.escola.service.CrudTurmaService;

@SpringBootApplication
public class SpringDataEscolaApplication implements  CommandLineRunner{
	
	private boolean system = true;
	private CrudTurmaService crudTurmaService;
	private CrudAlunoService crudAlunoService;
	 
	public SpringDataEscolaApplication(CrudTurmaService crudTurmaService,
			CrudAlunoService crudAlunoService) {
		this.crudTurmaService = crudTurmaService;
		this.crudAlunoService = crudAlunoService;
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
			int acao = scanner.nextInt();
			
				switch (acao) {
				case 1:
					crudTurmaService.inicial(scanner);
					break;
				case 2:
					crudAlunoService.inicial(scanner);
					break;

				default:
					system = false;
					break;
				}
			
		}
		
		
	}

}
/*
fiz o mapeamento ida e volta da entidade aluno e turma e fiz alguma funcionalidades básica
como cadastrar aluno vinculada com sua turma 
cadastrar turma!
 
*/
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataEscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataEscolaApplication.class, args);
	}

}
>>>>>>> branch 'main' of https://github.com/developerWelligton/Spring_data_ORM_escola.git
