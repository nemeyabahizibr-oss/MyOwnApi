package com.Student.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(
        name = "departments",
        indexes = @Index(columnList = "name"),
        uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Course> courses;
}
