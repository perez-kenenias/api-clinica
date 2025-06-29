package med.voll.api.domain.direccion;

import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {

    private String calle;
    private String numero;
    private String complemento;
    private String distrito;
    private String ciudad;

    public Direccion() {
    }

    public Direccion(String calle, String numero, String complemento, String distrito, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.complemento = complemento;
        this.distrito = distrito;
        this.ciudad = ciudad;
    }

    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.numero = datosDireccion.numero();
        this. complemento = datosDireccion.complemento();
        this.distrito = datosDireccion.distrito();
        this.ciudad = datosDireccion.ciudad();
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Direccion actualizarDatos(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.distrito = direccion.distrito();
        this.complemento = direccion.complemento();
        this.ciudad = direccion.ciudad();
        return this;
    }
}
