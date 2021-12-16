package app.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    @NotNull
    @Size(min = 4, max = 20)
    public String username;

    @Column
    @NotNull
    @Size(min = 8, max = 80)
    public String password;

    @Column
    @Email
    @NotNull
    @Size(min = 4, max = 50)
    public String email;

    @Column
    @NotNull
    Boolean isEnabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public List<UserRole> userRoles;
}
