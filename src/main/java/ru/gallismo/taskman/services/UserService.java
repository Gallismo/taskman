package ru.gallismo.taskman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gallismo.taskman.models.User;
import ru.gallismo.taskman.repositories.UserRepository;
import ru.gallismo.taskman.security.UserDetailsImpl;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(username);

        if (user.isEmpty())
            throw new UsernameNotFoundException("Пользователь не найден!");

        return new UserDetailsImpl(user.get());
    }
}