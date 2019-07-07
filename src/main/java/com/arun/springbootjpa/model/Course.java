package com.arun.springbootjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "t_course")
@NamedQuery(name = "get_all_course", query = "select c from Course c")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "c_name", nullable = false)
    private String name;
    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;
    @JsonIgnore
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createTimeStamp;
}
