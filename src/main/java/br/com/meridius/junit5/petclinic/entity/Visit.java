package br.com.meridius.junit5.petclinic.entity;

import java.time.LocalDate;

public class Visit extends BaseEntity {
	
	/** UID **/
	private static final long serialVersionUID = -1484095375421636226L;
	
	private LocalDate date;
	
    private String description;
    
    private Pet pet;

    public Visit() {
        super(null);
    }

    public Visit(Long id) {
        super(id);
    }

    public Visit(Long id, LocalDate date) {
        super(id);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

	@Override
	public String toString() {
		return "Visit [date=" + date + ", description=" + description + ", pet=" + pet + "]";
	}
}
