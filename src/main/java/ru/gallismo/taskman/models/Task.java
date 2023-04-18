package ru.gallismo.taskman.models;


import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "performer_id", referencedColumnName = "id")
    private User performer;

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private User creator;

    @ManyToOne(cascade = {CascadeType.ALL})
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "parent_task_id", referencedColumnName = "id")
    private Task parentTask;

    @OneToMany(mappedBy = "parentTask")
    private List<Task> childTasks;

    @OneToMany(mappedBy = "task")
    private List<TaskHistory> histories;

    @OneToMany(mappedBy = "task")
    private List<TaskComment> comments;

    @ManyToMany(mappedBy = "tasks")
    private List<File> files;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "repeat_rule")
    private Integer repeatRule;

    @Column(name = "address")
    private String address;

    @Column(name = "deadline_date")
    @Temporal(TemporalType.DATE)
    private Date deadlineDate;

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
