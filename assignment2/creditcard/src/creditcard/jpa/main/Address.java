package creditcard.jpa.main;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
public @Data class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
	private String street;
	private int number;
	
	@ManyToMany(mappedBy = "addresses")
	private List<Person> person = new ArrayList<>();
	
}
