package character;

import Constants.characterParameters;
import monster.Monster;

public class Thief extends Character {
	int mp;
	
	public Thief(int index, String job, String key) {
		super(index,  job, key, characterParameters.THIEF_MAX_HP, characterParameters.THIEF_HP);
		this.mp = characterParameters.THIEF_MP;
	}
	
	public void attack(Monster m) {
		System.out.println(this.getFreename() + "の攻撃！");
		System.out.println(m.getName() + "に1ポイントのダメージ");
		m.setHp(m.getHp() - 1);
	}

}
