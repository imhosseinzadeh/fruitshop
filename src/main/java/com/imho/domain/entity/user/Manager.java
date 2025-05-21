package com.imho.domain.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedEntityGraph;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NamedEntityGraph(
        name = Manager.ENTITY_GRAPH_NAME
)
@Getter
@Setter
@NoArgsConstructor
public class Manager extends User {
    public static final String ENTITY_GRAPH_NAME = "manger_graph";

    public Manager(String name, String nationalId, String password) {
        super(name, nationalId, password);
    }
}
