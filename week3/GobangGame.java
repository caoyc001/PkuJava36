import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo(posX,posY);
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
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
		while (board[x][y] != "ʮ") {
			x++;
			
		}
		}
		x=y=1;
		if((num2>=num1)&&(num2>=num4)&&(num2>=num3))
		{x = posX;
		 y =posY+1;
		String[][] board = chessboard.getBoard();
		while (board[x][y] != "ʮ") {
		y++;
		}
		}
		int[] result = { x, y };
		return result;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
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
