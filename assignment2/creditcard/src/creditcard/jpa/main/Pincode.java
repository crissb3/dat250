package creditcard.jpa.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
public @Data class Pincode {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
	private String pincode;
	private int count;
	
	

}
