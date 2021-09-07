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
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long itemId;

    @NonNull @Column(name = "item_name", unique = true, length = 45) @NotBlank
    String itemName;

    @NonNull @Column(name = "item_description", unique = false, length = 200) @NotBlank
    String itemDescription;

    @NonNull @Column(name = "item_price", unique = false, length = 64)
    Float itemPrice;

}
