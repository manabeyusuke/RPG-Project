package monster;

import character.Hero;

public class DeathBat extends FlyingMonster {
	
	//	コンストラクタ
	public DeathBat(String name) {
		this.name = name;
		this.hp = 10;
	}
	
//	攻撃するメソッド
	public void attack(Hero h) {
		System.out.println(h.name + "を突っついた！");
		System.out.println(h.name + "に3ポイントのダメージ");
		h.hp -= 3;
	};

}
