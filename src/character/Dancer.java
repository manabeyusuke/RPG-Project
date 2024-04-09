package character;

import Constants.characterParameters;
import monster.Monster;

public class Dancer extends Character{
	
	public Dancer(String name) {
		super(name, characterParameters.DANCER_HP);
	}
	
	public void Dance() {
		System.out.println(this.name + "は情熱的に踊った！");
	}

	@Override
	public void attack(Monster m) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(this.name + "の攻撃！");
		System.out.println("敵に3ポイントのダメージ");
		m.hp -= 3;
	}

}
