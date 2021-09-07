package org.perscholas.foodorderwebapp.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    Long id;
    @NonNull @NotBlank
    @Column(length = 25, unique = true)
    String role;

    @Override
    public String toString() {
        return this.role;
    }
}
