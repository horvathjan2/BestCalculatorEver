import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class MyClassLoader {

	public static ArrayList<Class<?>> loadOperators(String dirName){
		ArrayList<Class<?>> operators = new ArrayList<>();
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
				if(Operation.class.isAssignableFrom(clazz) && !Modifier.isAbstract(clazz.getModifiers())){
					operators.add(clazz);
				}
			}
			operatorsLoader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operators;
	}
}
