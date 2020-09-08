package creditcard.jpa.main;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;



@Entity
public @Data class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	private String name;
	
	@OneToMany
	@JoinColumn
	private List<CreditCard> creditcards;
	
	
}
