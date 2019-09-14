package dz.moh.SpringApi.Exceptions;

public class ReservationNotFound extends Exception {
    public ReservationNotFound(Long id){
        super("Reservation not Found"+id);
    }
}
