package WEEKtwo;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.Annotation;

@myDEMO(age = 22, id = 1, author = "沈成")
public class AnnotationDEMO {

	@typedefinite(db_type = "name", length = 10)
	public String name;
	@typedefinite(db_type = "student_id", length = 5)
	public int id;
	@typedefinite(db_type = "student_age", length = 2)
	public int age;
	
	
	@Override
	@mymethodDEMO(retype = "String",competence = 1)
	public String toString() {
		return "AnnotationDEMO [name=" + name + ", id=" + id + ", age=" + age + "]";
	}


	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		Class<?> c = AnnotationDEMO.class;
		Field fields = c.getDeclaredField("age");	
		java.lang.annotation.Annotation[] annos = fields.getAnnotations();
		for (int i = 0; i < annos.length; i++) {
			
			System.out.println(annos[i]);
		}
		Method toM = c.getMethod("toString");
		if (toM.isAnnotationPresent(mymethodDEMO.class)) {
			mymethodDEMO mda = null;
			mda = toM.getAnnotation(mymethodDEMO.class);
			String retype = mda.retype();
			int com = mda.competence();
			System.out.println("返回类型为:"+retype);
			System.out.println("权限为:"+com);
		}
	}
}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface myDEMO {
	public int id();

	public int age();

	public String author();

}

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface mymethodDEMO {

	public int competence() default 1;

	public String retype() default "void";

}

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface typedefinite {
	public String db_type();
	
	public int length();

}