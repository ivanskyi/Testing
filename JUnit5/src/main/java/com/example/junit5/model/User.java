package com.example.junit5.model;

import java.time.LocalDate;

public record User(String name, Integer age, Boolean blocked, LocalDate birthDate) {
}
