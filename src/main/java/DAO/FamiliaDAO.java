package DAO;

import entities.Familia;
import java.util.List;

/**
 * Interfaz que define los métodos CRUD para la entidad Familia.
 */
public interface FamiliaDAO {

    /**
     * Guarda un objeto Familia en la base de datos.
     *
     * @param familia El objeto Familia a guardar.
     */
    void save(Familia familia);

    /**
     * Obtiene un objeto Familia por su ID.
     *
     * @param id El ID de la Familia a buscar.
     * @return El objeto Familia correspondiente al ID, o null si no se encuentra.
     */
    Familia getById(Long id);

    /**
     * Obtiene una lista de todas las familias en la base de datos.
     *
     * @return Una lista de objetos Familia almacenados en la base de datos.
     */
    List<Familia> getAll();

    /**
     * Actualiza un objeto Familia en la base de datos.
     *
     * @param familia El objeto Familia con los nuevos valores.
     */
    void update(Familia familia);

    /**
     * Elimina un objeto Familia de la base de datos.
     *
     * @param familia El objeto Familia a eliminar.
     */
    void delete(Familia familia);
}
