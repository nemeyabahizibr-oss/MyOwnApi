package com.Student.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(
        name = "students",
        indexes = @Index(columnList = "email"),
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @ManyToOne
    private Department department;

    @ManyToMany
    private Set<Course> enrolledCourses = new HashSet<>();
}
