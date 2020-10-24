package model;

public enum EstadoSala{
    PENDIENTE,
    DISPONIBLE,
    FINALIZADA;

    public String toDbValue() {
        return this.name().toLowerCase();
    }

    public static EstadoSala from(String estadoSala) {
        // Note: error if null, error if not "ACTIVE" nor "INACTIVE"
        return EstadoSala.valueOf(estadoSala.toUpperCase());
    }
}