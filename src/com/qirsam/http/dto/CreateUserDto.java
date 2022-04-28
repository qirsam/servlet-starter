package com.qirsam.http.dto;

import jakarta.servlet.http.Part;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto { //все поля приходят в виде ключ значение, оба являются строковыми
    String name;
    String birthday;
    Part image;
    String email;
    String password;
    String role;
    String gender;
}
