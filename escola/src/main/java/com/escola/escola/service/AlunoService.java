package com.escola.escola.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.escola.alunos.Aluno;
import com.escola.escola.repository.AlunoRepository;
@Service
public class AlunoService implements service{

	@Autowired
	private AlunoRepository alunoRepository;
	@Override
	public List<Aluno> obtertudo(){
		return this.alunoRepository.findAll();
	}
	@Override
	public Aluno obter(String id) {
	
		return this.alunoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Funcionario nao exite"));
	}
	@Override
	public Aluno criar(Aluno aluno) {
		return this.alunoRepository.save(aluno);
	}
	@Override
	public Aluno alterar(Aluno aluno) {
		return this.alunoRepository.save(aluno);
	}
	@Override
	public void deletar(Aluno aluno) {
		 this.alunoRepository.delete(aluno);
	}

	
	
	
	
}

	
	

