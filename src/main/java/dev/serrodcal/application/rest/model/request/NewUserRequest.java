package dev.serrodcal.application.rest.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewUserRequest (
        @NotNull(message = "username cannot be null") @NotEmpty(message = "username cannot be empty") String username,
        String fullName,
        @NotNull(message = "email cannot be null") @NotEmpty(message = "email cannot be empty") @Email(message = "email must follow 'foo@mail.com' format") String email
){ }
