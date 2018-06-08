package com.techlabs.classreflactordetails;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassReflectorDetails {
	private Class<?> classVar;
	private Method[] methods;
	private Field[] fields;
	private Constructor<?>[] constructors;

	public ClassReflectorDetails(Class<?> pclass) {
		classVar = pclass;
	}

	public Class<?> getClassVar() {
		return classVar;
	}

	public void setClassVar(Class<?> pclass) {
		classVar = pclass;
	}
	
	@needRefactory
	private boolean isGetterMethod(Method method) {
		if (method.getName().startsWith("get")
				&& method.getParameterCount() >= 0
				&& !method.getReturnType().equals(Void.TYPE)) {
			return true;
		} else {
			return false;
		}
	}
	
	@needRefactory
	private boolean isSetterMethod(Method method) {
		if (method.getName().startsWith("set")
				&& method.getParameterCount() == 1
				&& method.getReturnType().equals(Void.TYPE)) {
			return true;
		} else {
			return false;
		}
	}

	public int countAllFields() {
		fields = classVar.getDeclaredFields();
		return fields.length;
	}

	@needRefactory
	public int countAllPrivateFields() {
		fields = classVar.getDeclaredFields();
		int count = 0;
		for (Field field : fields) {
			if (Modifier.isPrivate(field.getModifiers())) {
				count++;
			}
		}
		return count;
	}

	public int countAllPublicFields() {
		fields = classVar.getDeclaredFields();
		int count = 0;
		for (Field field : fields) {
			if (Modifier.isPublic(field.getModifiers())) {
				count++;
			}
		}
		return count;
	}

	public int countAllMethods() {
		methods = classVar.getDeclaredMethods();
		return methods.length;
	}

	public int countAllPublicMethods() {
		methods = classVar.getDeclaredMethods();
		int count = 0;
		for (Method method : methods) {
			if (Modifier.isPublic(method.getModifiers())) {
				count++;
			}
		}
		return count;
	}

	public int countAllPrivateMethods() {
		int count = 0;
		methods = classVar.getDeclaredMethods();
		for (Method method : methods) {
			if (Modifier.isPrivate(method.getModifiers())) {
				count++;
			}
		}
		return count;
	}

	public int countAllGetterMethods() {
		int count = 0;
		methods = classVar.getDeclaredMethods();
		for (Method method : methods) {
			if (isGetterMethod(method)) {
				count++;
			}
		}
		return count;
	}

	public int countAllSetterMethods() {
		int count = 0;
		methods = classVar.getDeclaredMethods();
		for (Method method : methods) {
			if (isSetterMethod(method)) {
				count++;
			}
		}
		return count;
	}

	public int countAllConstructor() {
		constructors = classVar.getDeclaredConstructors();
		return constructors.length;
	}
	
	public int countAllNeedRefactoryAnnotations() {
		methods =  classVar.getDeclaredMethods();
		int count =0;
		for (Method method	:	methods){
			if(method.isAnnotationPresent(needRefactory.class)){
				//System.out.println(method.getName());
				count++;
			}
		}
		return count;
	}
}