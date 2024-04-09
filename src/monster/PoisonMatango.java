package monster;

import character.Hero;

public class PoisonMatango extends WalkingMonster{
	int poisonAttackCount = 5;
	
	public void attack(Hero h) {
		if (this.poisonAttackCount > 0) {
			System.out.println("さらに毒の胞子をばらまいた！");
			int poisonDamage = h.hp / 5;
			h.hp -= poisonDamage;
			System.out.println(poisonDamage + "ポイントのダメージ");
			System.out.println("現在の" + h.name + "のHP：" + h.hp);
			this.poisonAttackCount--;
		}
	}
	
}
