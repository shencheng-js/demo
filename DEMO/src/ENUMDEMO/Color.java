package ENUMDEMO;

public enum Color implements Print{
	RED("红色"),GREEN("绿色"),BLUE("蓝色");
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Color(String name) {
		this.name = name;
	}

	@Override
	public String getColor() {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
interface Print{
	public String getColor();
}