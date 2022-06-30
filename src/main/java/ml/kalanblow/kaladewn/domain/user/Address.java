package ml.kalanblow.kaladewn.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address {
	 @Column(
	            insertable = true,
	            updatable = true)
	    private String street;

	    @Column(
	            insertable = true,
	            updatable = true)
	    private int streetNumber;

	    @Column(
	            insertable = true,
	            updatable = true)
	    private String city;

	    @Column(
	            insertable = true,
	            updatable = true)
	    private Integer codePostale;

	    @Column(
	            insertable = true,
	            updatable = true)
	    private String country;

}
