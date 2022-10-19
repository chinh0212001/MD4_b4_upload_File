package rikkei.academy.service;

import rikkei.academy.model.Meo;

import java.util.List;

public interface IMeoService {
    List<Meo> findAll();
    void save(Meo meo);
}
