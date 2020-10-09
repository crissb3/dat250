package model;
import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;

    @OneToMany(mappedBy="user")
    private List<Poll> polls;

    @OneToMany(mappedBy="user")
    private List<Vote> votes;
}