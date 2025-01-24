package DAO;

import entities.Familia;

import java.util.List;

public interface FamiliaDAO {
    void save(Familia familia);
    Familia getById(Long id);
    List<Familia> getAll();
    void update(Familia familia);
    void delete(Familia familia);
}
