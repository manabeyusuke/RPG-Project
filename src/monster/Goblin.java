package monster;

import character.Hero;

public class Goblin extends WalkingMonster {
	
	//	コンストラクタ
	public Goblin(String name) {
		this.name = name;
		this.hp = 5;
	}
	
//	攻撃するメソッド
	public void attack(Hero h) {
		System.out.println(this.name + "ナイフで切り付けた！");
		System.out.println(h.name + "に2ポイントダメージ");
		h.hp -= 2;
	};

}
