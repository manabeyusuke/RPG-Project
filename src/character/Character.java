package character;

import monster.Monster;

public abstract class Character {
	public String name;
	public int hp;
	
	public Character(String name,int hp) {
		this.name = name;
		this.hp = hp;
	}
	
	//逃げる
	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}
	
	//戦う
	public abstract void attack(Monster m);

}
