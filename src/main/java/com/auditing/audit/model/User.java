package com.auditing.audit.model;

import com.auditing.audit.audit.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author :: Nelson
 *
 */
//for showing its an entity
@Entity
// for creation of the table named users
@Table(name = "users")
//used to specify callback listerner class which was used to register the auditing
//entitylisterner class
//AuditingEntityListener, which contains the callback methods (annotated with the
//@PrePersist and @PreUpdate
//annotations), which will be used to persist and update these properties when we
//        will persist or update our entity.
@EntityListeners( AuditingEntityListener.class )


public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_ID")
    private  long id;

    @Min(value = 3, message = "should be atleast 3 characters")
    @NotNull(message = "required  !!!!")
    @Column(name = "firstname")
    private String firstname;

    @Min(value = 3, message = "should be atleast 3 characters")
    @NotNull(message = "required  !!!!")
    @Column(name = "lastname")
    private String lastname;

    @NotNull(message = "required  !!!!")
    @Email(message = "provide a valid email address")
    @Column(name = "email")
    private String email;

    @Min(value = 10, message = "should be atleast 10 characters")
    @NotNull(message = "required  !!!!")
    @Max(value = 12, message = "should be atleast 12 characters long")
    @Column(name = "contact")
    private String contact;

    @Min(value = 6, message = "should be atleast 6 characters")
    @NotNull(message = "required  !!!!")
    @Column(name = "username")
    private String username;

    @Min(value = 6, message = "should be atleast 6 characters")
    @NotNull(message = "required  !!!!")
    @Column(name = "password")
    private String password;


    //getters and setters


    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public User setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
