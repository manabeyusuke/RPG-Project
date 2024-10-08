package character;

import monster.Monster;

public abstract class Character {
	private String name;
	private int hp;
	private String keyName;
	private String freeName;
	
	public Character() {
		//空のコンストラクタ
	}
	
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
	 
	 public String getFreeName() {
		 return this.freeName;
	 }
	 
	 public void setFreeName(String freeName) {
		 this.freeName = freeName;
	 }
	
	//逃げる
	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}
	
	//戦う
	public abstract void attack(Monster m);

}
