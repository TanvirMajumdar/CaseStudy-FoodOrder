package org.perscholas.foodorderwebapp.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Column(name = "user_id", length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Length(min = 5, message = "Your username must have at least 5 characters")
    @NonNull @Column(unique = true, length = 45) @NotBlank
    String username;

    @Length(min = 5, message = "Your password must have at least 5 characters")
    @NonNull @Column(unique = false, length = 100) @NotBlank
    String password;

    @Length(min = 1, message = "First name should not be empty")
    @NonNull @Column(name = "first_name", unique = false, length = 45) @NotBlank
    String firstName;

    @Length(min = 1, message = "Last name should not be empty")
    @NonNull @Column(name = "last_name", unique = false, length = 45) @NotBlank
    String lastName;

    @NonNull @Column(unique = true, length = 45) @NotBlank
    @Email(message = "Please provide a valid Email")
    String email;


    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles= new HashSet<>();
}
