package model;

import java.sql.Timestamp;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.User;
import model.Vote;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-09-30T21:05:19", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Poll.class)
public class Poll_ { 

    public static volatile SingularAttribute<Poll, Boolean> is_private;
    public static volatile SingularAttribute<Poll, Integer> red;
    public static volatile SingularAttribute<Poll, Integer> green;
    public static volatile SingularAttribute<Poll, Timestamp> created_at;
    public static volatile SingularAttribute<Poll, Timestamp> finishes_at;
    public static volatile ListAttribute<Poll, Vote> votes;
    public static volatile SingularAttribute<Poll, Integer> id;
    public static volatile SingularAttribute<Poll, String> title;
    public static volatile SingularAttribute<Poll, User> user;

}