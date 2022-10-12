package fr.bankcommon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Main {
	
public int getListInteger(){
	
	List<Integer> list=Arrays.asList(1,5,6,11,85,6,4,9,2,9,45);
	int sum= list.stream().reduce(0, Integer::sum);
	int sum2 = list.stream().mapToInt(i->i.intValue()).filter(i->(i%2==0)).sum();
	return sum;
}

public static void  main(String[] args) {
  //int result= computeJoinPoint(12547,12563);
  //System.out.println(result);
	int result= count(10000);
	System.out.println(result);
}


public static int count(int n) {
	 
	int result=0;
	for (int i=0;i<n;i++) {
		for(int j=i+1;j<n;j++) {
			 result++;
		}
	}
   return	result;
}
public boolean isInteger( String s) {
	
	boolean result=false;
	try {
	if(Integer.valueOf(s) instanceof Integer) {
		result =true;
		
	}
	}catch(NumberFormatException ex) {
		result =false;
	}
	return result;
}
  public List<String> getListString(){
	  
	   String str="Item1 10 Item2 25 Item3 30 Item4 45";
	   
	   String[] strs= str.split(" ");
	   
	   List<String> list= Arrays.asList(strs);
	   List<String>  result= list.stream().filter(s->this.isInteger(s)).collect(Collectors.toList());
int sum	=result.stream().mapToInt(s->Integer.valueOf(s).byteValue()).sum();
System.out.println(sum);
	   return result;
  }
  
  public static int entierPrice(double price) {
	  int priceArrondi= (int) price;
	  return priceArrondi;
  }
  
  
  
  public static int computeJoinPoint(int s1,int s2) {
	   int s=0;
	  if(s1 > 0 && s2 >0) {
		  while((s1!=s2) && s1<20000000 && s2<20000000) {
			  s1= nextNumber(s1);
			  s2 = nextNumber(s2);
			  
		  }
		  System.out.println(s1 +" "+s2);
		  if(s1==s2) {
			  s=s1;
		  }else {
			  s=0;
		  }
	  }
	  return s;
  }
  
  
  public static int nextNumber(int i) {
	
	  int s=i;
	  int sum = sumOfNumber(i);
	  s=s+sum;
	  return s;
  }

 public static int sumOfNumber(int value) {
        String str= String.valueOf(value);
        int result=0;
        for(int i=0;i<str.length();i++) {
        	
        	String strResult=String.valueOf(str.charAt(i));
        	result=result+Integer.valueOf(strResult).intValue();
        }
	 return result;
} 
  	
	
}
