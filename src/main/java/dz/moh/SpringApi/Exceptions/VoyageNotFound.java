package dz.moh.SpringApi.Exceptions;

public class VoyageNotFound extends Exception {
    public VoyageNotFound(Long id){
        super("Voyage not found"+id);
    }
}
