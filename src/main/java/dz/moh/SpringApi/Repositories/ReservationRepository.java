package dz.moh.SpringApi.Repositories;

import dz.moh.SpringApi.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
