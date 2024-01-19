package controllers;

import java.util.List;

import entities.Pharmacie;
import entities.PharmacieGarde;
import entities.Users;
import entities.Zone;
import repositories.UsersRepository;
import services.PharmacieService;
import services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pharmacies")
@CrossOrigin()
public class PharmacieController {

    private final PharmacieService service;
    private final UsersRepository userRepository;
    private final UsersService userService;

    @Autowired
    public PharmacieController(PharmacieService service, UsersRepository userRepository, UsersService userService) {
        this.service = service;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/add/{user_id}/{nom}/{zone_id}/{adresse}/{lat}/{lon}/{phagarde}")
    public Pharmacie savePharmacie(@PathVariable int user_id,
                                   @PathVariable String nom,
                                   @PathVariable int zone_id,
                                   @PathVariable String photo,
                                   @PathVariable Double lat,
                                   @PathVariable Double lon,
                                   @PathVariable List<PharmacieGarde> phagarde) {
        Pharmacie p = new Pharmacie();
        Zone z = new Zone();
        z.setId(zone_id);
        p.setNom(nom);
        p.setPhoto(photo);
        p.setLon(lon);
        p.setLat(lat);
        p.setZone(z);
        p.setPhagarde(phagarde);
        Users user = userRepository.findById(user_id).orElseThrow();
        p.setUser(user);
        return service.addPharmacie(p);
    }

    @GetMapping("/all")
    public List<Pharmacie> findAllPharmacies() {
        return service.findAllPharmacie();
    }

    // ... (autres méthodes)

    @DeleteMapping("/deletePharmacie/id={id}")
    public String deletePharmacie(@PathVariable int id) {
        return service.deletePharmacie(id);
    }

    @GetMapping("/pharmacie/garde={id}")
    public List<Pharmacie> findAllPharmaciesByGarde(@PathVariable int id) {
        return service.findAllPharmacieByGarde(id);
    }
}
