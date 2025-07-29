package edu.itplusz.bibliospring.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import java.util.Objects;
import java.util.UUID;
@MappedSuperclass
public class AbstractModel {
    @Column(name="uuid",nullable=false,length=36,unique=true)
    private String uuid;

    public String getUuid() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractModel that = (AbstractModel) o;
        return Objects.equals(getUuid(), that.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUuid());
    }

    //lazy modban volt generalva es h biztos le legyen generalva
    @PrePersist
    public void onPrePersist() {
        getUuid();
    }
}
