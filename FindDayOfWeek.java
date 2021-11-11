package allBasicQuestions;

import java.util.*;

public class FindDayOfWeek
{
	public static void main(String[] args) {
	    
	    Scanner in = new Scanner(System.in);
	    
	    System.out.println("Formats: DD-MM-YY:");
	    
	    String date = in.next();
	    
	    String ans = findDayOfWeek(date);
	    
	    System.out.println(ans);

	}

    static String findDayOfWeek(String date){
        
	    int[] arr = new int[3];
	    
	    String ans = ""; int k = 0;
	    
	    for(int i=0;i<date.length();i++){
	        
	        if(date.charAt(i) != '-' && date.charAt(i) != '/' &&  date.charAt(i) != ' '){
	            
	            ans = ans + date.charAt(i);
	        }
	        else{
	            
	            arr[k++] = Integer.parseInt(ans);
	            
	            ans = "";
	        }
	    }
	    
	    arr[k++] = Integer.parseInt(ans);

	    int day = arr[0] % 7;
	    
	    int month = findMonth(arr[1], arr[2]);
	    
	    int year = findYear(arr[2] - 1);
	    
	    int sum = (day + month + year) % 7;
	    
	    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    
	    return days[sum];
    } 
    
    static int findMonth(int month, int year){
        
        int[] arr = {3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3};
        
        int ans = 0;
        
        for(int i=0;i<arr.length;i++){
            
            if((i + 1) < month){
                
                ans += arr[i];
            }
        }
        
        if(isLeap(year)){
            
            ans += 1;
        }
        
        return ans % 7;
    }

    static int findYear(int year){
        
        int leap = 0, notLeap = 0;
        
        for(int i=year;i%400 != 0;i--){ 
            
            if(isLeap(i)){
                
               leap += 1;
               
            }else{
                
                notLeap += 1;
            }
        }

        return ((leap * 2) + notLeap) % 7;
    }
    
    static boolean isLeap(int y){
        
        if((y % 4 == 0 && y % 100 != 0 ) || y % 400 == 0)
            
            return true;
        
        return false;
    }
}