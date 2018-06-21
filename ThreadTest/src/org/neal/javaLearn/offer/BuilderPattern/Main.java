package org.neal.javaLearn.offer.BuilderPattern;

public class Main {
    public static void main(String[] args){
        NutritionFacts cocaCola = new NutritionFacts
                .Builder(240,8)
                .calories(200)
                .fat(100)
                .sodium(23)
                .build();
        System.out.println(cocaCola);
    }
}