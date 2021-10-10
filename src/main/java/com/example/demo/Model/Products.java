package com.example.demo.Model;
import lombok.*;

import java.util.Collection;
import java.util.Set;
import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String name;
    private String oldprice;
    private String price;
    private String quantity;
    private String images;
    private String color;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Category category;
}
