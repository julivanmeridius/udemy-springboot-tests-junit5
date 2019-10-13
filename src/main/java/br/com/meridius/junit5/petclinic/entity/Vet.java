package br.com.meridius.junit5.petclinic.entity;

import java.util.HashSet;
import java.util.Set;


public class Vet extends Person {

	/** UID **/
	private static final long serialVersionUID = -5981820879609698261L;
	
	private Set<Speciality> specialities = new HashSet<>();

    public Vet(Long id, String firstName, String lastName, Set<Speciality> specialities) {
        super(id, firstName, lastName);
        this.specialities = specialities;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

	@Override
	public String toString() {
		return "Vet [specialities=" + specialities + "]";
	}
}
