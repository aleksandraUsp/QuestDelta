package ua.com.javarush.quest.uspenskaya.questdelta.service;

import ua.com.javarush.quest.uspenskaya.questdelta.entities.User;
import ua.com.javarush.quest.uspenskaya.questdelta.repository.Repository;
import ua.com.javarush.quest.uspenskaya.questdelta.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

public enum UserService {

    USER_SERVICE;

    private final Repository<User> userRepository = new UserRepository();

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> get(long id) {
        return userRepository.get(id);
    }
}
