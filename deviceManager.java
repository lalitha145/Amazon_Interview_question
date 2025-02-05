/**You need to implement a Device Management System with the following functionalities:

1. add(device) → Add a new device
If space is available, register the device.
If space is full:
Remove the device with the least number of pings (least used).
If there’s a tie, remove the oldest among them.
Add the new device.
Output what device was added and what device was removed (if any) along with the reason.
2. use(device) → Register a ping for a device
This function increments the ping count of an already registered device.
If the device is not registered, print an appropriate message.
3. show() → Display currently registered devices
Display all registered devices along with their ping count in the order they were added.**/







import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter capacity :");
        int capacity=sc.nextInt();
        HashMap<String,Integer> map=new HashMap<>();
        while(true){
            System.out.println("Enter the case :\n 1.add \n 2.show\n 3.use");
            int n=sc.nextInt();
            sc.nextLine();
         
            switch(n){
                case 1:
                    System.out.println("Enter the devise you want to add");      
                    String device1=sc.nextLine();
                    addDevice(device1,capacity,map);
                break;
                case 2:
                    showDevices(map);
                    break;
                case 3:
                    System.out.println("Enter the devise you want to use");      
                    String device2=sc.nextLine();
                    useDevice(device2,map);
                    break;
                case 4:
                    return;
            }
        }
        
    }
    static void addDevice(String newDevice,int capacity,HashMap<String,Integer>map){
        if(capacity>map.size()){
            map.put(newDevice,0);
            return;
        }
       String remDevice="";
       int lowPing=Integer.MAX_VALUE;
       for(String dev:map.keySet()){
           if(map.get(dev)<lowPing){
               lowPing=map.get(dev);
               remDevice=dev;
           }
       }
       map.remove(remDevice);
       map.put(newDevice,0);
    }
    static void useDevice(String registeredDevice,HashMap<String,Integer> map){
         if(!map.containsKey(registeredDevice)){
             System.out.println("device not available");
             return;
         }
         map.put(registeredDevice,map.get(registeredDevice)+1);
    }
    static public void showDevices(HashMap<String,Integer> map){
        System.out.println(map);
    }
    
}
