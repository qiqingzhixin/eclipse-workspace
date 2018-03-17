import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Common_components {
	JTextField jTextField;//单行文本
	JTextArea jTextArea;//多行文本
	JButton jButton;//按钮
	JLabel jLable;//标签
	JCheckBox jCheckBox;//复选框
	JRadioButton jRadioButton;//单选按钮
	JComboBox<String>jComboBox;//下拉列表
	JPasswordField jPasswordField;//密码框
	JPanel jPanel;//面板
	JTabbedPane jTabbedPane;//选项卡窗口
	JScrollPane jScrollPane;//滚动窗口
	JSplitPane jSplitPane;//拆分窗口
	JLayeredPane jLayeredPane;//分层窗口
	//常用布局
	FlowLayout flowLayout;//流布局
	BorderLayout borderLayout;//东南西北中
	CardLayout cardLayout;//卡片局部
	GridLayout gridLayout;//方格布局
	BoxLayout boxLayout;//盒式布局
	//setLayout(布局对象) 设置自己的布局以及控制组件在容器的位置
	public static void main(String []args) {
	}
}
