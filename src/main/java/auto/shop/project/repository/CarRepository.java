package auto.shop.project.repository;

import auto.shop.project.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer>
{
    Car findByModel(String model);
}

