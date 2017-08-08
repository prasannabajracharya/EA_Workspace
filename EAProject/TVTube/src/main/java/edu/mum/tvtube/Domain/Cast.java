package edu.mum.tvtube.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Cast {
	@Id @GeneratedValue
	private int castId;
	private String name;
	private String characterName;
	private String placeOfBirth;
	private String biography;
	@Lob
	@Column(columnDefinition="mediumBlob")
	private byte[] photo;

	public Cast(){
		
	}
	public Cast(String name, String characterName, String placeOfBirth, String biography) {
		super();
		this.name = name;
		this.characterName = characterName;
		this.placeOfBirth = placeOfBirth;
		this.biography = biography;
	}
	
	public int getCastId() {
		return castId;
	}
	public void setCastId(int castId) {
		this.castId = castId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
		
}
