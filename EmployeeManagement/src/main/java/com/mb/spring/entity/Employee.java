package com.mb.spring.entity;


import java.util.List;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.mb.spring.util.ValidEmail;



//
//@NamedEntityGraph(
//name = "emp.detail",
//attributeNodes = {
//    @NamedAttributeNode("department"),
//    @NamedAttributeNode("skills"),
//}
//)

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"skills", "department", "profile"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column()
    private String email;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_skills",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;
}