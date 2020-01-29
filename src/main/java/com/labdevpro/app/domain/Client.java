package com.labdevpro.app.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Client.
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Size(min = 10, max = 10)
    @Column(name = "cedula", length = 10)
    private String cedula;

    @Size(min = 10, max = 10)
    @Column(name = "telefono", length = 10)
    private String telefono;

    @Size(min = 10, max = 10)
    @Column(name = "celular", length = 10)
    private String celular;

    @NotNull
    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "fecha_de_ingreso", nullable = false)
    private Instant fechaDeIngreso;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Client nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Client apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public Client direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public Client cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public Client telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public Client celular(String celular) {
        this.celular = celular;
        return this;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public Client sexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public Client email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public Client fechaDeIngreso(Instant fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
        return this;
    }

    public void setFechaDeIngreso(Instant fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        return id != null && id.equals(((Client) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Client{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", cedula='" + getCedula() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", celular='" + getCelular() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", email='" + getEmail() + "'" +
            ", fechaDeIngreso='" + getFechaDeIngreso() + "'" +
            "}";
    }
}
