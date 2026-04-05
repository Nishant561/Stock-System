package stock.app.models;


import jakarta.persistence.*;
import lombok.*;
import stock.app.audit.BaseAuditing;
import stock.app.enums.UserRoles;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@Entity
@Table(name = "app_user")

public class User extends BaseAuditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true, length = 50)
    private String userName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;




    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> userRole = new HashSet<>();

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private Boolean isEmailVerified;











}
