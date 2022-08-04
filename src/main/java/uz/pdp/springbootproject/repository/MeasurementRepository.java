package uz.pdp.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootproject.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    boolean existsByName(String name);
}
