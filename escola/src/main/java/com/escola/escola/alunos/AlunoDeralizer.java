package com.escola.escola.alunos;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class AlunoDeralizer extends JsonDeserializer<Aluno> {
	public AlunoDeralizer() { 
        this(null); 
    } 

    public AlunoDeralizer(Class<AlunoDeralizer> vc) { 
        super(); 
    }
	@Override
	public Aluno deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		JsonNode node = p.getCodec().readTree(p);
		Aluno aluno = new Aluno();
		aluno.setId(node.asText());
		return aluno;
	}

}
