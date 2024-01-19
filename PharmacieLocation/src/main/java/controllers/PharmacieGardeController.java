package controllers;



import entities.Pharmacie;
import entities.PharmacieGarde;
import entities.Users;
import repositories.UsersRepository;
import services.PharmacieGardeService;
import services.PharmacieService;
import services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pharmaciesDeGarde")
@CrossOrigin()
public class PharmacieGardeController {

    @Autowired
    private PharmacieGardeService service;

    @Autowired
    private PharmacieService pharmacieService;

    @Autowired
    private UsersRepository UsersssRepository;

    @Autowired
    private UsersService UsersssService;

    @PostMapping("/add/{debut}/{fin}")
    public PharmacieGarde save(@RequestBody PharmacieGarde PharmacieGarde,
                                @PathVariable String debut,
                                @PathVariable String fin) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date utilDate1 = sdf.parse(debut);
        java.util.Date utilDate2 = sdf.parse(fin);

        long millis1 = utilDate1.getTime();
        long millis2 = utilDate2.getTime();

        java.sql.Date debutSql = new java.sql.Date(millis1);
        java.sql.Date finSql = new java.sql.Date(millis2);

        ((entities.PharmacieGarde) PharmacieGarde.getPharmacieGarde()).setDate_debut(debutSql);
        PharmacieGarde.setDate_fin(finSql);

        return service.addPharmacieGarde(PharmacieGarde);
    }

    @GetMapping("/all")
    public List<PharmacieGarde> getAllPharmaciesDeGarde() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PharmacieGarde> PharmacieGardes = new ArrayList<>();

        for (PharmacieGarde PharmacieGarde : service.getAllPharmaciesDeGarde()) {
            java.util.Date utilDate1 = sdf.parse(String.valueOf(((entities.PharmacieGarde) PharmacieGarde.getPharmacieGarde()).getDate_debut()));
            java.util.Date utilDate2 = sdf.parse(String.valueOf(PharmacieGarde.getDate_debut()));

            long millis1 = utilDate1.getTime();
            long millis2 = utilDate2.getTime();

            java.sql.Date debutSql = new java.sql.Date(millis1);
            java.sql.Date finSql = new java.sql.Date(millis2);

            ((entities.PharmacieGarde) PharmacieGarde.getPharmacieGarde()).setDate_debut(debutSql);
            PharmacieGarde.setDate_fin(finSql);

            PharmacieGardes.add(PharmacieGarde);
        }
        return PharmacieGardes;
    }

    @GetMapping("/allDispo")
    public List<PharmacieGarde> getAllPharmaciesDeGardeDispo() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PharmacieGarde> PharmacieGardes = new ArrayList<>();

        for (PharmacieGarde PharmacieGarde : service.getAllPharmaciesDeGardeDispo()) {
            java.util.Date utilDate1 = sdf.parse(String.valueOf(((entities.PharmacieGarde) PharmacieGarde.getPharmacieGarde()).getDate_debut()));
            java.util.Date utilDate2 = sdf.parse(String.valueOf(PharmacieGarde.getDate_fin()));

            long millis1 = utilDate1.getTime();
            long millis2 = utilDate2.getTime();

            java.sql.Date debutSql = new java.sql.Date(millis1);
            java.sql.Date finSql = new java.sql.Date(millis2);

            ((entities.PharmacieGarde) PharmacieGarde.getPharmacieGarde()).setDate_debut(debutSql);
            PharmacieGarde.setDate_fin(finSql);

            PharmacieGardes.add(PharmacieGarde);
        }
        return PharmacieGardes;
    }

    @GetMapping("/allEnGarde")
    public List<PharmacieGarde> getAllPharmaciesDeGardeEnGarde() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PharmacieGarde> PharmacieGardes = new ArrayList<>();

        for (PharmacieGarde PharmacieGarde : service.getAllPharmaciesDeGardeEnGarde()) {
            java.util.Date utilDate1 = sdf.parse(String.valueOf(((entities.PharmacieGarde) PharmacieGarde.getPharmacieGarde()).getDate_debut()));
            java.util.Date utilDate2 = sdf.parse(String.valueOf(PharmacieGarde.getDate_debut()));

            long millis1 = utilDate1.getTime();
            long millis2 = utilDate2.getTime();

            java.sql.Date debutSql = new java.sql.Date(millis1);
            java.sql.Date finSql = new java.sql.Date(millis2);

            ((entities.PharmacieGarde) PharmacieGarde.getPharmacieGarde()).setDate_debut(debutSql);
            PharmacieGarde.setDate_fin(finSql);

            PharmacieGardes.add(PharmacieGarde);
        }
        return PharmacieGardes;
    }

    @GetMapping("/EnGarde/ville={id}")
    public List<PharmacieGarde> findPharmacieGardeByVille(@PathVariable int id) {
        return service.findAllPharmacieGardeByVille(id);
    }

    @GetMapping("/EnGarde/zone={id}")
    public List<PharmacieGarde> findPharmacieGardeByZone(@PathVariable int id) {
        return service.findAllPharmacieGardeByZone(id);
    }

    @GetMapping("/EnGarde/type={id}")
    public List<PharmacieGarde> findPharmacieGardeByType(@PathVariable int id) {
        return service.findAllPharmacieGardeByType(id);
    }

    @GetMapping("/Historique/id={id}")
    public List<PharmacieGarde> findPharmacieGardeHistorique(@PathVariable int id) {
        return service.getPharmacieGardeHistorique(id);
    }

    @GetMapping("/all/Usersss_id={Usersss_id}")
    public List<PharmacieGarde> getAllPharmaciesDeGardeByPharmacieId(@PathVariable int Usersss_id) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PharmacieGarde> PharmacieGardes = new ArrayList<>();

        Users Users= UsersService.getUsersById(Usersss_id);
        int pharmacie_id = Users.getPharmacie().getId();
        Pharmacie pharmacie = pharmacieService.findPharmacieById(pharmacie_id);

        for (PharmacieGarde PharmacieGarde : service.getAllPharmaciesDeGardeByPharmacie(pharmacie)) {
            java.util.Date utilDate1 = sdf.parse(String.valueOf(((entities.PharmacieGarde) PharmacieGarde.getPharmacieGarde()).getDate_debut()));
            java.util.Date utilDate2 = sdf.parse(String.valueOf(PharmacieGarde.getDate_debut()));

            long millis1 = utilDate1.getTime();
            long millis2 = utilDate2.getTime();

            java.sql.Date debutSql = new java.sql.Date(millis1);
            java.sql.Date finSql = new java.sql.Date(millis2);

            ((entities.PharmacieGarde) PharmacieGarde.getPharmacieGarde()).setDate_debut(debutSql);
            PharmacieGarde.setDate_fin(finSql);

            PharmacieGardes.add(PharmacieGarde);
        }
        return PharmacieGardes;
    }
}
