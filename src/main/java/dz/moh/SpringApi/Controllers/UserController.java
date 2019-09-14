package dz.moh.SpringApi.Controllers;

import dz.moh.SpringApi.Entities.Users;
import dz.moh.SpringApi.Exceptions.UserNotFound;
import dz.moh.SpringApi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
     List<Users> getUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> one(@PathVariable Long id) {
Users user = userRepository.findById(id).orElseThrow(()->new UserNotFound(id));
return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public Users newUser(@Valid @RequestBody Users user){
        return userRepository.save(user);
    }
@PutMapping("/users/{id}")
public ResponseEntity<Users> updateUser(
        @PathVariable(value = "id") Long id, @Valid @RequestBody Users userDetails) {
    Users user =
            userRepository
                    .findById(id)
                    .orElseThrow(() -> new UserNotFound(id));
    user.setNom(userDetails.getNom());
    user.setPrenom(userDetails.getPrenom());
    user.setEmail(userDetails.getEmail());
    user.setDate_naissance(userDetails.getDate_naissance());
    user.setPassword(userDetails.getPassword());
    user.setTel(userDetails.getTel());
    final Users updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
}
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id) throws Exception {
        Users user =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new UserNotFound(id));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
