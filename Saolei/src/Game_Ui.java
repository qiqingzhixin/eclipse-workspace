import javax.swing.JButton;
import javax.swing.JFrame;

public class Game_Ui {
	public static void main(String[] args) {
		Game game=new Game(30);
	}
}
class  Game{
	private int n,m;//n����ɨ�׵ĳ��ȵĸ�����m���׵�����
	private int Button_length=30;//ɨ�׿�Ĵ�С
	private int map_length,map_wight;
	private JButton[][] map;
	private JFrame jf;
	
	public Game(int n) {
		jf=new JFrame("ɨ��");
	}
	private void jf_main() {
		jf=new JFrame("ɨ��");
		jf.setVisible(true);
	}
}