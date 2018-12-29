package entity;

import java.io.Serializable;
public class Company implements Serializable{
	private String name;
	private int sex;
	private String position;
	public Company() {
		super();
	}
	public Company(String name, int sex, String position) {
		super();
		this.name = name;
		this.sex = sex;
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", sex=" + sex + ", position=" + position + "]";
	}
	
	
	
}
