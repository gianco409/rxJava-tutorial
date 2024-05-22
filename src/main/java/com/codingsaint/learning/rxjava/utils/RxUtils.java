package com.codingsaint.learning.rxjava.utils;

import com.codingsaint.learning.rxjava.models.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RxUtils {
    /**
     * Generate List of positive numbers
     * @param positive integer n
     * @return List of Integers
    */
    public static List<Integer> positiveNumbers(Integer n) {
        //List to hold positiveNumbers of size n
        List<Integer> positiveNumbers = new ArrayList<>(n);

        //Iterate over n elements and add to list
        for(int i = 1; i <= n; i ++){
            positiveNumbers.add(i);
        }

        return positiveNumbers;
    }

    /**
     * List of shapes
     * @param positive integer n
     * @return List of shapes
     */
    public static List<Shape> shapes(Integer n) {
        //List to hold shapes of size n
        List<Shape> shapes = new ArrayList<>(n);
        for(int i = 1; i <= n; i ++) {
            shapes.add(new Shape(randomShape(), randomColor()));
        }
        return shapes;
    }

    /**
     * Generate List of prime numbers
     * @param positive integer n
     * @return Lis of prime numbers
     */
    public static List<Integer> primeNumbers(Integer n) {
        //List to hold primeNumbers of size n
        List<Integer> primeNumbers = new ArrayList<>(n);

        //
        boolean totalPrimeCollected = false;
        int i = 1;
        int totalNumbers = 0;
        //Iterate over n elements and add to list
        while(!totalPrimeCollected) {
            if(isPrime(i)) {
                primeNumbers.add(i);
                totalNumbers ++;
            }

            i ++;

            if(totalNumbers == n) {
                totalPrimeCollected = true;
            }
        }

        return primeNumbers;
    }

    /**
     * Find if number is prime
     * @param poitive integer n
     * @return the result in boolean
     */
    public static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i ++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
    private static String randomColor() {
        Random random = new Random();
        String []color = {"blue", "green", "red", "yellow", "pink"};
        return color[random.nextInt(getRandomNumberInRange(1, 4))];
    }

    private static String randomShape() {
        Random random = new Random();
        String []shape = {"square", "triangle", "circle", "pentagon", "hexagon", "stars"};
        return shape[random.nextInt(getRandomNumberInRange(1, 6))];
    }

    private static int getRandomNumberInRange(int min, int max) {
        if(min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
