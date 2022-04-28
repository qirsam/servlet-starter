package com.qirsam.http.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
    USER,
    ADMIN;

    public static Optional<Role> find(String role) { //null-safe метод на сопоставление, т.к. Enum.valueOf выбросит exception при несоответствии
        return Arrays.stream(values())
                .filter(it -> it.name().equals(role))
                .findFirst();
    }
}
