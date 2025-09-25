package com.example.profile_management_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "profile_pic", length = 512)
    private String profilePic;

    private String sex;

    private Integer age;

    private String pronouns;

    @Lob
    private String about;

    // Store as JSON in DB, convert to List<String> in Java
    @Convert(converter = ListStringConverter.class)
    @Column(columnDefinition = "json")
    private List<String> techstack;

    // Case studies as JSON array of objects
    @Convert(converter = CaseStudyListConverter.class)
    @Column(name = "case_studies", columnDefinition = "json")
    private List<CaseStudy> caseStudies;

    // Projects as JSON array of objects
    @Convert(converter = ProjectListConverter.class)
    @Column(columnDefinition = "json")
    private List<Project> projects;

    @Column(name = "video_link", length = 512)
    private String videoLink;

    @Column(name = "resume_link", length = 512)
    private String resumeLink;

    @Column(name = "github_link", length = 512)
    private String githubLink;

    @Column(name = "linkedin_link", length = 512)
    private String linkedinLink;

    private String email;

    private String phone;
}
