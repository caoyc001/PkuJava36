
public class ChessWeightValue {
	public int[][][] blacktable;
	public int[][][] whitetable;
	
	public ChessWeightValue(int BOARD_SIZE)
	{
		//区分横竖斜四种
		blacktable= new int[BOARD_SIZE][BOARD_SIZE][4];
		whitetable= new int[BOARD_SIZE][BOARD_SIZE][4];
		for(int i=0;i<22;i++)
		{
			for(int j=0;j<22;j++)
			{
				whitetable[i][j][0]=2;
				blacktable[i][j][0]=2;
			}
		}
	}
	
	public int[] getNext(int posX,int posY){
		int best=-1;
//		System.out.println("add white");
		for(int i=0;i<21;i++)
		{
			for(int j=0;j<21;j++)
			{
				//这里的权值应该是分别计算4个方向然后再求和
				//
				int curweight=whitetable[i][j][0]+blacktable[i][j][0];
				if(best<(curweight))
				{
					best=curweight;
					posX=i;
					posY=j;
				}
				if(best==curweight)
				{
//					System.out.println("i"+i);
//					System.out.println("j"+j);
//					System.out.println("posx"+posX);
//					System.out.println("posy"+posY);
					
					//计算后优先度相同的点再计算一次优先级别
					if(Math.abs(i-10)+Math.abs(j-10)<Math.abs(posX-10)+Math.abs(posY-10))
					{
						posX=i;
						posY=j;
					}
				}
			}
		}
//		int posX=1,posY=1;
//		System.out.println("add white");
		for(int i=Math.max(posX-1, 1);i<Math.min(posX+1, 21);i++)
		{
			
			for(int j=Math.max(posY-1, 1);i<Math.min(posY+1, 21);i++)
			{
				System.out.println(i);
				System.out.println(j);
				whitetable[i][j][0]*=8;
			}

		}
		whitetable[posX][posY][0]=0;
		blacktable[posX][posY][0]=0;
//		System.out.println("posX"+posX);
//		System.out.println("posY"+posY);
		int[] result = { posX, posY };
		
		return result;
	}
	
	public void addBlackValue(int posX,int posY)
	{
//		System.out.println("add black");
//		System.out.println("posx:"+posX);
//		System.out.println(Math.max(posX-1, 0));
//		System.out.println(Math.min(posX+1, 20));
//		System.out.println("posy:"+posY);
		for(int i=Math.max(posX-1, 0);i<=Math.min(posX+1, 20);i++)
		{
//			System.out.println("i :"+i);
			for(int j=Math.max(posY-1, 0);j<=Math.min(posY+1, 20);j++)
			{
				
//				System.out.println("j :"+j);
				blacktable[i][j][0]*=2;
			}
		}
		blacktable[posX][posY][0]=0;
	}

}
