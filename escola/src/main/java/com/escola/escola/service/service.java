package com.escola.escola.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.escola.escola.alunos.Aluno;

public interface service {

	
	public List<Aluno> obtertudo();
	public Aluno obter(String id);
	public Aluno criar(Aluno aluno);
	public Aluno alterar(Aluno aluno);
	public void deletar(Aluno aluno);
	
}
