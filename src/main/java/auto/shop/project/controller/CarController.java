package auto.shop.project.controller;


import auto.shop.project.dto.CarDto;
import auto.shop.project.exeption.ValidationException;
import auto.shop.project.service.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@Log
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @PostMapping("/save")
    public CarDto saveCars(@RequestBody CarDto carDto) throws ValidationException{
        log.info("Handling save cars: " + carDto);
        return carService.saveCar(carDto);
    }
    @GetMapping("/findAll")
    public CopyOnWriteArrayList<CarDto> findAllUsers() {
        log.info("Handling find all cars request");
        return carService.findAll();
    }

    @GetMapping("/findByModel")
    public CarDto findByLogin(@RequestParam String Model) {
        log.info("Handling find by model request: " + Model);
        return carService.findByCarModel(Model);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Void> deleteCars(@PathVariable Integer id) {
        log.info("Handling delete car request: " + id);
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}