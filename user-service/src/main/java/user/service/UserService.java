package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getUser(Long id) {
        Optional<Users> user = userRepository.findById(id);
        return user.map(u -> "User: " + u.getName()).orElse("User not found");
    }
}