/**
 * 
 */
package com.hanjia.javabase.chapter8.guessdemo;

/**
 * @author 何禧煜
 * @TODO人类玩家
 */
public class HumanPlayer {
	//静态常量：出拳时的信息
	public static final int MessageTypeFist = 1;
	//静态变量：赢得出拳时的信息
	public static final int MessageTypeWin = 2;
	//静态变量：输了出拳时的信息
	public static final int MessageTypeLose = 3;
	
	//人类玩家的属性：名称，分数，说出的拳，（角色对应的音效），角色的台词
	private String name;
	private int score;
	private int fist;
	
	//角色所说的台词
	private String[] fistWords = {
			"动感光波~biubiubiu~~~",
			"大象大象你的鼻子为什么这么长~~",
			"必杀：露pp外星人~~~",
			"大姐姐你喜欢吃青椒吗？",
			"胸部扁扁的欧巴桑吃我一拳"
	};
	private String[] WinWords = {
			"还有谁~~",
			"猜拳，有点意思~~",
			"全军出击~~~！！！",
			"~~~超~~~神~~~",
			"吃着火锅唱着歌，然后你就输了~"
	};
	private String[] LoseWords = {
			"通过成功的路总在施工中...",
			"等到潮水退去，就知道谁在裸泳了...",
			"将来我死了，要把QQ捐给希望工程，我让孩子们一上来就能用带太阳的QQ...",
			"夏天就是不好，穷的时候我连西北风都没得喝...",
			"众人皆醉我独醒，举世皆浊我独清..."
	};
	//人类玩家的方法：设置和得到名称，分数，播放音效，说个性台词，出拳
	/**
	 * 根据传入的消息类型，随即打印对应的消息
	 * @param msgType 对应HumanPlayer类中定义的静态常量
	 */
	public  void sendMessage(int msgType) {
		//生成一个0~4之间的随机数字
		int index = ((int)Math.random()*1000) % 5;
		String message = null;//要打印的消息
		switch (msgType) {
		case MessageTypeFist:
			message = fistWords[index];
			break;
		case MessageTypeWin:
			message = WinWords[index];
			break;
		case MessageTypeLose:
			message = LoseWords[index];
			break;
		}
		System.out.println(message);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getFist() {
		return fist;
	}
	public void setFist(int fist) {
		this.fist = fist;
	}
}
