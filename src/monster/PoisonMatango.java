package monster;

import character.Character;

public class PoisonMatango extends WalkingMonster{
	int poisonAttackCount = 5;
	
	public PoisonMatango (String name) {
		super(name, Constants.monsterParameters.MATANGO_HP, "monster");
	}
	
	public void attack(Character c) {
		if (this.poisonAttackCount > 0) {
			System.out.println("さらに毒の胞子をばらまいた！");
			int poisonDamage = c.getHp() / 5;
			c.setHp(c.getHp() - poisonDamage);
			System.out.println(poisonDamage + "ポイントのダメージ");
			System.out.println("現在の" + c.getFreename() + "のHP：" + c.getHp());
			this.poisonAttackCount--;
		}
	}
	
}
