package fr.istv.Bugtracking.route;

import fr.istv.Bugtracking.entity.Bug;
import fr.istv.Bugtracking.entity.Dev;
import fr.istv.Bugtracking.repository.BugRepository;
import fr.istv.Bugtracking.service.XBugService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BugRoute<BugService> {

    @Autowired
    BugRepository bugRepository;

    @Autowired
    XBugService bugService;

    @GetMapping("bug/{ID}")
    @ApiOperation(value="Retrieve one bug by its ID", response = Bug.class)
        public Bug getBug (@PathVariable("ID") int id){
            return bugRepository.findById(id);
        }

    @GetMapping("bug")
    @ApiOperation(value="List all bugs", response = Bug.class)
    public List<Bug> getAllSBugs() {
        return bugRepository.findAll();
    }

    @GetMapping("bug/{priority}")
    @ApiOperation(value="List bugs by a chosen priority", response = Bug.class)
        public List<Bug> getByPriority(@PathVariable("priority") String priority){
            return bugRepository.findByPriority(priority);
        }

    @GetMapping("bug/{state}")
    @ApiOperation(value="List bugs by a chosen state", response = Bug.class)
        public List<Bug> getByState(@PathVariable("state") String state){
            return bugRepository.findByState(state);
        }

    @GetMapping("bug/{dev}")
    @ApiOperation(value="List all bugs of a developer", response = Bug.class)
        public List<Bug> getBugByDev(@PathVariable("dev") Dev dev){
            return bugRepository.findByDev(dev);
        }
}