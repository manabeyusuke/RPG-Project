package character;

import monster.Monster;

public abstract class Character {
	private String name;
	private int hp;
	private String keyName;
	
	 public Character(String name,int hp, String keyName) {
		this.name = name;
		this.hp = hp;
		this.keyName = keyName;
	}
	 
	 public String getName() {
		 return this.name;
	 }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public int getHp() {
		 return this.hp;
	 }
	 
	 public void setHp(int hp) {
		 this.hp = hp;
	 }
	 
	 public String getKeyname() {
		 return this.keyName;
	 }
	 
	 public void setKeyname(String keyName) {
		 this.keyName = keyName;
	 }
	
	//逃げる
	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}
	
	//戦う
	public abstract void attack(Monster m);

}
