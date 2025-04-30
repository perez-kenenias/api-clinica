package api.paciente;

import api.direccion.DatosDireccion;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DatosRegistroPaciente(String nombre, String email, String documentoIdentidad, @JsonProperty("direccion") DatosDireccion direccion) {
}
