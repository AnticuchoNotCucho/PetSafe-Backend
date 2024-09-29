package org.anticuchonotcucho.petsafeapi.controller;

import org.anticuchonotcucho.petsafeapi.model.entity.UserEntity;
import org.anticuchonotcucho.petsafeapi.repository.IUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/user")
public class UserController {

    private final IUserRepository iUserRepository;

    public UserController(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        System.out.println("Users");
        List<UserEntity> users = iUserRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Boolean> Authorization(@RequestBody Map<String, Object> requestBody) {
        System.out.println("validacion");

        String username = (String) requestBody.get("username");
        String password = (String) requestBody.get("password");

        try {
            Optional<UserEntity> userFound = iUserRepository.findAll()
                    .stream()
                    .filter(userEntity -> userEntity.getUsername().equals(username) && userEntity.getPassword().equals(password))
                    .findFirst();

            return ResponseEntity.ok(userFound.isPresent());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(false);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<Optional<UserEntity>> getUserDetails(@RequestParam String username){
        System.out.println("obteniendo detalles, " + username);
        Optional<UserEntity> userFound = iUserRepository.findAll().stream().filter(userEntity -> userEntity.getUsername().equals(username)).findFirst();
        return ResponseEntity.ok(userFound);
    }

}
