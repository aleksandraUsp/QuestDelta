package ua.com.javarush.quest.uspenskaya.questdelta.repository;

import ua.com.javarush.quest.uspenskaya.questdelta.entities.User;
import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {

    Collection<User> getAll();

    Optional<T> get(long id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
