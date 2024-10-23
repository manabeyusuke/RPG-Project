package monster;

import character.Character;
import common.Common;
import constants.monsterParameters;

public class ElectricRat extends WalkingMonster {
	// コンストラクタ
	public ElectricRat(String name) {
		super(name, monsterParameters.ELECTRIC_RAT_HP, "ElectricRat");
	}
	
	// 攻撃するメソッド
	public void attack(Character c) {
		System.out.println(c.getFreename() + "に電撃を放った！");
		System.out.println(c.getFreename() + "に2ポイントのダメージ");
		c.setHp(c.getHp() - 2);
		
		int num = Common.getRandum(2);
		// 1/2の確率でキャラクターをまひ状態にする
		if (num == 1) {
			if (!c.getStatuslist("まひ")) {
				c.setStatuslist("まひ");
				System.out.println(c.getFreename() + "は【状態異常：まひ】になった。");
			}
		}
		
	}
}
