package auto.shop.project.service;


import auto.shop.project.dto.CarDto;
import auto.shop.project.exeption.ValidationException;

import java.util.concurrent.CopyOnWriteArrayList;

public interface CarService {

    CarDto saveCar(CarDto carDto) throws ValidationException;

    void deleteCar(Integer carId);

    CarDto findByCarModel(String carModel);

    CopyOnWriteArrayList<CarDto> findAll();


}
