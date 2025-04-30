package med.voll.api.medico;

import med.voll.api.direccion.DatosDireccion;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DatosRegistroMedico(String nombre, String email, String documento, Especialidad especialidad, @JsonProperty("direccion") DatosDireccion datosDireccion) {
}
