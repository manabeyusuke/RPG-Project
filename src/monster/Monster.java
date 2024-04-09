package monster;

import character.Hero;

public abstract class Monster {
	public String name;
	public int hp;
	
	//逃げるメソッド
	public abstract void run();
	
	//攻撃するメソッド
	public abstract void attack(Hero h);

}
