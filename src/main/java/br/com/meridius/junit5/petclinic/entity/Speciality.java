package br.com.meridius.junit5.petclinic.entity;

public class Speciality extends BaseEntity {
	
	/** UID **/
	private static final long serialVersionUID = 2746281967816401647L;
	
	private String description;

    public Speciality() {
    }

    public Speciality(String description) {
        this.description = description;
    }

    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "Speciality [description=" + description + "]";
	}
}
