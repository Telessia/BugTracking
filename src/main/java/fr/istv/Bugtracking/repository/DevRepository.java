package fr.istv.Bugtracking.repository;

import fr.istv.Bugtracking.entity.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface DevRepository extends JpaRepository<Dev,Integer>{
    	//Optional<Dev> findById(Integer Id);
    Dev findById(int id);

    List<Dev> findByFirstName(String first_name);

    List<Dev> findByLastName(String last_name);
    
    void deleteDevById(int id);
/**
    @Query(query = "select t from T t")
    public List<T> getAll();

}
 **/
    }
    	//A completer
    //Voir pour interfaces de methodes type "changer avatar" etc
    // https://o7planning.org/fr/11897/tutoriel-spring-boot-et-spring-data-jpa
