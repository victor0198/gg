package student.examples.ggengine;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RockController {

    @GetMapping("rock")
    public Map<String,String> getData(){
        Random random = new Random();
        Map<String,String> myMap = new HashMap<>();
        myMap.put("top", String.valueOf(random.nextInt(90)+10));
        myMap.put("left", String.valueOf(random.nextInt(90)+10));
        myMap.put("height", "100");
        myMap.put("width", "100");
        myMap.put("rotation", String.valueOf(random.nextInt(360)));
        myMap.put("color", String.valueOf(random.nextInt(899)+100));
        return myMap;
    }
}
