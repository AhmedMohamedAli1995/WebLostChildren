package persistence.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.pojo.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-20T06:07:14")
@StaticMetamodel(Lost.class)
public class Lost_ { 

    public static volatile SingularAttribute<Lost, String> lostDate;
    public static volatile SingularAttribute<Lost, String> lastName;
    public static volatile SingularAttribute<Lost, String> gender;
    public static volatile SingularAttribute<Lost, String> motherName;
    public static volatile SingularAttribute<Lost, String> description;
    public static volatile SingularAttribute<Lost, String> firstName;
    public static volatile SingularAttribute<Lost, String> orginalAddress;
    public static volatile SingularAttribute<Lost, String> phone;
    public static volatile SingularAttribute<Lost, String> imageUrl;
    public static volatile SingularAttribute<Lost, Integer> id;
    public static volatile SingularAttribute<Lost, Users> lostUserId;
    public static volatile SingularAttribute<Lost, String> returned;
    public static volatile SingularAttribute<Lost, String> lostLocation;
    public static volatile SingularAttribute<Lost, Integer> age;

}