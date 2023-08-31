package films.controller;

import static films.controller.SparkHandler.*;
public class LambdaInit {

    public static void main(String[] args) {
        get("/hello", str -> "");
    }
}
