package WEEKtwo;

public class ClassLoaderDEMO2 {

	public static void main(String[] args) throws ClassNotFoundException {
		 ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		 System.out.println(systemClassLoader);
		 
		 ClassLoader parent = systemClassLoader.getParent();
		 System.out.println(parent);
		 
		 ClassLoader parent1 = parent.getParent();
		 System.out.println(parent1);
		 
		 ClassLoader classLoader = Class.forName("WEEKtwo.Person").getClassLoader();
		 System.out.println(classLoader);
		 
		 //ClassLoader classLoader1 = Class.forName("java.lang.object").getClassLoader();
		 //System.out.println(classLoader1);
		 
		 
		 System.out.println(System.getProperty("java.class.path"));
		 
		 /*
		  * 
		  * 
		  * 
		  * 
		  * 
		  * 
		  C:\Users\Administrator\eclipse-workspace\DEMO\bin;
		  C:\Users\Administrator\eclipse\java-2019-12\eclips

		  * 
		  * 
		  * 
		  */
	}
}
