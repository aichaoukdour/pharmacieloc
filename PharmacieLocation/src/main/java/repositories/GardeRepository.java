package repositories;



import entities.Garde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardeRepository extends JpaRepository<Garde, Integer> {
 // Ajoutez des méthodes de requête personnalisées si nécessaire
}
