package com.marianatavares.workshopspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopspringbootRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopspringbootRestapiApplication.class, args);
//		String[] test= {"co","de","ar","s"};
//		System.out.println(name(test));
//		
//		
//		
//	}
//	public static int name(String[] s) {
//		int total=0;
//		int max=0;
//		int size=0;
//		
//		
//			String name="";
//			name=s[0];
//			int j=0;
//			int z=0;
//			while(z<s.length) {
//				if(rule(totalString(s))) {
//					max=value(totalString(s));
//					size= totalString(s).length();
//					break;
//				}
//			z++;
//			j=0;
//			while(j<s.length) {
//				if(j!=0 && j!=z) {
//				name+=s[j];
//				}
//				j++;
//		}
//
//			if(rule(name)) {
//			total=value(name);
//			size=name.length();
//			if(total>max) {
//				max=total;
//			}
//			System.out.println(name);
//			name="";
//			}
//			}
//			
//		
//		
//		return size;
//	}
//	
//	public static int value(String s) {
//		int sum=0;
//		for(int i=0;i<s.length();i++) {
//			sum+=s.charAt(i)-96;
//		}
//		return sum;
//	}
//	public static boolean rule(String s) {
//		return value(s)<= 10*s.length();
//	}
//	
//	public static String totalString(String[] s) {
//		String sum="";
//	
//		for(int i=0;i<s.length;i++) {
//			sum+=s[i];
//	}
//		return sum;
//	
//	}
	}

}
