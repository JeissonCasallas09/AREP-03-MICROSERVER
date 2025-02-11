package edu.eci.arep.webserver.classExercises;

import edu.eci.arep.webserver.GetMapping;
import edu.eci.arep.webserver.RestController;

@RestController
public class MathController {

    @GetMapping("/e")
    public static String e(String nousada){
        return Double.toString(Math.E);
    }

}
