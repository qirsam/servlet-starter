package com.qirsam.http.dao;

import com.qirsam.http.entity.User;
import com.qirsam.http.utils.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
public class UserDao implements Dao<Integer, User> {

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
            INSERT INTO users (name, birthday, email, password, role, gender, image)
            VALUES (?, ?, ?, ?, ?, ?, ?)""";

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) { //для автогеренерации Id
            prepareStatement.setObject(1, entity.getName());
            prepareStatement.setObject(2, entity.getBirthday());
            prepareStatement.setObject(3, entity.getEmail());
            prepareStatement.setObject(4, entity.getPassword());
            prepareStatement.setObject(5, entity.getRole().name());
            prepareStatement.setObject(6, entity.getGender().name());
            prepareStatement.setObject(7, entity.getImage());

            prepareStatement.executeUpdate();
            var generatedKeys = prepareStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class)); //устанавливаем Id

            return entity;
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}