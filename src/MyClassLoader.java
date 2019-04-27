package reflection;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class MyClassLoader {

	@SuppressWarnings("rawtypes")
	public ArrayList<Class> loadOperators(File operatorFile) throws MalformedURLException, ClassNotFoundException {
		
		@SuppressWarnings("resource")
		ClassLoader operatorsLoader = new URLClassLoader(new URL[] { operatorFile.toURI().toURL() });

		File[] files = operatorFile.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".class");
			}
		});

		ArrayList<Class> operators = new ArrayList<>();
		for (File file : files) {
			String className = file.getName().substring(0, file.getName().length() - 6);
			Class<?> clazz = operatorsLoader.loadClass("classes." + className);
			operators.add(clazz);
		}
		
		return operators;
	}
}
