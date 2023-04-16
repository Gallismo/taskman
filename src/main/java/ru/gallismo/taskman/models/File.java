package ru.gallismo.taskman.models;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "files")
public class File {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uploader_id", referencedColumnName = "id", nullable = false)
    private User uploader;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "tasks_files",
            joinColumns = @JoinColumn(name = "file_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> tasks;

    @Column(name = "path", nullable = false, columnDefinition = "text")
    private String path;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
