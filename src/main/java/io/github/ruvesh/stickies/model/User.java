package io.github.ruvesh.stickies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(unique = true)
    private String name;

    @Column
    private String password;
}
