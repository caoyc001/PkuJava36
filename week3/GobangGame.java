import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo(posX,posY);
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo(int posX,int posY) {
		String [][] jboard=this.chessboard.getBoard();
		int flag1=1,flag2=1,num1,num2,num3,num4;
			
		while(true)
		{      num1=flag1+flag2;
		     if((posX+flag1)<22)
			if(jboard[posX+flag1][posY]==jboard[posX][posY])
			{ flag1++;   
		
			}
		     if((posX-flag2)>=0)
		     if(jboard[posX-flag2][posY]==jboard[posX][posY])
		         flag2++;
		      
			    
		      if(num1==(flag1+flag2))
		       break;
		}
		
		while(true)
		{      num2=flag1+flag2;
		     if((posY+flag1)<22)
			if(jboard[posX][posY+flag1]==jboard[posX][posY])
			{ flag1++;   
			
			}
		      if((posY-flag2)>=0)
		       if(jboard[posX][posY-flag2]==jboard[posX][posY])
		         flag2++;
		     
			  
		      if(num2==(flag1+flag2))
		       break;
		}
		while(true)
		{      num3=flag1+flag2;
		if((posY+flag1)<22&&(posX+flag1)<22)
			if(jboard[posX+flag1][posY+flag1]==jboard[posX][posY])
			{ flag1++;   
		
			}
		if((posY-flag2)>=0&&(posX-flag2)>0)     
		if(jboard[posX-flag2][posY-flag2]==jboard[posX][posY])
		         flag2++;
		      
			    
		      if(num3==(flag1+flag2))
		       break;
		}
		while(true)
		{      num4=flag1+flag2;
		if((posY-flag1)>=0&&(posX+flag1)<22)
			if(jboard[posX+flag1][posY-flag1]==jboard[posX][posY])
			{ flag1++;   
		
			}
		if((posX-flag2)>=0&&(posY+flag2)<22)
		       if(jboard[posX-flag2][posY+flag2]==jboard[posX][posY])
		         flag2++;
		 if(num4==(flag1+flag2))
		       break;
		}
		int x=1,y=1;
		if((num1>=num2)&&(num1>=num3)&&(num1>=num4))
		{x = posX+1;
		 y =posY;
		String[][] board = chessboard.getBoard();
		while (board[x][y] != "十") {
			x++;
			
		}
		}
		x=y=1;
		if((num2>=num1)&&(num2>=num4)&&(num2>=num3))
		{x = posX;
		 y =posY+1;
		String[][] board = chessboard.getBoard();
		while (board[x][y] != "十") {
		y++;
		}
		}
		int[] result = { x, y };
		return result;
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		String [][] jboard=this.chessboard.getBoard();
		int flag1=1,flag2=1,num;
			
		while(true)
		{      num=flag1+flag2;
		     if((posX+flag1)<22)
			if(jboard[posX+flag1][posY]==jboard[posX][posY])
			{ flag1++;   
		
			}
		     if((posX-flag2)>=0)
		     if(jboard[posX-flag2][posY]==jboard[posX][posY])
		         flag2++;
		      if( (flag1+flag2-1)>=5)
			    return true;
		      if(num==(flag1+flag2))
		       break;
		}
		flag1=1;flag2=1;
		while(true)
		{      num=flag1+flag2;
		     if((posY+flag1)<22)
			if(jboard[posX][posY+flag1]==jboard[posX][posY])
			{ flag1++;   
			
			}
		      if((posY-flag2)>=0)
		       if(jboard[posX][posY-flag2]==jboard[posX][posY])
		         flag2++;
		      if( (flag1+flag2-1)>=5)
			    return true;
		      if(num==(flag1+flag2))
		       break;
		}
		flag1=1;flag2=1;
		while(true)
		{      num=flag1+flag2;
		if((posY+flag1)<22&&(posX+flag1)<22)
			if(jboard[posX+flag1][posY+flag1]==jboard[posX][posY])
			{ flag1++;   
		
			}
		if((posY-flag2)>=0&&(posX-flag2)>0)     
		if(jboard[posX-flag2][posY-flag2]==jboard[posX][posY])
		         flag2++;
		      if( (flag1+flag2-1)>=5)
			    return true;
		      if(num==(flag1+flag2))
		       break;
		}
		flag1=1;flag2=1;
		while(true)
		{      num=flag1+flag2;
		if((posY-flag1)>=0&&(posX+flag1)<22)
			if(jboard[posX+flag1][posY-flag1]==jboard[posX][posY])
			{ flag1++;   
		
			}
		if((posX-flag2)>=0&&(posY+flag2)<22)
		       if(jboard[posX-flag2][posY+flag2]==jboard[posX][posY])
		         flag2++;
		      if( (flag1+flag2-1)>=5)
			    return true;
		      if(num==(flag1+flag2))
		       break;
		}
		
		
			return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
