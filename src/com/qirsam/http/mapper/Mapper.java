package com.qirsam.http.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
