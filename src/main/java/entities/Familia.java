package entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * Clase  familia
 */
@Entity
@Table(name = "familias")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private String ciudad;

    @OneToMany(mappedBy = "familia")
    private List<Animal> animales;

    /**
     * @return el id único de la familia.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id el identificador único de la familia.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el nombre de la familia.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre el nombre de la familia.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return la edad de la familia.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad la edad de la familia.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return la ciudad donde reside la familia.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad la ciudad donde reside la familia.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return la lista de animales pertenecientes a la familia.
     */
    public List<Animal> getAnimales() {
        return animales;
    }

    /**
     * @param animales la lista de animales pertenecientes a la familia.
     */
    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }
    @Override
    public String toString() {
        return "Familia{id=" + id + ", nombre='" + nombre + "'}";
    }
}
