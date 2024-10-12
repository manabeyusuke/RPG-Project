package monster;

import character.Character;

public class Goblin extends WalkingMonster {
	
	//	コンストラクタ
	public Goblin(String name) {
		super(name, Constants.monsterParameters.GOBLIN_HP, "monster");
	}
	
//	攻撃するメソッド
	public void attack(Character c) {
		System.out.println(c.getFreeName() + "をナイフで切り付けた！");
		System.out.println(c.getFreeName() + "に2ポイントのダメージ");
		c.setHp(c.getHp() - 2);
	};

}
