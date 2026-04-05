package stock.app.models;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import stock.app.audit.BaseAuditing;
import stock.app.enums.UserRoles;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role extends BaseAuditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, nullable = false, unique = true)
    private UserRoles roleName;


    @ManyToMany(mappedBy = "userRole")
    private Set<User> users = new HashSet<>();


}
