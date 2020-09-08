package creditcard.jpa.main;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;


@Entity
public @Data class CreditCard {
	 @Id
	 @GeneratedValue(strategy = GenerationType.TABLE)
	 private String id;
	 private int number;
	 private int balance;
	 private int limit;
	 
	 @ManyToOne
	 private Bank bank;
	 
	 @OneToOne
	 private Pincode pincode;
	 
}
