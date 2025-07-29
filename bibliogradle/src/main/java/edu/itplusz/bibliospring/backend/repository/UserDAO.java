package edu.itplusz.bibliospring.backend.repository;

import edu.itplusz.bibliospring.backend.model.User;

import java.util.List;

// Adat hozza feresi komponsensek fuggetlenek kell legyenek
// egy dao, egy komponsnesert lesz felelos

public interface UserDAO extends BaseDAO<User,Long>{
    User findByUsername(String username);
}
