package model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.User;
import model.Vote;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-05T19:13:41")
@StaticMetamodel(Poll.class)
public class Poll_ { 

    public static volatile SingularAttribute<Poll, Boolean> is_private;
    public static volatile SingularAttribute<Poll, Timestamp> created_at;
    public static volatile SingularAttribute<Poll, Timestamp> finishes_at;
    public static volatile SingularAttribute<Poll, Integer> option1;
    public static volatile ListAttribute<Poll, Vote> votes;
    public static volatile SingularAttribute<Poll, Integer> id;
    public static volatile SingularAttribute<Poll, Integer> option2;
    public static volatile SingularAttribute<Poll, String> title;
    public static volatile SingularAttribute<Poll, User> user;

}