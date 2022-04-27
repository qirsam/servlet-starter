package com.qirsam.http.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
