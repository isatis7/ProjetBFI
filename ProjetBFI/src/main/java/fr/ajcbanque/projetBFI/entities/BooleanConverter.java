package fr.ajcbanque.projetBFI.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean value) {
	return Boolean.TRUE.equals(value) ? "T" : "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
	return "T".equals(value);
    }
}
