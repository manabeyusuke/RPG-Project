package monster;

import character.Character;
import constants.monsterParameters;

public class Matango extends WalkingMonster{
	
	public Matango(String name) {
		super(name, monsterParameters.MATANGO_HP, "monster");
	}
	
	public void attack(Character c) {
		System.out.println(this.getName() + "の攻撃！");
		System.out.println(c.getFreename() + "に10ポイントのダメージ");
		c.setHp(c.getHp() - 10);
//		System.out.println("現在の" + h.name + "のHP：" + h.hp);
	}
}
