package auto.shop.project.controller;


import auto.shop.project.service.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;



}
