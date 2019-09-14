package dz.moh.SpringApi.Repositories;

import dz.moh.SpringApi.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
