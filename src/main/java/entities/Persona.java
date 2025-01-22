package entities;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "personita")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private float salario;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String email, float salario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;}

    public String setNombre(String nombre) {
        return this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                '}';
    }
}