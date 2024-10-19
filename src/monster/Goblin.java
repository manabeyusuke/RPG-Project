package monster;

import character.Character;
import constants.monsterParameters;

public class Goblin extends WalkingMonster {
	
	//	コンストラクタ
	public Goblin(String name) {
		super(name, monsterParameters.GOBLIN_HP, "monster");
	}
	
//	攻撃するメソッド
	public void attack(Character c) {
		System.out.println(c.getFreename() + "をナイフで切り付けた！");
		System.out.println(c.getFreename() + "に2ポイントのダメージ");
		c.setHp(c.getHp() - 2);
	};

}
