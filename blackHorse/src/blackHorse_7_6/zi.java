package blackHorse_7_6;

public class zi extends Fu {
	int num = 100;

	public void prinT() {
		num += 10;
		System.out.println(super.num + "   " + num);
	}

	public static void main(String[] args) {
		String s1 = "my";
		String s2 = "my";
		String s3 = new String("my");
		String s4 = new String("my");
		// System.out.println(s2 .equals(s4));
		StringBuffer aBuffer = new StringBuffer();
		aBuffer.append("shencheng");
		for (int i = 0; i < 10; i++) {
			aBuffer.append(i);

		}
//		System.out.println(aBuffer);
		String string1 =new String("192.168.1.3");
		String []result = string1.split("");
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
			
		}
		
		/*
		Runtime aRun = Runtime.getRuntime();
		
		Process aProcess = null;
		try {
			aProcess = aRun.exec("notepad.exe");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		aProcess.destroy();
		*/
	}
}
