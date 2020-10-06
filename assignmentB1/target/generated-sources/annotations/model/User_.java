package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Poll;
import model.Vote;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-05T18:57:53")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, Poll> polls;
    public static volatile ListAttribute<User, Vote> votes;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> username;

}