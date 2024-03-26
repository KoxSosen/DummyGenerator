package com.github.koxsosen.Generator;

import com.github.javafaker.Faker;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Random;
import java.util.UUID;

public class PropertiesGenerator {

    public String getRandomReason() {
        Faker faker = new Faker();
        Random random = new Random();

        if (random.nextInt(0, 10) % 2 == 0) {
            return faker.hacker().abbreviation();
        } else {
            return faker.shakespeare().asYouLikeItQuote();
        }
    }

    public Duration getRandomDuration() {
        Random random = new Random();

        int number = random.nextInt(0, 10);
        if (number % 2 == 0) {
            // Another nest to try to add more permanent punishments.
            int nextNumber = random.nextInt(0, 10);

            if (nextNumber % 2 == 0) {
                return Duration.ZERO;
            } else {
                return Duration.ofDays(random.nextLong(0, 100));
            }

        } else if (number % 3 == 0) {

            int nextNumber = random.nextInt(0, 10);

            if (nextNumber % 2 == 0) {
                return Duration.ZERO;
            } else {
                return Duration.ofMinutes(random.nextLong(0, 100));
            }

        } else {

            int nextNumber = random.nextInt(0, 10);

            if (nextNumber % 2 == 0) {
                return Duration.ZERO;
            } else {
                return Duration.ofHours(random.nextLong(0, 100));
            }

        }

    }

    public String getRandomName() {
        Faker faker = new Faker();
        return faker.name().username();
    }

    public UUID getRandomOfflineModeUUID(String name) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + name).getBytes(StandardCharsets.UTF_8));
    }

}
