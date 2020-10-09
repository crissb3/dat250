package DAO;

import java.util.List;


public interface Dao<T> {


    List<T> find();

    T find(int id);

    void create(T t);

    void save(T t);

    void update(T t);

    void delete(int id);



}