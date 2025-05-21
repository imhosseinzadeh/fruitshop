package com.imho.domain.entity;

import com.imho.domain.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = Fruit.TABLE_NAME)
@Entity
@NamedEntityGraph(
        name = Fruit.ENTITY_GRAPH_NAME
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fruit extends BaseEntity<Long> {
    public static final String ENTITY_GRAPH_NAME = "fruit_graph";
    public static final String TABLE_NAME = "fruits";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String INVENTORY_WEIGHT = "inventory_weight";
    public static final String PRICE = "price";

    @Column(name = NAME, unique = true, nullable = false)
    private String name;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = INVENTORY_WEIGHT, nullable = false)
    private Double InventoryWeight;

    @Column(name = PRICE, nullable = false)
    private Double price;
}