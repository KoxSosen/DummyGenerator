package com.github.koxsosen.Generator;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.random.RandomGenerator;

public class PropertiesGenerator {

    public String getRandomReason() {
        Faker faker = new Faker();
        if (Random.from(RandomGenerator.getDefault()).nextInt() % 2 == 0) {
            return faker.hacker().abbreviation();
        } else {
            return faker.shakespeare().asYouLikeItQuote();
        }
    }

}
