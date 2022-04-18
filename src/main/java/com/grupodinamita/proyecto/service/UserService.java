package com.grupodinamita.proyecto.service;

import com.grupodinamita.proyecto.entity.User;

import java.util.Optional;

public interface UserService {

    public Optional<User> findById(Long id);

    void deleteById(Long id);

    public User save(User user);

    public Iterable<User> findAll();

    public Optional<User> findByEmail(String email);


}
