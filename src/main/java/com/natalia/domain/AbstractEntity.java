package com.natalia.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;
    private LocalDateTime updated;

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    @PrePersist
    public void setCreated() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }
}