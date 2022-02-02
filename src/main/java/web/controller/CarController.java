package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.model.Car;


import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {

    @Autowired
    private CarDao carDao;

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {

        if (count == null) {
            model.addAttribute("resultCars", carDao.indexCars());
        } else {
            final List<Car> qtyCars = carDao.indexCars().stream().limit(count).collect(Collectors.toList());
            model.addAttribute("resultCars", qtyCars);
        }
        return "car";
    }
}
