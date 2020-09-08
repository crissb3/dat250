package creditcard.jpa.main;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;


@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String firstName;
    
    @OneToMany
    @JoinColumn
    private List<CreditCard> creditcards = new ArrayList<>();
   
    @ManyToMany
    @JoinTable
    private List <Address> addresses = new ArrayList<>();
    
   

}
