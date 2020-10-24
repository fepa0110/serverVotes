package model;

import model.EstadoSala;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EstadoSalaConverter implements AttributeConverter<EstadoSala, String> {
    @Override
    public String convertToDatabaseColumn(EstadoSala estado) {
        return estado.toDbValue();
    }

    @Override
    public EstadoSala convertToEntityAttribute(String dbData) {
        return EstadoSala.from(dbData);
    }
}