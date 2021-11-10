package payilagamPractices;

import java.util.*;

public class Date {

public static void main(String[] args) {
	
    Scanner in = new Scanner(System.in);
    
    System.out.println("Format: DD/MM/YY");
    
    String date = in.next();
    
//	System.out.println(date);
	
	String[] arr = date.split("/");

	int day = findDay(arr[0]);
	
	int month = findMonth(arr[1], arr[2]);
	
	int year = findYear(arr[2]);
	
	//System.out.println(day);
	
	//System.out.println(month);
	
	//System.out.println(year);
	
	int ans = (day + month + year) % 7;
	
	switch(ans){
	    
	    case 0:System.out.println("Sunday");
	           break;
	    case 1:System.out.println("Monday");
	           break;
	    case 2:System.out.println("Tuesday");
	           break;
	    case 3:System.out.println("Wednesday");
	           break;
	    case 4:System.out.println("Thursday");
	           break;
	    case 5:System.out.println("Friday");
	           break;
	    case 6:System.out.println("saturday");
	           break;		           
	}
	
	
}

static int findDay(String d){
    
    int day = 0;
   
    for(int i=0;i < d.length();i++){
        
        day = (day * 10) + (d.charAt(i) - 48);
    }
    
    return day % 7;
}

static int findMonth(String m, String y){
    
    int month = 0; 
   
    for(int i=0;i < m.length();i++){
        
        month = (month * 10) + (m.charAt(i) - 48);
    }
    
    int[] arr = {3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3};
    
    int  ans = 0;
    
    for(int i=0;i<arr.length;i++) {
        
        if((i + 1) < month ){
            
            ans = ans + arr[i];
        }
    }
    
    if(findLeap(y)){
        
        ans += 1;
    }
   
    return ans % 7;
}

static int findYear(String y){
    
    int year = 0, ans = 0, leap = 0, notLeap = 0;
   
    for(int i=0;i < y.length();i++){
        
        year = (year * 10) + (y.charAt(i) - 48);
    }
    year = year - 1;
    
    if(year > 1600 && year < 2000){
        
        for(int i=year;i>1600;i--){
            
            if(findLeap(i)){
                
               leap += 1;
               
            }else{
                
                notLeap += 1;
            }
        }
        
        ans = (leap * 2) + notLeap;	        
    }
    
    if(year >= 2000){
        
        for(int i=year;i>2000;i--){
            
            if(findLeap(i)){
                
               leap += 1;
               
            }else{
                
                notLeap += 1;
            }
        }
        
        ans = (leap * 2) + notLeap;
    }
    
    return ans % 7;	    
}

static boolean findLeap(String y){
    
    int year = 0;
   
    for(int i=0;i < y.length();i++){
        
        year = (year * 10) + (y.charAt(i) - 48);
    }
    
    if(year % 4  == 0 && year % 100 != 0 || year % 400 == 0){
        
        return true;
    }
    
    return false;
}

static boolean findLeap(int y){
    
    if(y % 4  == 0 && y % 100 != 0 || y % 400 == 0){
        
        return true;
    }
    
    return false;
}

}
