package monster;

import character.Character;

public class DeathBat extends FlyingMonster {
	
	//	コンストラクタ
	public DeathBat(String name) {
		super(name, Constants.monsterParameters.DEATHBAT_HP, "monster");
	}
	
//	攻撃するメソッド
	public void attack(Character c) {
		System.out.println(c.getName() + "を突っついた！");
		System.out.println(c.getName() + "に3ポイントのダメージ");
		c.setHp(c.getHp() - 3);
	}

}
