package works.hop.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import works.hop.user.model.User;
import works.hop.user.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8091")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(userRepository.allUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> byId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(userRepository.byId(id));
    }
}
