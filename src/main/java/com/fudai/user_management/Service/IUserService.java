package com.fudai.user_management.Service;

import com.fudai.user_management.POJO.DTO.UserDto;
import com.fudai.user_management.POJO.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * interface defining what operations your service can do
 */
@Service // spring bean
public interface IUserService {
    /**
     * Add user.
     * @param user
     * */
    User createUser(UserDto user);
    List<User> getAllUsers(); // new method
    User getUserById(Integer id);
    User updUser(Integer id, UserDto user);

    User patchUser(Integer id, UserDto userDto);

    void deleteUser(Integer id);
}
