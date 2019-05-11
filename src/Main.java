import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * @author Horváth János
 *
 * Main class that starts the application and loads operation classes
 */
public class Main {

	public static void main(String[] args) {
		new GUI(loadOperators(System.getProperty("user.dir") + "\\bin"));
	}
	
	/**
	 * @param dirName path to the directory containing operation classes
	 * @return all loaded classes that implement an operation interface
	 */
	@SuppressWarnings("unchecked")
	private static ArrayList<Class<Operation_0>> loadOperators(String dirName){
		ArrayList<Class<Operation_0>> operators = new ArrayList<>();
		try{
			File operatorFile = new File(dirName);
			URLClassLoader operatorsLoader = new URLClassLoader(new URL[] { operatorFile.toURI().toURL() });

			File[] files = operatorFile.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".class");
				}
			});
			
			
			for (File file : files) {
				String className = file.getName().substring(0, file.getName().length() - 6);
				Class<?> clazz = operatorsLoader.loadClass(className);
				if(Operation_0.class.isAssignableFrom(clazz) && !Modifier.isAbstract(clazz.getModifiers())){
					operators.add((Class<Operation_0>)clazz);
				}
			}
			operatorsLoader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operators;
	}
	
}
