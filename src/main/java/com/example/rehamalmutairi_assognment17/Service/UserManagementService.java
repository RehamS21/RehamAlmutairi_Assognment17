package com.example.rehamalmutairi_assognment17.Service;

import com.example.rehamalmutairi_assognment17.Model.User;
import com.example.rehamalmutairi_assognment17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagementService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, User user){
        User oldUser = userRepository.getById(id);
        if (oldUser == null)
            return false;

        // I want these information only updated, other attributes like username, and role not change

        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());

        userRepository.save(oldUser);
        return true;
    }

    public Boolean deleteUser(Integer id){
        User user = userRepository.getById(id);

        if (user == null)
            return false;

        userRepository.delete(user);
        return true;
    }
}
