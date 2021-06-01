package como.apirest.apirest.jsons;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRest {
	@JsonIncludeProperties("locator")
	private String locator;
	
	@JsonIncludeProperties("restaurantId")
	private Long restaurantId;
	
	@JsonIncludeProperties("date")
	private Date date;
	
	@JsonIncludeProperties("person")
	private Long person;
	
	@JsonIncludeProperties("turnId")
	private Long turnId;

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getPerson() {
		return person;
	}

	public void setPerson(Long person) {
		this.person = person;
	}

	public Long getTurnId() {
		return turnId;
	}

	public void setTurnId(Long turnId) {
		this.turnId = turnId;
	}
	
	
}
