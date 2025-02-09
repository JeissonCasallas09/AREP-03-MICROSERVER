package edu.eci.arep.webserver;

@RestController
public class MathController {

    @GetMapping("/e")
    public static String e(String nousada){
        return Double.toString(Math.E);
    }

}
