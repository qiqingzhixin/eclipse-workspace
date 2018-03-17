import java.util.Date;

public class Main_one {
	public static void main(String[] args) {
		try {
			Class cs=Class.forName("Rect");//�õ�һ��Class��
			Rect rect=(Rect)cs.newInstance();
			rect.width=100;
			rect.height=200;
			System.out.println("rect�����"+rect.getArea());
			cs=Class.forName("java.util.Date");
			Date date=(Date) cs.newInstance();
			System.out.println(String.format("%tF %<tT %<tA",date));
			System.out.println(rect.getClass());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Rect{
	double width,height,area;
	public double getArea() {
		area=height*width;
		return area;
	}
}