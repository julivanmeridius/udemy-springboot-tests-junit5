package br.com.meridius.junit5.petclinic.entity;


public class PetType extends BaseEntity {

	/** UID **/
	private static final long serialVersionUID = -6773390100088277970L;
	
	private String name;

    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }

    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
    	return name;
    }
}
