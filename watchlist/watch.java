package com.finpulse.controller;

import com.finpulse.model.User;
import com.finpulse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}/watchlist")
    public List<String> getWatchlist(@PathVariable Long id) {
        return userService.getWatchlist(id);
    }

    @PutMapping("/{id}/watchlist")
    public User updateWatchlist(@PathVariable Long id, @RequestBody List<String> watchlist) {
        return userService.updateWatchlist(id, watchlist);
    }
}
