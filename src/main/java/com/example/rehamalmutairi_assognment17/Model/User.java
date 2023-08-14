package com.example.rehamalmutairi_assognment17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private Integer id;

    @NotEmpty
    @Size(min = 5, message = "Your name must more than 4")
    @Column(columnDefinition = "varchar(25) not null, check ( LENGTH(name) > 4  )")
    private String name;

    @NotEmpty(message = "username can't be empty")
    @Size(min = 5)
    @Column(columnDefinition = "varchar(10) unique not null ,  check ( LENGTH(username) > 4 )")
    private String username;

    @NotEmpty(message = "password can't be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;

    @Email(message = "Email format not correct")
    @NotEmpty(message = "Email must not empty")
    @Column(columnDefinition = "varchar(30) unique not null")
    private String email;

    @NotEmpty(message = "Your role can't be empty")
    @Pattern(regexp = "\\b(admin)|\\b(user)")
    @Column(columnDefinition = "varchar(7) not null , check ( role = 'admin' or role = 'user' )")
    private String role;

    @NotNull(message = "Your aage can't be null")
    @Positive
    @Column(columnDefinition = "int not null")
    protected Integer age;

}
