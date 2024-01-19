package services;


import entities.Garde;
import entities.Pharmacie;
import entities.PharmacieGarde;
import repositories.PharmacieGardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacieGardeService {
    @Autowired
    private PharmacieGardeRepository repository;

    public PharmacieGarde addPharmacieGarde(PharmacieGarde p){

        return repository.save(p);
    }
    public List<PharmacieGarde> getAllPharmaciesDeGarde(){
        return repository.findAll();
    }
    public List<PharmacieGarde> getAllPharmaciesDeGardeByPharmacie(Pharmacie pharmacie){
        return repository.findAllByPharmacie(pharmacie);
    }

    public List<PharmacieGarde> getPharmacieGardeHistorique(int id){
        return repository.findPharmacieGardeHistorique(id);
    }

    public List<PharmacieGarde> getAllPharmaciesDeGardeDispo() {
        return repository.findAllPharmacieDispo();
    }

    public List<PharmacieGarde> getAllPharmaciesDeGardeEnGarde() {
        return repository.findAllPharmacieEnGarde();
    }

    public List<PharmacieGarde> findAllPharmacieGardeByVille(int id) {
        return repository.findAllPharmacieGardeByVille(id);
    }

    public List<PharmacieGarde> findAllPharmacieGardeByZone(int id) {
        return repository.findAllPharmacieGardeByZone(id);
    }
    public List<PharmacieGarde> findAllPharmacieGardeEnGardeByGardeId(int id) {
        return repository.findAllPharmacieGardeEnGardeByGardeId(id);
    }

    public List<PharmacieGarde> findAllPharmacieGardeByType(int id) {
        return repository.findAllPharmacieGardeByType(id);
    }
}