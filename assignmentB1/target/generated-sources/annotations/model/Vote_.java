package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Poll;
import model.User;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-05T18:49:33")
@StaticMetamodel(Vote.class)
public class Vote_ { 

    public static volatile SingularAttribute<Vote, Integer> id;
    public static volatile SingularAttribute<Vote, Poll> poll;
    public static volatile SingularAttribute<Vote, User> user;

}