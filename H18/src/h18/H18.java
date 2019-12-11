
package h18;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class H18 {

    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        Scanner nFile = null;
        Scanner pFile = null;
        File nameFile = new File("names.txt");
        File phoneFile = new File("phonenumbers.txt");
        
        try{
            nFile = new Scanner(nameFile);
            pFile = new Scanner(phoneFile);
        }
        catch(FileNotFoundException e){
            
        }
        
        int count = 0;
        Contact[]cont = new Contact[1000];
        while(nFile.hasNext() && pFile.hasNext()){
            cont[count] = new Contact(pFile.nextLine(), nFile.nextLine());
            count++;
        }
        
        selectionSort(cont);
        
        boolean loop = true;
        String userInput;
        int numPlace;
        
        do{
            System.out.print("Please enter a phone number or type " + "*" + " to quit: ");
            userInput = userIn.nextLine();
            
            if(userInput.equals("*")) loop = false;
            else{
                Contact key = new Contact(userInput, "");
                numPlace = binarySearch(cont, 0, 999, key);
                
                if(numPlace == -1){
                    System.out.println("Unknown number.");
                }
                else{
                    cont[numPlace].WriteOutput();
                }
                
            }
            
        }while(loop);
        
    }
    
    public static void selectionSort(Contact[] A){
        String smallest = A[0].getNum();
        String Smname = A[0].getName();
        int index = 0;
        
        for(int j = 0; j < 6; j++){
            for(int i = j; i < 7; i++){
                if(Long.parseLong(A[i].getNum()) <= Long.parseLong(smallest)){
                    smallest = A[i].getNum();
                    Smname = A[i].getName();
                    index = i;
                }
            }
            A[index] = A[j];
            A[j] = new Contact(smallest, Smname);
            smallest = A[j + 1].getNum();
        }
    }
    
    public static int binarySearch(Contact[]cont, int low, int high, Contact key){
        int rangeSize = (high - low) + 1;
        int mid = (high + low) / 2;
        
        if(cont[mid].compareTo(key) == 0) return mid;
        if(rangeSize == 1){
            if(cont[low].compareTo(key) == 0) return low;
            else return -1;
        }
        
        if(cont[mid].compareTo(key) > 0) return binarySearch(cont, low, mid, key);
        else return binarySearch(cont, mid + 1, high, key);
    }
    
}
