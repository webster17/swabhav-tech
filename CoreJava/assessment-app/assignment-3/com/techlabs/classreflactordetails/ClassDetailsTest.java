package com.techlabs.classreflactordetails;

public class ClassDetailsTest {
	public static void main(String args[]) {
		//Class<ClassDetails> c = ClassDetails.class;
		ClassReflectorDetails classReflectorDetail = new ClassReflectorDetails(ClassReflectorDetails.class);
		printDetails(classReflectorDetail);
	}

	public static void printDetails(ClassReflectorDetails classReflectorDetail) {
		System.out.println("Total No's of Data Member: " + classReflectorDetail.countAllFields());
		System.out.println("Total No's of Private Data Member: " + classReflectorDetail.countAllPrivateFields());
		System.out.println("Total No's of Public Data Member: " + classReflectorDetail.countAllPublicFields());
		System.out.println("Total No's of Methods: " + classReflectorDetail.countAllMethods());
		System.out.println("Total No's of Get Methods: " + classReflectorDetail.countAllGetterMethods());
		System.out.println("Total No's of Set Method: "	+ classReflectorDetail.countAllSetterMethods());
		System.out.println("Total No's of Public Method: " + classReflectorDetail.countAllPublicMethods());
		System.out.println("Total No's of Private Method: " + classReflectorDetail.countAllPrivateMethods());
		System.out.println("Total No's of Constructor: " + classReflectorDetail.countAllConstructor());
		System.out.println("Total No's of Method with Annotations: " + classReflectorDetail.countAllNeedRefactoryAnnotations());
	}
}