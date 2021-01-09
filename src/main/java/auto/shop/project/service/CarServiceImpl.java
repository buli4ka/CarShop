package auto.shop.project.service;

import auto.shop.project.dto.CarDto;
import auto.shop.project.entity.Car;
import auto.shop.project.exeption.ValidationException;
import auto.shop.project.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarConverter carConverter;


    private void validateCarDto(CarDto carDto) throws ValidationException {
        if (Objects.isNull(carDto)) {
            throw new ValidationException("Object car is null");
        }
        if (Objects.isNull(carDto.getCarModel()) || carDto.getCarModel().isEmpty()) {
            throw new ValidationException("Model is empty");
        }
    }
    @Override
    public CarDto saveCar(CarDto carDto) throws ValidationException {
        validateCarDto(carDto);
        Car savedCar = carRepository.save(carConverter.fromCarDtoToCar(carDto));
        return carConverter.fromCarToCarDto(savedCar);
    }



    @Override
    public void deleteCar(Integer carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public CarDto findByCarModel(String carModel) {
        Car car = carRepository.findByModel(carModel);
        if (car != null)
            return carConverter.fromCarToCarDto(car);
        return null;
    }

    @Override
    public CopyOnWriteArrayList<CarDto> findAll(){
        return (CopyOnWriteArrayList<CarDto>) carRepository
                .findAll()
                .stream()
                .map(carConverter::fromCarToCarDto)
                .collect(Collectors.toList());
    }
}
