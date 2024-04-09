package character;

import Constants.characterParameters;
import monster.Monster;

public class Thief extends Character {
	int mp;
	
	public Thief(String name) {
		super(name, characterParameters.THIEF_HP);
		this.mp = characterParameters.THIEF_MP;
	}
	
	public void attack(Monster m) {
		System.out.println(this.name + "の攻撃！");
		System.out.println(m.name + "に1ポイントのダメージ");
		m.hp -= 1;
	}

}
