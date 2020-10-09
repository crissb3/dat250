package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Poll;
import model.User;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-09-30T21:05:19", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Vote.class)
public class Vote_ { 

    public static volatile SingularAttribute<Vote, Integer> id;
    public static volatile SingularAttribute<Vote, Poll> poll;
    public static volatile SingularAttribute<Vote, User> user;

}