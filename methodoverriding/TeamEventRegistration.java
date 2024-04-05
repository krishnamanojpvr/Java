public class TeamEventRegistration extends EventRegistration {
    public int teamNo;
    public int noOfParticipants;
    TeamEventRegistration(String name, String nameOfEvent, int teamNo, int noOfParticipants) {
        super(name, nameOfEvent);
        this.teamNo = teamNo;
        this.noOfParticipants = noOfParticipants;
    }
    public void registerEvent() {
        System.out.println("    Events     BaseFee");
        System.out.println("1. ShakeALeg -  50");
        System.out.println("2. Sing&Win  -  60");
        System.out.println("3. Actathon  -  80");
        System.out.println("4. PlayAway  -  130");
        System.out.println();
        if (getNameOfEvent().equals("ShakeALeg")) {
            setRegistrationFee(100 * noOfParticipants);
        } else if (getNameOfEvent().equals("Sing&Win")) {
            setRegistrationFee(150 * noOfParticipants);
        } else if (getNameOfEvent().equals("Actathon")) {
            setRegistrationFee(70 * noOfParticipants);
        } else if (getNameOfEvent().equals("PlayAway")) {
            setRegistrationFee(130 * noOfParticipants);
        }
        System.out.println("Thank you " + getName() + " for your participation in the event " + getNameOfEvent()
                + " with team number " + teamNo + " and registration fee " + getRegistrationFee());
    }
    
}
