package com.escola.escola.alunos;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class AlunosSeralizer extends JsonSerializer<Aluno> {

	@Override
	public void serialize(Aluno value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getId());
	
		
	}

	
	
}
