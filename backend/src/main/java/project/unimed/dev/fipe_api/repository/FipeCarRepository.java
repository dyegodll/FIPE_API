package project.unimed.dev.fipe_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.unimed.dev.fipe_api.entity.FipeCar;

public interface FipeCarRepository extends JpaRepository<FipeCar, Long> {

}