package org.perscholas.foodorderwebapp.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class User {


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Length(min = 5, message = "Your username must have at least 5 characters")
    @NonNull @Column(unique = true) @NotBlank
    String username;

    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NonNull @Column(unique = true) @NotBlank
    String password;

    @Length(min = 1, message = "First name should not be empty")
    @NonNull @Column(unique = false) @NotBlank
    String firstName;

    @Length(min = 1, message = "Last name should not be empty")
    @NonNull @Column(unique = false) @NotBlank
    String lastName;

    @NonNull @Column(unique = true) @NotBlank
    @Email(message = "*Please provide a valid Email")
    String email;

    @NonNull @Column(unique = true) @NotBlank
    String phone;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles = new HashSet<>();

}
