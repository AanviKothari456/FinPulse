package com.finpulse.service;

import com.finpulse.model.User;
import com.finpulse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<String> getWatchlist(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(User::getWatchlist).orElse(List.of());
    }

    public User updateWatchlist(Long id, List<String> watchlist) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setWatchlist(watchlist);
            return userRepository.save(user);
        }
        return null;
    }
}