package com.jwinton.auth.presentation.dto.request;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Valid
    @Size(min = 8, message = "USERNAME_INVALID")
    String username;
    @Size(min = 4, message = "PASSWORD_INVALID")
    String password;
    String firstName;
    String lastName;
    String email;
    LocalDate dob;
}
