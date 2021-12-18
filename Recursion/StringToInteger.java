public static int convertStringToInt(String input){
        if(input.length()==0){
            return 0;
        }
        int smallOutput=convertStringToInt(input.substring(0,input.length()-1));
        int last=input.charAt(input.length()-1)-'0';
        return smallOutput*10+last;
        
}

// Write a recursive function to convert a given string into the number it represents. That is input will be a numeric string that contains only numbers, you need to convert the string into corresponding integer and return the answer.
// Input format :
// Numeric string S (string, Eg. "1234")
// Output format :
// Corresponding integer N (int, Eg. 1234)
