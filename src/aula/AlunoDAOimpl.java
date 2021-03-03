package aula;

import java.util.List;

import org.hibernate.Session;

public class AlunoDAOimpl implements AlunoDAO {

	Hibernate hibernate = new Hibernate();

	Session session = hibernate.getSessionFactory().openSession();

	@Override
	public void salvar(Aluno aluno) {
		session.beginTransaction();
		session.save(aluno);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<Aluno> listar() {
		session.beginTransaction();
		List result = session.createQuery("from Aluno").list();
		for (Aluno dados : (List<Aluno>) result) {
			System.out.println("Nome:" + dados.getNome());
			System.out.println("Sala:" + dados.getSala());

		}

		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public void remover(Aluno aluno) {
		session.beginTransaction();
		Aluno alunoAtualizado = session.get(Aluno.class, aluno.getCodigo());
		session.remove(alunoAtualizado);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void atualizar(Aluno aluno) {
		session.beginTransaction();
		Aluno alunoAtualizado = session.get(Aluno.class, aluno.getCodigo());

		alunoAtualizado.setNome(aluno.getNome());
		alunoAtualizado.setSala(aluno.getSala());
		session.update(alunoAtualizado);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Aluno findByID(int id) {
		Aluno aluno = session.get(Aluno.class, id);
		return aluno;
	}

}
