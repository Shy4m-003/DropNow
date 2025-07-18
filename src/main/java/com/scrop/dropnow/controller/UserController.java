package com.scrop.dropnow.controller;

import com.scrop.dropnow.model.UserDTO;
import com.scrop.dropnow.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/DropNow/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Operation(summary = "UserRegistration", description = "Post user details register them into the application")
    @PostMapping(path = "/register", consumes = {"application/json"} , produces = {"application/json"})
    public ResponseEntity<UserDTO> register( @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "User data containing name, email, and password",
            required = true,
            content = @Content(schema = @Schema(implementation = UserDTO.class))
    ) @Valid @RequestBody UserDTO userDTO){
        userDTO = userService.register(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDto){
        userDto = userService.login(userDto.getEmailId(),userDto.getPassword());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/profile/{userName}")
    public ResponseEntity<UserDTO> getInfoByUserName(@PathVariable String userName){
        UserDTO userDTO = userService.getInfoByUserName(userName);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
