package com.imho.domain.entity.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity<ID> {
    public static final String ID = "id";
    public static final String CREATE_DATE = "create_date";
    public static final String LAST_UPDATE_DATE = "last_update_date";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private ID id;

    @Column(name = CREATE_DATE)
    private ZonedDateTime createDate;

    @Column(name = LAST_UPDATE_DATE)
    private ZonedDateTime lastUpdateDate;

    @Version
    private long version;

    @PrePersist
    public void prePersist() {
        setCreateDate(ZonedDateTime.now());
        setLastUpdateDate(ZonedDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        setLastUpdateDate(ZonedDateTime.now());
    }


}
