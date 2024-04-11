package character;

import Constants.characterParameters;
import monster.Monster;

public class SuperHero extends Hero{
	boolean flying;
	
	public SuperHero(String name) {
		super(name, characterParameters.SUPER_HERO_HP);
	}
	
	public void fly() {
		this.flying = true;
		System.out.println(this.getName() + "は飛び上がった！");
	}
	
	public void land() {
		this.flying = false;
		System.out.println(this.getName() + "は着地した！");
	}
	
	public void run() {
		this.flying = false;
		System.out.println(this.getName() + "は撤退した！");
	}
	
	public void attack(Monster m) {
		super.attack(m);
		if (this.flying) {
			super.attack(m);
		}
	}
	

}
