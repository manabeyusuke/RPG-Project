package monster;

import character.Character;

public class DeathBat extends FlyingMonster {
	
	//	コンストラクタ
	public DeathBat(String name) {
		super(name, constants.monsterParameters.DEATHBAT_HP, "monster");
	}
	
//	攻撃するメソッド
	public void attack(Character c) {
		System.out.println(c.getFreename() + "を突っついた！");
		System.out.println(c.getFreename() + "に3ポイントのダメージ");
		c.setHp(c.getHp() - 3);
	}

}
