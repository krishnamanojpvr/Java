class ScholarshipStudent extends Student {
    private boolean isEligible;
    private double fees;

    // Constructor
    public ScholarshipStudent(String name, int age, String gender, double weight, String nationality, int year,
            char section, double cgpa, int[] noOfGrades) {
        super(name, age, gender, weight, nationality, year, section, cgpa, noOfGrades);
        this.fees = calculateFees(year);
        this.isEligible = checkEligibilityForScholarship(cgpa, nationality);
    }

    private double calculateFees(int year) {
        double fee = super.getFees();
        return (fee/2);
    }

    // Method to check eligibility for scholarship
    private boolean checkEligibilityForScholarship(double cgpa, String nationality) {
        return cgpa > 9.0 && (nationality.equalsIgnoreCase("Indian"));
    }

    // Setter for isEligible attribute
    public void setEligible(boolean isEligible) {
        if (isEligible && checkEligibilityForScholarship(getCgpa(), getNationality())) {
            this.isEligible = true;
        } else {
            this.isEligible = false;
        }
    }

    // Getter for isEligible attribute
    public boolean isEligible() {
        return isEligible;
    }

    public double getFees() {
        return fees;
    }

    public void payFees(double amount) {
        this.fees -= amount;
        if (fees <= 0) {
            System.out.println("Fees paid successfully.");
        } else {
            System.out.println("Fees pending: " + fees);
        }
    }
}
