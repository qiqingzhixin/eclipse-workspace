package one;

import java.awt.event.ActionEvent;    
import java.awt.event.ActionListener;    
import java.awt.event.MouseEvent;    
import java.awt.event.MouseListener;    
    
import javax.swing.JButton;    
import javax.swing.JFrame;    
import javax.swing.JLabel;    
    
  
public class Game extends JFrame implements ActionListener, Runnable,    
        MouseListener {     
    private final int loEMPTY         = 0;    
    private final int loMINE          = 1;    
    private final int loCHECKED       = 2;    
    private final int loMINE_COUNT    = 10;   
    private final int loBUTTON_BORDER = 50;    
    private final int loMINE_SIZE     = 10;   
    private final int loSTART_X       = 20;     
    private final int loSTART_Y       = 50;     
    
    private boolean flag;    
    private JButton[][] jb;    
    private JLabel jl;    
    private JLabel showTime;    
    private int[][] map;    
  
    private int[][] mv = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 },    
            { 1, -1 }, { 0, -1 }, { -1, -1 } };    
  
    public void makeloMINE() {    
        int i = 0, tx, ty;    
        for (; i < loMINE_COUNT;) {    
            tx = (int) (Math.random() * loMINE_SIZE);    
            ty = (int) (Math.random() * loMINE_SIZE);    
            if (map[tx][ty] == loEMPTY) {    
                map[tx][ty] = loMINE;    
                i++;   
            }    
        }    
    }    
    
  
    public void makeButton() {    
        for (int i = 0; i < loMINE_SIZE; i++) {    
            for (int j = 0; j < loMINE_SIZE; j++) {    
                jb[i][j] = new JButton();    
                jb[i][j].addActionListener(this);    
                jb[i][j].addMouseListener(this);    
    
                jb[i][j].setName(i + "_" + j);   
  
                jb[i][j].setBounds(j * loBUTTON_BORDER + loSTART_X, i    
                        * loBUTTON_BORDER + loSTART_Y, loBUTTON_BORDER, loBUTTON_BORDER);    
                this.add(jb[i][j]);    
            }    
        }    
    }    
    
    public void init() {    
    
        flag = false;    
    
        jl.setText("��ӭ���ԣ�һ����" + loMINE_COUNT + "����");    
        jl.setVisible(true);    
        jl.setBounds(20, 20, 500, 30);    
        this.add(jl);    
    
        showTime.setText("����ʱ��0 ��");    
        showTime.setBounds(400, 20, 100, 30);    
        this.add(showTime);    
    
        makeloMINE();  //����  
        makeButton();  //��ť�¼�  
        this.setSize(550, 600);    
        this.setLocation(700, 100);    
        this.setResizable(false);    
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    
        this.setVisible(true);    
    }    
    
    public Game(String title) {    
        super(title);    
    
        this.setLayout(null);   //��ʹ�ò��ֹ�������ÿ���ؼ���λ����setBounds�趨    
            
        jb = new JButton[loMINE_SIZE][loMINE_SIZE];    
        jl = new JLabel();    
        showTime = new JLabel();    
        map = new int[loMINE_SIZE][loMINE_SIZE]; // ����ťӳ�䵽������    
    }    
    
    public static void main(String[] args) {    
        Game test = new Game("Hello loMINEr!");    
        test.init();    
        test.run();    
    }    
    
    @Override    
    public void actionPerformed(ActionEvent e) {    
    
        Object obj = e.getSource();    
        int x, y;    
        if ((obj instanceof JButton) == false) {    
            showMessage("����", "�ڲ�����");    
            return;    
        }    
        String[] tmp_str = ((JButton) obj).getName().split("_");    
        x = Integer.parseInt(tmp_str[0]);    
        y = Integer.parseInt(tmp_str[1]);    
    
        if (map[x][y] == loMINE) {    
            showMessage("����", "��ȵ�������~~~");    
            flag = true;    
            showloMINE();    
            return;    
        }    
        dfs(x, y, 0);    
    
        checkSuccess();    
    }    
    
   
    private void checkSuccess() {    
        int cnt = 0;    
        for (int i = 0; i < loMINE_SIZE; i++) {    
            for (int j = 0; j < loMINE_SIZE; j++) {    
                if (jb[i][j].isEnabled()) {    
                    cnt++;    
                }    
            }    
        }    
        if (cnt == loMINE_COUNT) {    
            String tmp_str = showTime.getText();    
            tmp_str = tmp_str.replaceAll("[^0-9]", "");    
            showMessage("ʤ��", "����ɨ�׹���ʱ��" + tmp_str + "��");    
            flag = true;    
            showloMINE();    
        }    
    }    
    
    private int dfs(int x, int y, int d) {    
        map[x][y] = loCHECKED;    
        int i, tx, ty, cnt = 0;    
        for (i = 0; i < 8; i++) {    
            tx = x + mv[i][0];    
            ty = y + mv[i][1];    
            if (tx >= 0 && tx < loMINE_SIZE && ty >= 0 && ty < loMINE_SIZE) {    
                if (map[tx][ty] == loMINE) {    
                    cnt++;  
                } else if (map[tx][ty] == loEMPTY) {    
                    ;    
                } else if (map[tx][ty] == loCHECKED) {    
                    ;    
                }    
            }    
        }    
        if (cnt == 0) {    
            for (i = 0; i < 8; i++) {    
                tx = x + mv[i][0];    
                ty = y + mv[i][1];    
                if (tx >= 0 && tx < loMINE_SIZE && ty >= 0 && ty < loMINE_SIZE    
                        && map[tx][ty] != loCHECKED) {    
                    dfs(tx, ty, d + 1);    
                }    
            }    
        } else {    
            jb[x][y].setText(cnt + "");    
        }    
        jb[x][y].setEnabled(false);    
        return cnt;    
    }    
  
    private void showMessage(String title, String info) {    
        jl.setText(info);    
        System.out.println("in functino showMessage()  :  " + info);    
    }    
    
    public void run() {    
        int t = 0;    
        while (true) {    
            if (flag) {    
                break;    
            }    
            try {    
                Thread.sleep(1000);    
            } catch (InterruptedException e) {    
                e.printStackTrace();    
            }    
            t++;    
            showTime.setText("����ʱ��" + t + " ��");    
        }    
    }    
    
    private void showloMINE() {    
        for (int i = 0; i < loMINE_SIZE; i++) {    
            for (int j = 0; j < loMINE_SIZE; j++) {    
                if (map[i][j] == loMINE) {    
                    jb[i][j].setText("��");     
                }    
            }    
        }    
    }    
   
    public void mouseClicked(MouseEvent e) {    
        if (e.getButton() == 3) {    
            Object obj = e.getSource();    
            if ((obj instanceof JButton) == false) {    
                showMessage("����", "�ڲ�����");    
                return;    
            }    
            String[] tmp_str = ((JButton) obj).getName().split("_");    
            int x = Integer.parseInt(tmp_str[0]);    
            int y = Integer.parseInt(tmp_str[1]);    
        if ("{1}quot".equals(jb[x][y].getText())) {    
                jb[x][y].setText("");    
            } else {    
                jb[x][y].setText("{1}quot");    
            }    
        }    
    }    
    
      
    public void mousePressed(MouseEvent e) {    
          
    
    }    
    
    @Override    
    public void mouseReleased(MouseEvent e) {    
         
    
    }    
    
       
    public void mouseEntered(MouseEvent e) {    
          
    }    
    
    @Override    
    public void mouseExited(MouseEvent e) {    
           
    
    }    
}    