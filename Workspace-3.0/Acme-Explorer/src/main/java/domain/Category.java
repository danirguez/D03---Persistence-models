package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Category extends DomainEntity {

	// Constructors

	public Category() {
		super();
	}

	// Attributes

	private String name;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Relationships

	private Category categoryParent;
	private Collection<Category> categories;
	private Collection<Trip> trip;

	
	@ManyToOne(optional = true)
	public Category getCategoryParent() {
		return categoryParent;
	}

	public void setCategoryParent(Category categoryParent) {
		this.categoryParent = categoryParent;
	}
	
	@Valid
	@OneToMany(mappedBy = "categoryParent")
	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "category")
	public Collection<Trip> getTrip() {
		return trip;
	}

	public void setTrip(Collection<Trip> trip) {
		this.trip = trip;
	}

}
