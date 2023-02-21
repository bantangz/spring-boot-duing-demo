package duing.coontroller;


import duing.bean.Food;
import duing.config.FoodConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 返回json形式的相应结果 而不是视图 html
 * 相当于 @Controller+@Responsebody
 */
@RestController
public class JsonController {

    @Autowired
    private FoodConfig foodConfig;

    @RequestMapping("/json")
    public Food json(){
        Food food = new Food();
        food.setMeat(foodConfig.getMeat());
        food.setRice(foodConfig.getRice());
        return food;
    }
}
