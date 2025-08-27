package com.fudai.user_management.Service;

import com.fudai.user_management.DAO.UserDAO;
import com.fudai.user_management.POJO.DTO.UserDto;
import com.fudai.user_management.POJO.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * actual implementation of those operations
 * often calling DAO methods.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public User createUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user); // copy fields
        return userDAO.save(user); // save returns the persisted entity
    }

    @Override
    public User getUserById(Integer id) {
        return userDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));
    }

    @Override
    public User updUser(Integer id, UserDto userDto) {
        User existingUser = userDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));

        existingUser.setUsername(userDto.getUsername());
        existingUser.setPassword(userDto.getPassword());
        existingUser.setEmail(userDto.getEmail());

        return userDAO.save(existingUser);
    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userDAO.findAll().forEach(users::add); // fetch all users
        return users;
    }

    @Override
    public User patchUser(Integer id, UserDto userDto) {
        // Find existing user
        User existingUser = userDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));

        // Update only non-null fields from DTO
        if (userDto.getUsername() != null) existingUser.setUsername(userDto.getUsername());
        if (userDto.getPassword() != null) existingUser.setPassword(userDto.getPassword());
        if (userDto.getEmail() != null) existingUser.setEmail(userDto.getEmail());

        // Save changes
        return userDAO.save(existingUser);
    }


    @Override
    public void deleteUser(Integer id) {
        // Check if user exists first
        User existingUser = userDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist"));

        // Delete the user
        userDAO.delete(existingUser);
    }


}
