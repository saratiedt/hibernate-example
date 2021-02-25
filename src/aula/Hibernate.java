package aula;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hibernate {
	private SessionFactory sessionFactory = null;

	public SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			System.out.println("1");
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setNome("Maria");
		aluno.setSala(5);

		Hibernate hibernate = new Hibernate();

		Session session = hibernate.getSessionFactory().openSession();

		
	//salvar
//		session.save(aluno);
//		session.getTransaction().commit();
//		session.close();
//		
//		session.beginTransaction();
		
		// buscar todos

//		List result = session.createQuery("from Aluno").list();
//		for (Aluno dados : (List<Aluno>) result) {
//			System.out.println("Nome:" + dados.getNome());
//			System.out.println("Sala:" + dados.getSala());
//
//		}
//
//		session.getTransaction().commit();
//		session.close();
		
		// buscar por id
		session.beginTransaction();
		Aluno aluno2 = session.get(Aluno.class, 2);
		
//		System.out.println(aluno2.getCodigo());
//		System.out.println("Nome:" + aluno2.getNome());
//		System.out.println("Sala:" + aluno2.getSala());
		
		// update
//		aluno2.setNome("João");
//		aluno2.setSala(3);
		//session.update(aluno2);
		
		// remover
		session.remove(aluno2);
		
		session.getTransaction().commit();
		session.close();
		

	}
}
