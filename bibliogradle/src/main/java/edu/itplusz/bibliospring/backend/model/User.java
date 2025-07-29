package edu.itplusz.bibliospring.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// a model nem szabad fugjon senkitol, ezert nincsenek benne metodusok, csak getter + setter van az adatagokhoz --POJO
// MODEL - egyedi azonosito kell ,
//       - kozos tulajdonsagokat ki emeljuk - hierarchikus struktura
@Entity
@Table(name="users")
public class User extends edu.itplusz.bibliospring.backend.model.BaseEntity {
    @Column(name="username", unique=true, nullable=false)
    private String userName;
    @Column(name="password", nullable=false)
    private String password;

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Hi!: "+ getUuid() + " " + getId() +  " - " + getUsername() +  " passwd:" + getPassword();
    }
}
