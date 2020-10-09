package model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="polls")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private Timestamp created_at;
    private Timestamp finishes_at;
    private boolean is_private;
    private int green;
    private int red;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy="poll")
    private List<Vote> votes;

}