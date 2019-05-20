package ru.otus.hw12.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.otus.hw12.model.User;
import ru.otus.hw12.service.UserRepo;

@Service
public class LibraryUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        return new LibraryUserPrincipal(user);
    }
}
