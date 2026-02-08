package com.nisapps.restaurant.domain.entities;


import com.nisapps.restaurant.domain.enums.TableType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "tables")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TableType type = TableType.INSIDE;

    @Column(unique = true)
    private Integer number;

    @Builder.Default
    @Column(nullable = false)
    private Integer capacity = 4;

    @Builder.Default
    private Boolean active = true;
}
