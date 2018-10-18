package com.softpager.cregistration.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_photo")
public class UserPhoto {
	
	@Id
	private long id;
	private long userId;
	private byte[] photo;
	

}
