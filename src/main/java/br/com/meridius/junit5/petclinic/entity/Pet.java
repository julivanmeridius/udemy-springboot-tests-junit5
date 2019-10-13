package br.com.meridius.junit5.petclinic.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Pet extends BaseEntity{
	
	/** UID **/
	private static final long serialVersionUID = -8350232254856278332L;
	
	private String name;
	
    private PetType petType;
    
    private Owner owner;
    
    private LocalDate birthDate;
    
    private Set<Visit> visits = new HashSet<>();

    public Pet() {
    }

    public Pet(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

	@Override
	public String toString() {
		return "Pet [name=" + name + ", petType=" + petType + ", owner=" + owner + ", birthDate=" + birthDate
				+ ", visits=" + visits + "]";
	}
}
