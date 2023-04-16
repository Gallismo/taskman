package ru.gallismo.taskman.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tasks_statuses")
public class TaskStatus {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "status")
    private List<TaskHistory> histories;

    @Column(name = "name")
    private String name;

}
