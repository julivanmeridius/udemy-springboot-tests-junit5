package br.com.meridius.junit5.petclinic.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    /** UID **/
	private static final long serialVersionUID = -6788475810755699010L;
	
	private Long id;

    public boolean isNew() {
        return this.id == null;
    }

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + "]";
	}
}
