package model;

import javax.persistence.*;

import com.google.gson.Gson;
import lombok.Data;

@Entity
@Data
@Table(name="votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne
    private Poll poll;

    @ManyToOne
    private User user;

    public String toJson() {

        Gson gson = new Gson();

        String jsonInString = gson.toJson(this);

        return jsonInString;
    }

}