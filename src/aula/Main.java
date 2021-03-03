package aula;

import java.util.List;



public class Main {

	public static void main(String[] args) {
		AlunoDAO banco = new AlunoDAOimpl();

		List<Aluno> lista = banco.listar();
//
//		Aluno aluno1 = new Aluno();
//		aluno1.setNome("Sara");
//		aluno1.setSala(5);
//		banco.salvar(aluno1);
//		
//		Aluno alunoAtualizado = banco.findByID(6);
//		
//		alunoAtualizado.setCodigo(3);
//		alunoAtualizado.setNome("Sara");
//		alunoAtualizado.setSala(1);
//	
		//banco.atualizar(alunoAtualizado);
		
	//	banco.remover(alunoAtualizado);

	}

}
