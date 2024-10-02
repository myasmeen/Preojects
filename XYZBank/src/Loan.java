abstract class Loan {
	// Represents the unique identifier for each loan record.
    protected String recordID;
    
    // Indicates the type of loan, such as Auto, Mortgage, Personal, Builder, or Other.
    protected String loanType;
    
    // Stores the interest rate associated with the loan.
    protected double interestRate;
    
    // Represents the remaining term of the loan in months.
    protected int loanTermLeft;
    
    // Represents the remaining principal amount of the loan.
    // This field is set to the initial loan amount in the constructor.
    protected double amountLeft;

    // Constructor for the Loan Class
    public Loan(String recordID, String loanType, double interestRate, int loanTermLeft, double amountLeft) {
    	
    	//Following lines initialise the recordID, type of loan, interest rate and the amount of time left
        this.recordID = recordID;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.loanTermLeft = loanTermLeft;
        this.amountLeft = amountLeft;
    }

    // Abstract method to print loan details
    public abstract void printLoanDetails();
//Additional Comments for Loan Class:
//- This class serves as an abstract blueprint for different types of loans(which are sub-classes).
//- Each loan object contains essential information such as a unique record ID, loan type, interest rate, remaining loan term, and remaining loan amount.
//- The constructor initialises these attributes based on the provided parameters.
//- The abstract method printLoanDetails() is intended to be implemented by concrete subclasses to print specific details of each loan type.

 // Getter method for recordID
    public String getRecordID() {
        return recordID;
    }

    // Setter method for recordID
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    // Getter method for loanType
    public String getLoanType() {
        return loanType;
    }

    // Setter method for loanType
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    // Getter method for interestRate
    public double getInterestRate() {
        return interestRate;
    }

    // Setter method for interestRate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Getter method for loanTermLeft
    public int getLoanTermLeft() {
        return loanTermLeft;
    }

    // Setter method for loanTermLeft
    public void setLoanTermLeft(int loanTermLeft) {
        this.loanTermLeft = loanTermLeft;
    }

    // Getter method for amountLeft
    public double getAmountLeft() {
        return amountLeft;
    }

    // Setter method for amountLeft
    public void setAmountLeft(double amountLeft) {
        this.amountLeft = amountLeft;
    }
}

