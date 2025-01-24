package entities;

import jakarta.persistence.*;

/**
 * Clase animal
 */
@Entity
@Table(name = "animales")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(nullable = false)
    private String estado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "familia_id")
    private Familia familia;

    /**
     * @return el id único del animal.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id el id del animal.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el nombre del animal.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param  nombre del animal.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return la especie del animal.
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie la especie del animal.
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return la edad del animal.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad la edad del animal.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return la descripción del animal.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion la descripción del animal.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return el estado actual del animal.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado el estado actual del animal.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return la familia asociada al animal.
     */
    public Familia getFamilia() {
        return familia;
    }

    /**
     * @param familia la familia asociada al animal.
     */
    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", familia=" + (familia != null ? familia.getNombre() : "N/A") +
                '}';
    }
}
