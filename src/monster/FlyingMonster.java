package monster;

public abstract class FlyingMonster extends Monster {
	
	public FlyingMonster (String name, int hp, String keyName) {
		super(name, hp, keyName);
	}
	
//	逃げるメソッド
	public void run() {
		System.out.println("バサバサ飛んで逃げた...");
	};

}
