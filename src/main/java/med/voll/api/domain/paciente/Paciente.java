package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import med.voll.api.domain.direccion.Direccion;

import java.util.Objects;


@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private String nombre;
    private String email;
    private String documentoIdentidad;
    private String telefono;

    @Embedded
    private Direccion direccion;

    public Paciente(){ }

    public Paciente(Long id, String nombre, String email, String documentoIdentidad, String telefono, Direccion direccion) {
        this.activo = true;
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Paciente(DatosRegistroPaciente datos){
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefono = datos.telefono();
        this.documentoIdentidad = datos.documentoIdentidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public Boolean getActivo() {
        return activo;
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

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
        if(datosActualizarPaciente.nombre() != null) {
            this.nombre = datosActualizarPaciente.nombre();
        }
        if(datosActualizarPaciente.documentoIdentidad() != null){
            this.documentoIdentidad = datosActualizarPaciente.documentoIdentidad();
        }

        if(datosActualizarPaciente.direccion() != null){
            this.direccion = direccion.actualizarDatos(datosActualizarPaciente.direccion());
        }
    }

    public void desactivarPaciente() {
        this.activo = false;
    }
}
