package como.apirest.apirest.jsons;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantRest {
	@JsonIncludeProperties("id")
	private Long id;

	@JsonIncludeProperties("name")
	private String name;

	@JsonIncludeProperties("address")
	private String address;

	@JsonIncludeProperties("description")
	private String description;

	@JsonIncludeProperties("image")
	private String image;

	@JsonIncludeProperties("turns")
	private List<TurnRest> turns;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<TurnRest> getTurn() {
		return turns;
	}

	public void setTurn(List<TurnRest> turn) {
		this.turns = turn;
	}
	
	
}
