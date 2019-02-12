/**
 * 
 */
package com.hanjia.javabase.chapter8.guessdemo;

/**
 * @author 何禧煜
 * @TODO电脑玩家
 */
public class ComPlayer {

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
			"必杀：摇摇晃晃真拳",
			"像我这么帅的人就可以在床上赚钱",
			"给你一记左勾拳",
			"我叫你一声你敢答应吗？",
			"大王叫我来巡山咯！"
	};
	private String[] WinWords = {
			"子曾经曰过：什么什么什么，一板砖呼死你Y的！！",
			"真相只有一个，你已经死了",
			"抽，是一种生活艺术；找抽，是一种生活态度",
			"在这一刻"+name+"被灵魂附体，他不是一个人",
			"刚和我朋友下棋，他把我帅吃了；你想表达什么？，呵呵我帅死了"
	};
	private String[] LoseWords = {
			"人生求胜的秘诀，只有那些失败过的人才了若指掌。",
			"人生最大的光荣，不在于从不失败，而在于能屡仆屡起",
			"失败了，你可能会失望；但如果不去尝试，那么你注定要失败",
			"我主要关心的，不是你是不是失败了，而是你对失败是不是甘心。",
			"胜败兵家事不期，包羞忍耻是男儿 "
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
		//电脑的出拳实际上就是生成1~3的随机数字
		fist = ((int)(Math.random()* 3000)) % 3 + 1;
		return fist;
	}
	

}
