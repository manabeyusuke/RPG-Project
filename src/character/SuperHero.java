package character;

import monster.Monster;

public class SuperHero extends Hero{
	boolean flying;
	
	public SuperHero(int index, String job, String key) {
		super(index, job, key);
	}
	
	public void fly() {
		this.flying = true;
		System.out.println(this.getFreename() + "は飛び上がった！");
	}
	
	public void land() {
		this.flying = false;
		System.out.println(this.getFreename() + "は着地した！");
	}
	
	public void run() {
		this.flying = false;
		System.out.println(this.getFreename() + "は撤退した！");
	}
	
	public void attack(Monster m) {
		super.attack(m);
		if (this.flying) {
			super.attack(m);
		}
	}
	

}
