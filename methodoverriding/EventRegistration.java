// A college cultural event "Show Your talent" is being conducted and the organizing committee has decided to come up with online registration for the same. 
// Initially, the registration fee for single and team events was the same, but later the organizing committee decided to calculate the registration fee based on the 
// number of participants.
// The students can participate in single events as well as team events. The portal displays the team number for a team and the participant number for a participant.
// Create a Java Project with the name OverridingAndSuper Implement the class EventRegistration, SingleEventRegistration, and TeamEventRegistration.
public class EventRegistration{
    public String name;
    public String nameOfEvent; 
    public double registrationFee;

    EventRegistration(String name,String nameOfEvent){
        setName(name);
        setNameOfEvent(nameOfEvent);
    }
    EventRegistration(){}
    public void setName(String name){
        this.name = name;
    }
    public void setNameOfEvent(String nameOfEvent){
        this.nameOfEvent = nameOfEvent;
    }
    public void setRegistrationFee(double registrationFee){
        this.registrationFee = registrationFee;
    }
    public double getRegistrationFee(){
        return this.registrationFee;
    }
    public String getName(){
        return this.name;
    }
    public String getNameOfEvent(){
        return this.nameOfEvent;
    }
    public void registerEvent(){
        System.out.println("    Events     BaseFee");
        System.out.println("1. ShakeALeg -  100");
        System.out.println("2. Sing&Win  -  150");
        System.out.println("3. Actathon  -  70");
        System.out.println("4. PlayAway  -  130");
        System.out.println();
    }
    public static void main(String[] args) {
        SingleEventRegistration s1 = new SingleEventRegistration("Jenny", "Sing&Win", 1);
        s1.registerEvent();
        
        TeamEventRegistration t1 = new TeamEventRegistration("Aura", "ShakeALeg", 5, 1);
        t1.registerEvent();    
        
        SingleEventRegistration s2 = new SingleEventRegistration("Hudson", "PlayAway", 2);
        s2.registerEvent();

    }
}