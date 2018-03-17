import javax.swing.JButton;
import javax.swing.JFrame;

public class Game_Ui {
	public static void main(String[] args) {
		Game game=new Game(30);
	}
}
class  Game{
	private int n,m;//n代码扫雷的长度的个数，m是雷的数量
	private int Button_length=30;//扫雷块的大小
	private int map_length,map_wight;
	private JButton[][] map;
	private JFrame jf;
	
	public Game(int n) {
		jf=new JFrame("扫雷");
	}
	private void jf_main() {
		jf=new JFrame("扫雷");
		jf.setVisible(true);
	}
}