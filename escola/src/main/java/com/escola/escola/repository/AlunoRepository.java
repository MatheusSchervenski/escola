package com.escola.escola.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.escola.escola.alunos.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
		

	List<Aluno> findByNome(String nome);
	


}
