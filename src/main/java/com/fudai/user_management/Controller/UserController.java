package com.fudai.user_management.Controller;

import com.fudai.user_management.POJO.DTO.UserDto;
import com.fudai.user_management.POJO.ResponseMessage;
import com.fudai.user_management.POJO.User;
import com.fudai.user_management.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Indicates that this class is a REST controller.
// Spring will treat it as a controller where every method returns a response body (usually JSON).
@RestController

// Maps HTTP requests to this controller.
// All request URLs for methods in this class will start with "/users" (you can change this path as needed).
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

//    {"username":"Allie",
//            "email":"aw@gamil.com",
//            "password":"helloword"}
    // add
    @PostMapping("/users") // method POST
    public ResponseMessage<User> createUser(@Validated @RequestBody UserDto user){
        User createdUser = userService.createUser(user);
        return ResponseMessage.success(createdUser);
    }


    // query
    @GetMapping("/users")
    public ResponseMessage<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseMessage.success(users);
    }

    @GetMapping("/users/{user_id}")
    public ResponseMessage<User> getUserById(@PathVariable Integer user_id) {
        User queriedUser = userService.getUserById(user_id);
        return ResponseMessage.success(queriedUser);

    }

    // update
    @PutMapping("/users/{id}")
    public ResponseMessage<User> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        User updatedUser = userService.updUser(id, userDto);
        return ResponseMessage.success(updatedUser);
    }

    @PatchMapping("/users/{id}")
    public ResponseMessage<User> patchUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        User updatedUser = userService.patchUser(id, userDto);
        return ResponseMessage.success(updatedUser);
    }


    // delete
    @DeleteMapping("/users/{id}")
    public ResponseMessage<String> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseMessage<>(200, "User deleted successfully", null);
    }

}
