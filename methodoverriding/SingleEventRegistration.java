public class SingleEventRegistration extends EventRegistration{
    public int participantNo;
    SingleEventRegistration(String name,String nameOfEvent,int participantNo){
        super(name,nameOfEvent);
        this.participantNo = participantNo;
    }
    public void registerEvent(){
        System.out.println("    Events     BaseFee");
        System.out.println("1. ShakeALeg -  100");
        System.out.println("2. Sing&Win  -  150");
        System.out.println("3. PlayAway  -  130");
        System.out.println();
        if(getNameOfEvent().equals("ShakeALeg")){
            setRegistrationFee(100);
        }
        else if(getNameOfEvent().equals("Sing&Win")){
            setRegistrationFee(150);
        }
        else if(getNameOfEvent().equals("PlayAway")){
            setRegistrationFee(130);
        }
        System.out.println("Thank you "+getName()+" for your participation in the event "+getNameOfEvent()+" with participant number "+participantNo+" and registration fee "+getRegistrationFee());
    }
    
}
