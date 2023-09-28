package ru.netology;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {

    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{
                "Москва",
                "Санкт-Петербург",
                "Ростов-на-Дону",
                "Краснодар",
                "Нижний Новгород",
                "Екатеринбург",
                "Новосибирск",
                "Владивосток"
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastname() + " " + faker.name().firstname();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phonenumber();
    }

    public static class Registration {
        private Registration() {

        }

        public static UserInfo generatorUser(String locale) {
            return new UserInfo(generateCity().generateName(locale).generatePhone(locale));
        }
    }

    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
