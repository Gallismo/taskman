package ru.gallismo.taskman.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tasks_history")
public class TaskHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private TaskStatus status;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    private void create() {
        createdAt = new Date();
    }
}
