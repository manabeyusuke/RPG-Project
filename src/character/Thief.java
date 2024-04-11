package character;

import Constants.characterParameters;
import monster.Monster;

public class Thief extends Character {
	int mp;
	
	public Thief(String name) {
		super(name, characterParameters.THIEF_HP, "thief");
		this.mp = characterParameters.THIEF_MP;
	}
	
	public void attack(Monster m) {
		System.out.println(this.getName() + "の攻撃！");
		System.out.println(m.getName() + "に1ポイントのダメージ");
		m.setHp(m.getHp() - 1);
	}

}
