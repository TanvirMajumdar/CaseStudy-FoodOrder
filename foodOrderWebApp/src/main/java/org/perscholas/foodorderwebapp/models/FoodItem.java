package org.perscholas.foodorderwebapp.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@Table(name="Item")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodItem{

    @Id
    @Column(name = "Item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long itemId;

    @NonNull @Column(unique = true, length = 45) @NotBlank
    String itemName;

    @NonNull @Column(unique = false, length = 200) @NotBlank
    String itemDescription;

    @NonNull @Column(unique = true, length = 64)
    Float itemPrice;

}
