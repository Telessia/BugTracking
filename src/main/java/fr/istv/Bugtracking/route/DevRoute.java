package fr.istv.Bugtracking.route;

import fr.istv.Bugtracking.entity.Dev;
import fr.istv.Bugtracking.repository.DevRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DevRoute {

    @Autowired
    DevRepository devRepository;

   // @Autowired
    //DevService devService;

    @GetMapping("dev/id/{ID}")
    @ApiOperation(value="Retrieve one dev by its ID", response = Dev.class)
    public Dev getDev (@PathVariable("ID") int id){
        return devRepository.findById(id);
    }

    @GetMapping("dev/all")
    @ApiOperation(value="List all devs", response = List.class)
    public List<Dev> getAllDevs() {
        return devRepository.findAll();
    }

    @GetMapping("dev/lastname/{lastname}")
    @ApiOperation(value="List devs who share the same last name", response = List.class)
    public List<Dev> getByPriority(@PathVariable("priority") String lastname){
        return devRepository.findByLastname(lastname);
    }

    @GetMapping("dev/firstname/{firstname}")
    @ApiOperation(value="List devs who share the same first name", response = List.class)
    public List<Dev> getByState(@PathVariable("state") String firstname){
        return devRepository.findByFirstname(firstname);
    }
}
