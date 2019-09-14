package dz.moh.SpringApi.Repositories;

import dz.moh.SpringApi.Entities.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageRepository extends JpaRepository<Voyage,Long> {
}
