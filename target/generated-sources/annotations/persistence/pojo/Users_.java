package persistence.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.pojo.Found;
import persistence.pojo.Lost;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T06:07:14")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstName;
    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile CollectionAttribute<Users, Lost> lostCollection;
    public static volatile SingularAttribute<Users, String> phone;
    public static volatile SingularAttribute<Users, String> imageUrl;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile CollectionAttribute<Users, Found> foundCollection;
    public static volatile SingularAttribute<Users, String> email;

}