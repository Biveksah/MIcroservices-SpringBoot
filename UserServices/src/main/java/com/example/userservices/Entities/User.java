package com.example.userservices.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "ID")
    private String userId;
    private String name;
    private String email;
    private String password;
    private String about;
    @Transient
    private ArrayList<Rating> ratings=new ArrayList<>();
}
