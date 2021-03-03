package aula;

import java.util.List;


public interface AlunoDAO {
	public void salvar(Aluno aluno);
	
	public Aluno findByID(int id);
	
	public List<Aluno> listar();

	public void remover(Aluno aluno);

	public void atualizar(Aluno aluno);
}
