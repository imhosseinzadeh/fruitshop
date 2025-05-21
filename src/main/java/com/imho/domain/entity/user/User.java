package com.imho.domain.entity.user;

import com.imho.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = User.TABLE_NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
public abstract class User extends BaseEntity<Long> {
    public static final String TABLE_NAME = "users";
    public static final String NAME = "name";
    public static final String NATIONAL_ID = "national_id";
    public static final String PASSWORD = "password";

    @Column(name = NAME)
    private String name;

    @Column(name = NATIONAL_ID, nullable = false, unique = true)
    private String nationalId;

    @Column(name = PASSWORD, nullable = false)
    private String password;

    public User(String name, String nationalId, String password) {
        this.name = name;
        this.nationalId = nationalId;
        this.password = password;
    }
}
