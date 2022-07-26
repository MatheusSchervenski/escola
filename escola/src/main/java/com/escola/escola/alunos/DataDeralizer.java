package com.escola.escola.alunos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class DataDeralizer extends JsonDeserializer<Date> {
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		JsonNode node = p.getCodec().readTree(p);
		try {
			formatter.setTimeZone(TimeZone.getTimeZone("BR"));
		
			return formatter.parse(node.asText());
		} catch (ParseException e) {
			throw new RuntimeException("Deu erro ao fazer parse da data");
		}
		
	}
}
