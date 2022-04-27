package com.qirsam.http.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
    MALE,
    FEMALE;

    public static Optional<Gender> find(String gender) { //null-safe метод на сопоставление, т.к. Enum.valueOf выбросит exception при несоответствии
        return Arrays.stream(values())
                .filter(it -> it.name().equals(gender))
                .findFirst();
    }
}
