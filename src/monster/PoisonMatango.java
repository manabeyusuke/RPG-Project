package monster;

import character.Character;
import constants.monsterParameters;

public class PoisonMatango extends WalkingMonster{
	int poisonAttackCount = 5;
	
	public PoisonMatango (String name) {
		super(name, monsterParameters.MATANGO_HP, "PoisonMatango");
	}
	
	public void attack(Character c) {
		if (this.poisonAttackCount > 0) {
			System.out.println("毒の胞子をばらまいた！");
			int poisonDamage = monsterParameters.ATTACK_POISON;
			c.setHp(c.getHp() - poisonDamage);
			System.out.println(c.getFreename() + poisonDamage + "ポイントのダメージ");
			if (!c.getStatuslist("毒")) {
				c.setStatuslist("毒");
				System.out.println(c.getFreename() + "は【状態異常：毒】になった。");
			}
			this.poisonAttackCount--;
		}
	}
	
}
