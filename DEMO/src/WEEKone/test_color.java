package WEEKone;


public class test_color {
	public static void main(String[] args) {
		Color c = Color.BLUE;
		//System.out.println(c);
		for (Color string : Color.values()) {
			System.out.println(string.ordinal()+" "+string.name());
			print(string);
		}
	
	}
	public static void print(Color color) {
		switch(color) {
			case RED:{
				System.out.println("这是红色");
				break;
			}
			case BLUE:{
				System.out.println("这是蓝色");
				break;
			}
			case GREEN:{
				System.out.println("这是绿色");
				break;
			}
			default:{
				System.out.println("这是啥子颜色哦");
				break;
			}
		}
	}
}
