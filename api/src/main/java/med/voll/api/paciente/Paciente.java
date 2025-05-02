package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

import java.util.Objects;


@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documentoIdentidad;
    private String telefono;

    @Embedded
    private Direccion direccion;

    public Paciente(){ }

    public Paciente(Long id, String nombre, String email, String documentoIdentidad, String telefono, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Paciente(DatosRegistroPaciente datos){
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documentoIdentidad = datos.documentoIdentidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id) && Objects.equals(nombre, paciente.nombre) && Objects.equals(email, paciente.email) && Objects.equals(documentoIdentidad, paciente.documentoIdentidad) && Objects.equals(telefono, paciente.telefono) && Objects.equals(direccion, paciente.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, documentoIdentidad, telefono, direccion);
    }
}
