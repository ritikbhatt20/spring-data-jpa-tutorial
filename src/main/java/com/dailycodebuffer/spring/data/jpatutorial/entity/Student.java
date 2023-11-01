package com.dailycodebuffer.spring.data.jpatutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//I want to add this student entity into my database as tbl_student
@Table(name = "tbl_student", uniqueConstraints = @UniqueConstraint(name = "emailid_unique", columnNames = "email_address"))
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
//    I want this part. id as email-address
    @Column(name = "email_address", nullable = false) //Further more, I want this email id as unique so I will be adding unique constraints here
    private String emailId;         //and since this is unique, it will be non-nullable
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
