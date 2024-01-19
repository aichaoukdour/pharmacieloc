package controllers;



import entities.Auth;
import entities.Pharmacie;
import entities.Users;
import services.PharmacieService;
import services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AuthController {

    @Autowired
    private UsersService UsersService;

    @Autowired
    private PharmacieService pharmacieService;

    @PostMapping("/Users/Auth")
    public ResponseEntity authenticateUsers(@RequestBody Auth Auth) {
        // Récupérer l'e-mail de l'utilisateur :
        List<String> UsersEmail = UsersService.checkUsersEmail(Auth.getEmail());

        // Vérifier si l'e-mail est vide :
        if (UsersEmail.isEmpty() || UsersEmail == null) {
            return new ResponseEntity("L'e-mail n'existe pas", HttpStatus.NOT_FOUND);
        }

        // Récupérer le mot de passe hashé de l'utilisateur :
        String hashedPassword = UsersService.checkUsersPasswordByEmail(Auth.getEmail());

        // Valider le mot de passe de l'utilisateur :
        if (!BCrypt.checkpw(Auth.getPassword(), hashedPassword)) {
            return new ResponseEntity("Nom d'utilisateur ou mot de passe incorrect", HttpStatus.BAD_REQUEST);
        }

        // Préparer la réponse avec les détails de l'utilisateur et de la pharmacie associée :
        HashMap<String, Object> responseMap = new HashMap<>();
        Users Users = UsersService.getUsersDetailsByEmail(Auth.getEmail());
        responseMap.put("Users", Users);

        Pharmacie pharmacie = pharmacieService.findPharmacieByUsers(Users);
        if (pharmacie == null) {
            responseMap.put("pharmacie", false);
        } else {
            responseMap.put("pharmacie", true);
            responseMap.put("id", pharmacie.getId());
        }

        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}


