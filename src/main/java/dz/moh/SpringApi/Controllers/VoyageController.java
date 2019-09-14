package dz.moh.SpringApi.Controllers;

import dz.moh.SpringApi.Entities.Voyage;
import dz.moh.SpringApi.Exceptions.VoyageNotFound;
import dz.moh.SpringApi.Repositories.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class VoyageController {

    @Autowired
    VoyageRepository voyageRepository;


    @GetMapping("/voyage")
    List<Voyage> getVoyage(){
        return voyageRepository.findAll();
    }

    @GetMapping("/voyage/{id}")
    Voyage oneVoyage(@PathVariable Long id) throws VoyageNotFound {
        return voyageRepository.findById(id).orElseThrow(()-> new VoyageNotFound(id));
    }
    @PostMapping("/voyage")
    Voyage addVoyage(@Valid @RequestBody Voyage voyage){
        return voyageRepository.save(voyage);
    }
    @DeleteMapping("/voyage/{id}")
    Map<String,Boolean> deleteVoyage(@PathVariable Long id) throws VoyageNotFound {
        Voyage voyage = voyageRepository.findById(id).orElseThrow(()->new VoyageNotFound(id));
        voyageRepository.delete(voyage);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/voyage/{id}")
    Voyage updateVoyage(@PathVariable Long id ,@Valid @RequestBody Voyage voyageDetails) throws VoyageNotFound {
        Voyage voyage=voyageRepository.findById(id).orElseThrow(()-> new VoyageNotFound(id));
        voyage.setType(voyageDetails.getType());
        voyage.setDate_arrive(voyageDetails.getDate_arrive());
        voyage.setDate_depart(voyageDetails.getDate_depart());
        voyage.setDestination(voyageDetails.getDestination());
        voyage.setPrix(voyageDetails.getPrix());
       return voyageRepository.save(voyage);
    }
}
