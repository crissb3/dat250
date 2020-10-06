package model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.google.gson.Gson;
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
    private int option1;
    private int option2;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy="poll")
    private List<Vote> votes;

    public String toJson() {

        Gson gson = new Gson();

        String jsonInString = gson.toJson(this);

        return jsonInString;
    }
}