package dz.moh.SpringApi.Controllers;

import dz.moh.SpringApi.Entities.Reservation;
import dz.moh.SpringApi.Exceptions.ReservationNotFound;
import dz.moh.SpringApi.Repositories.ReservationRepository;
import dz.moh.SpringApi.Repositories.UserRepository;
import dz.moh.SpringApi.Repositories.VoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;
  /*  @Autowired
    VoyageRepository voyageRepository;
    @Autowired
    UserRepository userRepository;*/

    @GetMapping("/reservation")
    List<Reservation> getReservation(){
        return reservationRepository.findAll();
    }
    @GetMapping("/reservation/{id}")
    Reservation oneReservation(@PathVariable Long id) throws ReservationNotFound {
        return reservationRepository.findById(id).orElseThrow(()->new ReservationNotFound(id));
    }
    @PostMapping("/reservation")
    Reservation addReservation(@Valid @RequestBody Reservation reservation){

        return reservationRepository.save(reservation);
    }
    @PutMapping("/reservation/{id}")
    Reservation updateReservation(@PathVariable Long id,@Valid @RequestBody Reservation reservationDetails) throws ReservationNotFound {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()->new ReservationNotFound(id));
        reservation.setDate_reservation(reservationDetails.getDate_reservation());
        reservation.setId_user(reservationDetails.getId_user());
        reservation.setId_voyage(reservationDetails.getId_voyage());
       return reservationRepository.save(reservation);
    }
    @DeleteMapping("/reservation/{id}")
     Map<String,Boolean> deleteReservation(@PathVariable Long id) throws ReservationNotFound {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()->new ReservationNotFound(id));
         reservationRepository.delete(reservation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }




}

