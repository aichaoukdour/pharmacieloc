package controllers;




import entities.Ville;
import entities.Zone;
import services.VilleService;
import services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/zones")
@CrossOrigin
public class ZoneController {

	@Autowired
	private ZoneService service;

	@Autowired
	private VilleService vservice;

	@PostMapping("/add")
	public Zone save(@RequestBody Zone zone) {

		return service.addZone(zone);
	}

	@GetMapping("/all")
	public List<Zone> findAllZone(){

		return service.findAllZone();
	}

	@GetMapping("/zone/id={id}")
	public Zone findZoneById(@PathVariable int id){

		return service.findZoneById(id);
	}

	@GetMapping("/zone/ville={id}")
	public List<Zone> findAllZoneByVille(@PathVariable int id){

		return service.findAllZoneByVille(id);
	}

	@PutMapping("/updateZone/id={id}")
	public Zone updateZone(@RequestParam("nom") String nom,
						   @RequestParam("ville_id") int ville_id,@PathVariable int id){
		Zone z = new Zone();
		Ville v = new Ville();
		v = vservice.findVilleById(ville_id);
		z.setNom(nom);
		z.setVille(v);
		return service.updateZone(z,id);
	}

	@DeleteMapping("/deleteZone/id={id}")
	public String deleteZone(@PathVariable int id){

		return service.deleteZone(id);
	}

	@GetMapping("/NbrPharmacieZone/ville={id}")
	public List findNbrPharmacieZone(@PathVariable int id){
		return service.findNbrPharmacieZone(id);
	}
}
