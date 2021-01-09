package auto.shop.project.service;


import auto.shop.project.dto.CarDto;
import auto.shop.project.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public Car fromCarDtoToCar(CarDto carDto)
    {
        Car car = new Car();
        car.setCarModel(carDto.getCarModel());
        car.setCarPrice(carDto.getCarPrice());
        car.setCarDescription(car.getCarDescription());
        return car;
    }

    public CarDto fromCarToCarDto(Car car){
        return CarDto.builder()
                .CarModel(car.getCarModel())
                .CarPrice(car.getCarPrice())
                .CarDescription(car.getCarDescription())
                .build();
    }

}
