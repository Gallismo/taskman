package ru.gallismo.taskman.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User() {}

    public User(Long id, EmailConfirmation confirmation, List<File> files,
                List<Task> tasksToPerform, List<Task> createdTasks, String login,
                String password, String email, Boolean emailConfirm, String firstName,
                String lastName, String middleName, Boolean isAdmin) {
        this.id = id;
        this.confirmation = confirmation;
        this.files = files;
        this.tasksToPerform = tasksToPerform;
        this.createdTasks = createdTasks;
        this.login = login;
        this.password = password;
        this.email = email;
        this.emailConfirm = emailConfirm;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmailConfirmation getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(EmailConfirmation confirmation) {
        this.confirmation = confirmation;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<Task> getTasksToPerform() {
        return tasksToPerform;
    }

    public void setTasksToPerform(List<Task> tasksToPerform) {
        this.tasksToPerform = tasksToPerform;
    }

    public List<Task> getCreatedTasks() {
        return createdTasks;
    }

    public void setCreatedTasks(List<Task> createdTasks) {
        this.createdTasks = createdTasks;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailConfirm() {
        return emailConfirm;
    }

    public void setEmailConfirm(Boolean emailConfirm) {
        this.emailConfirm = emailConfirm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

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
