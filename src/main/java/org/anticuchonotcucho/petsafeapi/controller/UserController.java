package org.anticuchonotcucho.petsafeapi.controller;

import org.anticuchonotcucho.petsafeapi.config.JwtUtils;
import org.anticuchonotcucho.petsafeapi.config.PasswordUtils;
import org.anticuchonotcucho.petsafeapi.model.entity.UserEntity;
import org.anticuchonotcucho.petsafeapi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder; // Asegúrate de tener este bean configurado

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
    public ResponseEntity<Map<String, Object>> Authorization(@RequestBody Map<String, Object> requestBody) {
        System.out.println("Validación de credenciales");

        String username = (String) requestBody.get("username");
        String password = (String) requestBody.get("password");

        try {
            // Buscar al usuario por nombre de usuario
            Optional<UserEntity> userFound = iUserRepository.findFirstByUsername(username);

            if (userFound.isPresent()) {
                UserEntity user = userFound.get();

                // Comparar la contraseña encriptada
                if (passwordEncoder.matches(password, user.getPassword())) {  // passwordEncoder verifica la contraseña
                    // Contraseña válida, generar el token
                    String token = JwtUtils.generateToken(user.getUsername());
                    // Guardar el token en el usuario
                    user.setToken(token);
                    iUserRepository.save(user);

                    // Crear la respuesta con el token
                    Map<String, Object> response = new HashMap<>();
                    response.put("success", true);
                    response.put("token", token);

                    return ResponseEntity.ok(response);
                } else {
                    // Contraseña incorrecta
                    Map<String, Object> response = new HashMap<>();
                    response.put("success", false);
                    response.put("message", "Invalid password");

                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                }
            } else {
                // Usuario no encontrado
                Map<String, Object> response = new HashMap<>();
                response.put("success", false);
                response.put("message", "User not found");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            e.printStackTrace();

            // En caso de error en el servidor
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Server error");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/details")
    public ResponseEntity<Optional<UserEntity>> getUserDetails(@RequestParam String username){
        System.out.println("obteniendo detalles, " + username);
        Optional<UserEntity> userFound = iUserRepository.findAll().stream().filter(userEntity -> userEntity.getUsername().equals(username)).findFirst();
        return ResponseEntity.ok(userFound);
    }

    // Método para registrar un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> requestBody) {
        System.out.println("Registro de usuario");

        String username = (String) requestBody.get("username");
        String password = (String) requestBody.get("password");
        Integer roleId = (Integer) requestBody.get("roleId");
        String name = (String) requestBody.get("name");
        String lastname = (String) requestBody.get("lastname");
        String email = (String) requestBody.get("email");
        String phone = (String) requestBody.get("phone");

        // Validar campos vacíos o en blanco
        if (isNullOrEmpty(username) || isNullOrEmpty(password) || roleId == null ||
                isNullOrEmpty(name) || isNullOrEmpty(lastname) ||
                isNullOrEmpty(email) || isNullOrEmpty(phone)) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Todos los campos son obligatorios"));
        }

        try {
            // Verificar si el usuario ya existe
            Optional<UserEntity> existingUser = iUserRepository.findAll()
                    .stream()
                    .filter(userEntity -> userEntity.getUsername().equals(username))
                    .findFirst();

            if (existingUser.isPresent()) {
                return ResponseEntity.status(400).body(Collections.singletonMap("message", "El usuario ya existe"));
            }

            // Encriptar la contraseña
            String encryptedPassword = PasswordUtils.encryptPassword(password);

            // Generar un token JWT para el usuario
            String token = JwtUtils.generateToken(username);

            // Crear el nuevo usuario
            UserEntity newUser = new UserEntity();
            newUser.setUsername(username);
            newUser.setPassword(encryptedPassword);
            newUser.setToken(token);
            newUser.setRoleId(roleId);
            newUser.setName(name);
            newUser.setLastname(lastname);
            newUser.setEmail(email);
            newUser.setPhone(phone);

            // Guardar en la base de datos
            iUserRepository.save(newUser);

            return ResponseEntity.ok(Collections.singletonMap("message", "Usuario registrado exitosamente"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.singletonMap("message", "Error al registrar el usuario: " + e.getMessage()));
        }
    }

    // Método para verificar si una cadena es nula o está vacía
    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }



}
