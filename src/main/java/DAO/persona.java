package DAO;
import entities.Persona;

import java.util.List;

public interface persona {

    /**
     *
     * @return todas las personas
     */

    List<Persona> findAll();

    //@return devuelve un empleado por un id concreto
    Persona findById(int id);

    //@return devuelve mas de un  empleado por un name concreto
    List<Persona> findByName(String name);


    //inserta un nuevo registro
    Persona create(Persona persona);



    //actualiza un registro
    Persona update(Persona persona);

    /**
     *
     * @param id
     */

    boolean delete(int id);
}
