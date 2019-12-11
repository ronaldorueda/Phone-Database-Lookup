
package h18;

public class Contact {
    private String phone;
    private String name;
    
    public Contact(){
        phone = "";
        name = "";
    }
    
    public Contact(String p, String n){
        
        phone = p.replaceAll("-", "");
        name = n;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public void setNum(String p){
        phone = p.replaceAll("-", "");
    }
    
    public String getNum(){
        return phone;
    }
    
    public String getName(){
        return name;
    }
    
    public void WriteOutput(){
        System.out.println("Phone Number: " + phone);
        System.out.println("Name: " + name);
    }
    
    public int compareTo(Contact n){
        if(Long.parseLong(this.phone) > Long.parseLong(n.phone)) return 1;
        if(Long.parseLong(this.phone) < Long.parseLong(n.phone)) return -1;
        return 0;
    }
}
