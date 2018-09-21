package ru.xpendence.generics.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.xpendence.generics.base.ErrorType;
import ru.xpendence.generics.domain.User;
import ru.xpendence.generics.exception.SampleException;
import ru.xpendence.generics.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 19.09.2018
 * Time: 09:05
 * e-mail: 2262288@gmail.com
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return Lists.newArrayList(userRepository.saveAll(users));
    }

    @Override
    public Optional<User> update(User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public Boolean deleteById(Long id) {
        User user = get(id)
                .orElseThrow(() -> new SampleException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        userRepository.delete(user);
        return !userRepository.findById(user.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        userRepository.deleteAll();
        return Lists.newArrayList(userRepository.findAll()).isEmpty();
    }
}
