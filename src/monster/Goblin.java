package monster;

import character.Character;

public class Goblin extends WalkingMonster {
	
	//	コンストラクタ
	public Goblin(String name) {
		super(name, Constants.monsterParameters.GOBLIN_HP, "goblin");
	}
	
//	攻撃するメソッド
	public void attack(Character c) {
		System.out.println(c.getName() + "をナイフで切り付けた！");
		System.out.println(c.getName() + "に2ポイントのダメージ");
		c.setHp(c.getHp() - 2);
	};

}
