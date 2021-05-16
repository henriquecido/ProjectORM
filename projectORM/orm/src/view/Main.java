package view;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Curso;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
	    org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
	    java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING); 
	    java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Scanner teclado = new Scanner(System.in);
		
		// Entity Maneger = Gerenciar as entidades que eu tenho = create, update..
		
		
		//Criador de Gerenciador de Entidades  |  Criando meu Criador e defenindo qual o banco ele mais manipular minha entidades
		//Basicamente apontando e definindo para o meu EntituManagerFactory qual banco vamos mapipular
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm");
		
		//Criando meu Gerenciado de Entidade
		EntityManager em = emf.createEntityManager();
		int x=0;
		do{
			System.out.println("\n-  Projeto ORM  -  ");
			System.out.println("1- Criar Curso");
			System.out.println("2- Exibir Curso");
			System.out.println("3- Exibir Todos Cursos");
			System.out.println("4- Alterar Curso");
			System.out.println("5- Deletar Curso");
			System.out.println("0- Sair");
			System.out.println("-- -- -- -- -- -- ");
			System.out.print(" Opcao:  ");
			int op = teclado.nextInt();
			
			switch(op) {
				case 1:
					//Evitar salto de linha
					teclado.nextLine();
					System.out.println("\nNome:   ");
					String nome = teclado.nextLine();
					System.out.println("Ementa:   ");
					String ementa = teclado.nextLine();
					System.out.println("Carga Horaria:   ");
					String ch = teclado.nextLine();
					System.out.println("Categoria:   ");
					String categoria = teclado.nextLine();
					System.out.println("\n");
					//Criando um Curso
					Curso newCurso = new Curso(nome,ementa,ch,categoria);
					em.getTransaction().begin();
					em.persist(newCurso);
					em.getTransaction().commit();
					System.out.println("     \n O ID do Curso Criado é "+newCurso.getIdCurso()+"\n");
					System.out.println("     \n Cadastro Realizado com Sucesso! \n");
					
					break;
				case 2:
					
					System.out.println("\nQual o ID:   ");
					int id = teclado.nextInt();
					em.getTransaction().begin();
					Curso viewCurso = em.find(Curso.class, id);
					em.getTransaction().commit();
					System.out.println("\n\n - Curso "+id+" - ");
					System.out.println("Nome: "+viewCurso.getNome());
					System.out.println("Ementa: "+viewCurso.getEmenta());
					System.out.println("Categoria: "+viewCurso.getCategoria());
					System.out.println("Carga Horaria: "+viewCurso.getCargaHoraria());
					System.out.println("\n");
					
					break;
				case 3:
					// Java Persistence Query Language | uma linguagem de consulta orientada a objetos
					String jpql = " SELECT u FROM Curso u";
					em.getTransaction().begin();
					List<Curso> viewCursos = em.createQuery(jpql, Curso.class).getResultList();
					em.getTransaction().commit();
					for(Curso cursos: viewCursos) {
						System.out.println("\n - Curso "+cursos.getIdCurso()+" - ");
						System.out.println("Nome: "+cursos.getNome());
						System.out.println("Ementa: "+cursos.getEmenta());
						System.out.println("Categoria: "+cursos.getCategoria());
						System.out.println("Carga Horaria: "+cursos.getCargaHoraria());
						System.out.println("\n");
					}
					
					break;
					
				case 4:
						int xx=0;
						do {
							System.out.println("\nQual o ID:   ");
							int ids = teclado.nextInt();
							teclado.nextLine();
							
							System.out.println("\n\n-  Alterar  -  ");
							System.out.println("1- Nome");
							System.out.println("2- Ementa");
							System.out.println("3- Categoria");
							System.out.println("4- Carga Horaria");
							System.out.println("5- Sair");
							System.out.println("-- -- -- -- -- -- ");
							System.out.print(" Opcao:  ");
							int ops = teclado.nextInt();
							Curso updateCurso;
							switch(ops) {
								case 1:
									updateCurso = em.find(Curso.class,ids);
									teclado.nextLine();
									System.out.println("\nNome:   ");
									nome = teclado.nextLine();
									
									updateCurso.setNome(nome);
									em.getTransaction().begin();
									em.merge(updateCurso);
									em.getTransaction().commit();
									System.out.println("\n Alterado com Sucesso ! \n ");
									xx=1;
									break;
								case 2:
									updateCurso = em.find(Curso.class,ids);
									teclado.nextLine();
									System.out.println("Ementa:   ");
									ementa = teclado.nextLine();
									
									updateCurso.setEmenta(ementa);
									em.getTransaction().begin();
									em.merge(updateCurso);
									em.getTransaction().commit();
									System.out.println("\n Alterado com Sucesso ! \n ");
									xx=1;
									break;
								case 3:
									updateCurso = em.find(Curso.class,ids);
									teclado.nextLine();
									System.out.println("Categoria:   ");
									categoria = teclado.nextLine();
									
									updateCurso.setCategoria(categoria);
									em.getTransaction().begin();
									em.merge(updateCurso);
									em.getTransaction().commit();
									System.out.println("\n Alterado com Sucesso ! \n ");
									xx=1;
									break;
								case 4:
									updateCurso = em.find(Curso.class,ids);
									teclado.nextLine();
									System.out.println("Carga Horaria:   ");
									ch = teclado.nextLine();
									
									updateCurso.setCategoria(ch);
									em.getTransaction().begin();
									em.merge(updateCurso);
									em.getTransaction().commit();
									System.out.println("\n Alterado com Sucesso ! \n ");
									xx=1;
									break;
								case 5:
									xx=1;
									break;
								default:
									System.out.println("    Entrada Invalida ! ");
							}
	
						}while(xx!=1);
					
					break;
				case 5:
					System.out.println("\nQual o ID:   ");
					int ids = teclado.nextInt();
					teclado.nextLine();
					
					Curso deleteCurso = em.find(Curso.class,ids);
					if(deleteCurso != null) {
						em.getTransaction().begin();
						em.remove(deleteCurso);
						em.getTransaction().commit();
					}
					System.out.println("\n Deletado com Sucesso ! \n ");
					break;
				case 0:
					em.close();
					emf.close();
					x=1;
					break;
				default:
					System.out.println("    Entrada Invalida ! ");
			}
			
			
			
		}while(x!=1);
		
	}

}
