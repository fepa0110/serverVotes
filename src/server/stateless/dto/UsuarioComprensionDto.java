package stateless.dto;

public class UsuarioComprensionDto{
    private String desdeNombre;
    private String hastaNombre;
    private String desdeApellido; 
    private String hastaApellido;


    public UsuarioComprensionDto() {
    }

    public UsuarioComprensionDto(String desdeNombre, String hastaNombre, String desdeApellido, String hastaApellido) {
        this.desdeNombre = desdeNombre;
        this.hastaNombre = hastaNombre;
        this.desdeApellido = desdeApellido;
        this.hastaApellido = hastaApellido;
    }

    public String getDesdeNombre() {
        return this.desdeNombre;
    }

    public void setDesdeNombre(String desdeNombre) {
        this.desdeNombre = desdeNombre;
    }

    public String getHastaNombre() {
        return this.hastaNombre;
    }

    public void setHastaNombre(String hastaNombre) {
        this.hastaNombre = hastaNombre;
    }

    public String getDesdeApellido() {
        return this.desdeApellido;
    }

    public void setDesdeApellido(String desdeApellido) {
        this.desdeApellido = desdeApellido;
    }

    public String getHastaApellido() {
        return this.hastaApellido;
    }

    public void setHastaApellido(String hastaApellido) {
        this.hastaApellido = hastaApellido;
    }

    @Override
    public String toString() {
        return "{" +
            " desdeNombre='" + getDesdeNombre() + "'" +
            ", hastaNombre='" + getHastaNombre() + "'" +
            ", desdeApellido='" + getDesdeApellido() + "'" +
            ", hastaApellido='" + getHastaApellido() + "'" +
            "}";
    }
}