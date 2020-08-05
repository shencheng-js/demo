package WEEKone;

public interface Hello {
	public void speakhello();
	default  void speakbye() {
		System.out.println("byebye!");
	}
}
class tv implements Hello{

	@Override
	public void speakhello() {
		// TODO 自动生成的方法存根
		System.out.println("欢迎使用电视机");
	}
	public void speakbye() {
		System.out.println("欢迎下次看电视!");
	}
}
class phone implements Hello{

	@Override
	public void speakhello() {
		// TODO 自动生成的方法存根
		System.out.println("欢迎使用手机");
	}
	
}
