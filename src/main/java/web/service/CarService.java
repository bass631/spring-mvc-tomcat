package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    final private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Model_1", 1, "Color_1"));
        cars.add(new Car("Model_2", 2, "Color_2"));
        cars.add(new Car("Model_3", 3, "Color_3"));
        cars.add(new Car("Model_4", 4, "Color_4"));
        cars.add(new Car("Model_5", 5, "Color_5"));
    }

    public List<Car> getCarCount(Integer count) {
        if (count == null) {
            return cars;
        } else {
            return cars.stream().limit(count).toList();
        }
    }
}
