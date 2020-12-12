package dev.boiarshinov.tankbattle.service;

import java.util.List;

public interface FieldService {
    Field findById(Integer id);
    List<Field> findAll();
}
