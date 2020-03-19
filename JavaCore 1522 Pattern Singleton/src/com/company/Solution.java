package com.company;

/*

1522. Lection 15 Level12. Fixing the Singleton Pattern
1. Find an example of the Singleton pattern implementation with lazy initialization. Use your favorite search engine (e.g. google).
2. In the image and likeness in separate files create three singleton classes Sun, Moon, Earth.
3. Implement the Planet interface in the Sun, Moon, and Earth classes.
4. In the static block of the Solution class, call the readKeyFromConsoleAndInitPlanet method.
5. Implement the functionality of the readKeyFromConsoleAndInitPlanet method:
5.1. From the console, read one parameter of type String.
5.2. If the parameter is equal to one of the Planet interface constants, create the corresponding object and assign it to Planet thePlanet, otherwise reset Planet thePlanet to zero.

Requirements:
1. The Sun class should not allow the creation of objects of its type from outside the class.
2. The Sun class must contain a private static instance field of type Sun.
3. In the Sun class, the public static getInstance method returning the value of the instance field must be implemented.
4. The getInstance method in the Sun class should ALWAYS return the same object.
5. The instance field should be initialized after the first call to the getInstance method, but not earlier.
6. The Moon class should not allow creating objects of its type from outside the class.
7. The Moon class must contain a private static instance field of type Moon.
8. In the Moon class, the public static getInstance method returning the value of the instance field should be implemented.
9. The getInstance method in the Moon class should ALWAYS return the same object.
10. The instance field should be initialized after the first call to the getInstance method, but not earlier.
11. The Earth class should not allow the creation of objects of its type from outside the class.
12. The Earth class must contain an instance private static field of type Earth.
13. In the Earth class, a public static getInstance method that returns the value of the instance field should be implemented.
14. The getInstance method in the Earth class should ALWAYS return the same object.
15. The instance field should be initialized after the first call to the getInstance method, but not earlier.
16. The readKeyFromConsoleAndInitPlanet method must be called in the static block of the Solution class.
17. The readKeyFromConsoleAndInitPlanet method must read a single line from the keyboard.
18. The readKeyFromConsoleAndInitPlanet method should correctly update the value of thePlanet variable in accordance with the task condition.
19. Sun, Moon, and Earth classes must be created in separate files.


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            switch (reader.readLine()) {
                case Planet.SUN:
                    thePlanet = Sun.getInstance();
                    break;
                case Planet.MOON:
                    thePlanet = Moon.getInstance();
                    break;
                case Planet.EARTH:
                    thePlanet = Earth.getInstance();
                    break;
                default:
                    thePlanet = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



class Earth implements Planet {
    private static Earth instance;

    private Earth() {}

    public static Earth getInstance() {
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }
}


class Moon implements Planet {
    private static Moon instance;

    private Moon() {}

    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();
        }
        return instance;
    }
}


interface Planet {
    static String SUN = "sun";
    static String MOON = "moon";
    static String EARTH = "earth";
}


class Sun implements Planet {
    private static Sun instance;

    private Sun() {}

    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }
}
