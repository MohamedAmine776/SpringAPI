package dz.moh.SpringApi.Exceptions;

public class UserNotFound extends RuntimeException {
    public UserNotFound(Long id){
        super("User not found : "+ id);
    }
}
