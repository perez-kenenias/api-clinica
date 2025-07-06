package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DatosDireccion;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DatosRegistroPaciente(
        @NotBlank
        Long id,
        Boolean activo,
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String telefono,
        @NotBlank
        String documentoIdentidad,
        @NotNull
        @Valid
        @JsonProperty("direccion")
        DatosDireccion direccion) {
}
