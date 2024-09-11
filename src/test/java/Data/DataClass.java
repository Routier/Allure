package Data;

import com.github.javafaker.Faker;
import lombok.Value;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataClass {
    private DataClass() {
    }

    public static String genDate(int addedDays) {
        return LocalDate.now().plusDays(addedDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String genCity() {
        var cities = new String[]{"Москва", "Тверь", "Санкт-Петербург", "Тула", "Казань"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String genName(String loc) {
        var faker = new Faker(new Locale(loc));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String genPhone(String loc) {
        var faker = new Faker(new Locale(loc));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateWrongPhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return  faker.numerify("####");
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String loc) {
            return new UserInfo(genCity(), genName(loc), genPhone(loc));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
