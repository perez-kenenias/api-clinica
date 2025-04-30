package med.voll.api.paciente;

import med.voll.api.direccion.DatosDireccion;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DatosRegistroPaciente(String nombre, String email, String documentoIdentidad, @JsonProperty("direccion") DatosDireccion direccion) {
}
