package com.burcu.bes.user.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = "İsim alanı boş geçilemez!")
    @Size(max = 50, message = "İsim en fazla 50 karakter olmalı")
    private String firstName;

    @NotBlank(message = "Soyisim alanı boş geçilemez!")
    @Size(max = 50, message = "Soyisim en fazla 50 karakter olmalı")
    private String lastName;

    @NotBlank(message = "Email alanı boş geçilemez!")
    @Email(message = "Geçerli bir email giriniz")
    @Size(max = 100, message = "Email en fazla 100 karakter olmalı")
    private String email;

    @NotBlank(message = "Password alanı boş geçilemez!")
    @Size(min = 6, max = 100, message = "Şifre en az 6 karakter olmalı")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // response'ta görünmesin
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$", message = "Şifre en az 8 karakter olmalı ve harf + rakam içermeli")
    private String password;
}
