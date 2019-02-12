/**
 * 
 */
package com.hanjia.javabase.chapter8.guessdemo;

import java.util.Scanner;

/**
 * @author 何禧煜
 * @TODO游戏房间类
 */
public class GameRoom {
	
	//属性：记分牌，道具，参与游戏的玩家，房间号，房间名称，密码
	
	//private String weapon;
	private HumanPlayer player1 = null;
	private ComPlayer player2 = null;
	private int roomId;//房间id
	private String roomName;//房间名称
	private String roomPass;//房间密码
	
	//方法：开始游戏，初始化游戏，显示菜单，选择人物，判断输赢（可定义在裁判类）
	
	public void initGame() {
		
		//1.实例化玩家对象
		
		player1 = new HumanPlayer();
		player2 = new ComPlayer();
		
		//2.初始化游戏其他属性：花花草草...
		
		for (int i = 0; i < 30; i++) {
			System.out.print("*");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("游戏加载成功！");
	}
	public void startGame() {
		showMenu();
		choiceRole();
		
		gaming();
	}
	/**
	 * 游戏的大循环
	 */
		private void gaming() {
			while(true)
			{
				//双方出拳
				//玩家1出拳
				
				System.out.println(player1.getName()+"请出拳：");
				player1.setFist(new Scanner(System.in).nextInt());
				int fist1 = player1.getFist();
				
				//玩家2出拳
				
				player2.getFist();
				int fist2 = player2.getFist();
				
				//判断输赢
				//如果返回-1，玩家1胜利
				//如果返回0，平局
				//如果返回1，玩家2胜利
				
				int result = judge(fist1,fist2);//调用方法判断结果
				if(result == -1) {
					System.out.println("【吉永老师】："+ player1.getName()+"胜利！");
					player1.sendMessage(HumanPlayer.MessageTypeWin);
					player2.sendMessage(ComPlayer.MessageTypeLose);
				}
				else if( result == 1) {
					System.out.println("【吉永老师】："+ player2.getName()+"胜利！");
					player1.sendMessage(HumanPlayer.MessageTypeLose);
					player2.sendMessage(ComPlayer.MessageTypeWin);
				}
				else {
					System.out.println("【吉永老师】：双方打平！");
					player1.sendMessage(HumanPlayer.MessageTypeFist);
					player2.sendMessage(ComPlayer.MessageTypeFist);
				}
				System.out.print("是否继续游戏？");
				String answer = new Scanner(System.in).next();
				if(!"y".equalsIgnoreCase(answer)) {
					break;
				}
				//打印结果
			}
		}
	public void showMenu() {
		System.out.println("欢迎进入 《"+roomName+"》 游戏房间");
		System.out.println("出拳规则：1-剪刀；2-布；3-石头");
	}
	public void choiceRole() {
		System.out.println("对方角色：1-风间；2-妮妮；3-正男；4-阿呆");
		System.out.println("请选择：");
		int choice = new Scanner(System.in).nextInt();
		String[]nameArray = {"风间","妮妮","正男","阿呆"};
		player2.setName(nameArray[choice - 1]);
		player1.setName("野原新之助");
		System.out.println(player1.getName()+"VS"+player2.getName());
	}
	/**
	 * 	如果返回-1，玩家1胜利
		如果返回0，平局
		如果返回1，玩家2胜利
	 * @param fist1
	 * @param fist2
	 * @return
	 */
	public int judge(int fist1,int fist2) {
		if(fist1 == fist2) return 0;//平局
		if(fist1 == 1 && fist2 == 3 || fist1 == 2 && fist2 == 1 || fist1 == 3 && fist2 == 2) { //玩家1获胜
			player1.setScore(player1.getScore() + 1);
			player2.setScore(player2.getScore() - 1);
			return -1;
		}
		player1.setScore(player1.getScore() - 1);
		player2.setScore(player2.getScore() + 1);
		return 1;//玩家2获胜
	}
	
	public void endGame() {
		System.out.println(player1.getName()+"\t"+player2.getName());
		System.out.println(player1.getScore()+"\t\t"+player2.getScore());
		System.out.println("游戏结束");
	}
	
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomPass() {
		return roomPass;
	}
	public void setRoomPass(String roomPass) {
		this.roomPass = roomPass;
	}
	
	
	
	
	public GameRoom(String roomName,String roomPass) {
		if(!("guess".equals(roomName) && "445".equals(roomPass))) {
			System.out.println("房间密码与号码不匹配，强制退出");
			return;
		}
		this.setRoomName(roomName);
		initGame();
		startGame();
		endGame();
	}
	
	
}
