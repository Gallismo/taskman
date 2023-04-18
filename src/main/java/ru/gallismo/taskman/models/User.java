package ru.gallismo.taskman.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user")
    private EmailConfirmation confirmation;

    @OneToMany(mappedBy = "uploader")
    private List<File> files;

    @OneToMany(mappedBy = "performer")
    private List<Task> tasksToPerform;

    @OneToMany(mappedBy = "creator")
    private List<Task> createdTasks;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "email_confirm", nullable = false)
    private Boolean emailConfirm;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    private void create() {
        createdAt = new Date();
    }

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PreUpdate
    private void update() {
        updatedAt = new Date();
    }

}
