

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
		new GUI(MyClassLoader.loadOperators(System.getProperty("user.dir") + "\\bin"));
	}

}
