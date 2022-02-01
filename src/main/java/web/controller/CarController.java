package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {

        final List<Car> cars = new ArrayList<>();
        cars.add((new Car("Model_1", 1, "Color_1")));
        cars.add((new Car("Model_2", 2, "Color_2")));
        cars.add((new Car("Model_3", 3, "Color_3")));
        cars.add((new Car("Model_4", 4, "Color_4")));
        cars.add((new Car("Model_5", 5, "Color_5")));

        if (count == null) {
            model.addAttribute("resultCars", cars);
        } else {
            final List<Car> qtyCars = cars.stream().limit(count).collect(Collectors.toList());
            model.addAttribute("resultCars", qtyCars);
        }
        return "car";
    }
}
