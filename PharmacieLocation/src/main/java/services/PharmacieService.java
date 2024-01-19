package services;

package service;

import entities.Pharmacie;
import entities.PharmacieGarde;
import entities.Users;
import repositories.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacieService {

    @Autowired
    private PharmacieRepository repository;

    @Autowired
    private PharmacieGardeService pharmacieGardeService;

    public Pharmacie addPharmacie(Pharmacie pharmacie) {
        return repository.save(pharmacie);
    }

    public Pharmacie findPharmacieByUsers(Users users) {
        return repository.findPharmacieByUsers(users);
    }

    public List<Pharmacie> findAllPharmacie() {
        return repository.findAll();
    }

    public Pharmacie findPharmacieById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deletePharmacie(int id) {
        repository.deleteById(id);
        return "Pharmacie " + id + " a été supprimée !!";
    }

    public Pharmacie updatePharmacie(Pharmacie updatedPharmacie, int id) {
        return repository.findById(id).map(
                pharmacie -> {
                    pharmacie.setNom(updatedPharmacie.getNom());
                    pharmacie.setPhoto(updatedPharmacie.getPhoto());
                    pharmacie.setLat(updatedPharmacie.getLat());
                    pharmacie.setLon(updatedPharmacie.getLon());
                    pharmacie.setZone(updatedPharmacie.getZone());
                    return repository.save(pharmacie);
                }
        ).orElse(null);
    }

    public Pharmacie acceptePharmacie(int id) {
        return repository.findById(id).map(
                pharmacie -> {
                    pharmacie.setId(1);
                    return repository.save(pharmacie);
                }
        ).orElse(null);
    }

    public Pharmacie refusPharmacie(int id) {
        return repository.findById(id).map(
                pharmacie -> {
                    pharmacie.setId(2);
                    return repository.save(pharmacie);
                }
        ).orElse(null);
    }

    public List<Pharmacie> findAllPharmacieEnAttente() {
        return repository.findAllPharmacieAttente();
    }

    public List<Pharmacie> findAllPharmacieAccepte() {
        return repository.findAllPharmacieAccepte();
    }

    public List<Pharmacie> findAllPharmacieRefus() {
        return repository.findAllPharmacieRefus();
    }

    public List<Pharmacie> findAllPharmacieByVille(int id) {
        return repository.findAllPharmacieByVille(id);
    }

    public List<Pharmacie> findAllPharmacieByZone(int id) {
        return repository.findAllPharmacieByZone(id);
    }

    public List<Pharmacie> findAllPharmacieByGarde(int id) {
        List<Pharmacie> pharmacies = new ArrayList<>();
        List<PharmacieGarde> pharmacieDeGardes = pharmacieGardeService.findAllPharmacieGardeEnGardeByGardeId(id);
        for (PharmacieGarde p : pharmacieGardes) {
            pharmacies.add(p.getPharmacie());
        }
        return pharmacies;
    }

    public List<Pharmacie> findAllPharmacieDispoByVille(int id) {
        return repository.findPharmcieDispoByVille(id);
    }

    public List<Pharmacie> findAllPharmacieDispoByZone(int id) {
        return repository.findPharmcieDispoByZone(id);
    }

    public List<Pharmacie> findPharmacieProche(double lat1, double long1) {
        List<Pharmacie> list = repository.findAllPharmacieAccepte();
        List<Pharmacie> pharmaciesProches = new ArrayList<>();
        Pharmacie pharmacieProche = new Pharmacie();
        double distanceMin = Double.MAX_VALUE;

        for (Pharmacie pharmacie : list) {
            double distance = org.apache.lucene.util.SloppyMath.haversinMeters(lat1, long1, pharmacie.getLat(), pharmacie.getLog());
            if (distance < distanceMin) {
                pharmacieProche = repository.findById(pharmacie.getId()).orElse(null);
                distanceMin = distance;
            }
        }

        pharmaciesProches.add(pharmacieProche);
        return pharmaciesProches;
    }
}
