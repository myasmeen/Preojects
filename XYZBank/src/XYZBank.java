import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;


class AutoLoan extends Loan { //Sub-classes for the different types of loans:
    
    public AutoLoan(String recordID) {// Constructor for auto loan with default values
        super(recordID, "Auto", 0.0, 0, 0.0); // default values for interest rate, time left, and amount left
    }

    
    public AutoLoan(String recordID, String loanType, double interestRate, double amountLeft, int timeLeft) {// Constructor that initializes loan type to Auto
        super(recordID, "Auto", interestRate, timeLeft, amountLeft); // Call to Parent Constructor: invokes the constructor of the superclass (Loan) with custom values for initialization.
        
        setLoanTermLeft(timeLeft);// Assigns the value of timeLeft to the loanTermLeft field of AutoLoan
    }

    @Override // following method can override a superclass method.
    public void printLoanDetails() {
        // Print loan details method for auto loans
        System.out.println("Loan Type: " + getLoanType());
        System.out.println("Interest Rate: " + getInterestRate());
        System.out.println("Loan Term Left: " + getLoanTermLeft());
    }
}
//Sub-class PersonalLoan
class PersonalLoan extends Loan {
    
    // Constructor with default values for personalLoan
    public PersonalLoan(String recordID) {
        super(recordID, "Personal", 0.0, 0 , 0.0); // default values for interest rate, time left and amount left
    }

    // Constructor that initialises loan type to Personal
    public PersonalLoan(String recordID, String loanType, double interestRate, double amountLeft, int timeLeft) {
        super(recordID, "Personal", interestRate, timeLeft, amountLeft); // Call to Parent Constructor: invokes the constructor of the superclass (Loan) with custom values for initialization.

        // Assigns the value of timeLeft to the loanTermLeft field of PersonalLoan
        setLoanTermLeft(timeLeft);
    }

    @Override // following method can override a superclass method.
    public void printLoanDetails() {
        // Print loan details method for personalLoan
        System.out.println("Loan Type: " + getLoanType());
        System.out.println("Interest Rate: " + getInterestRate());
        System.out.println("Loan Term Left: " + getLoanTermLeft());
    }
}


//sub-class otherLoan
class OtherLoan extends Loan {
	
    // Constructor with default values
    public OtherLoan(String recordID) {
        super(recordID, "Other", 0.0, 0 , 0.0);// default values for interest rate, time left and amount left
    }

    // Constructor that initializes loan type to OtherLoan
    public OtherLoan(String recordID, String loanType, double interestRate, double amountLeft, int timeLeft) {
        super(recordID, "Other", interestRate, timeLeft, amountLeft);
        // Assigns the value of timeLeft to the loanTermLeft field of OtherLoan
        setLoanTermLeft(timeLeft);
    }

    @Override // following method can override a superclass method.
    public void printLoanDetails() {
        // Print loan details method for OtherLoan
        System.out.println("Loan Type: " + getLoanType());
        System.out.println("Interest Rate: " + getInterestRate());
        System.out.println("Loan Term Left: " + getLoanTermLeft());
    }
}


// Sub-class BuilderLoan
class BuilderLoan extends Loan {
    private double overpaymentOption;
    
    // Constructor with default values
    public BuilderLoan(String recordID) {
        super(recordID, "Builder", 0.0, 0 , 0.0); // default values for interest rate, time left, and amount left
    }

    // Constructor that initializes loan type to Builder
    public BuilderLoan(String recordID, String loanType, double interestRate, double amountLeft, int timeLeft, double overpaymentOption) {
        super(recordID, loanType, interestRate, timeLeft, amountLeft);
        this.overpaymentOption = overpaymentOption;
    }
    
    // Getter and setter for overpaymentOption
    public double getOverpaymentOption() {
        return overpaymentOption;
    }

    public void setOverpaymentOption(double overpaymentOption) {
        this.overpaymentOption = overpaymentOption;
    }
    
    @Override // Override method to print loan details
    public void printLoanDetails() {
        System.out.println("Loan Type: " + getLoanType());
        System.out.println("Interest Rate: " + getInterestRate());
        System.out.println("Loan Term Left: " + getLoanTermLeft());
        System.out.println("Overpayment Option: " + overpaymentOption);
    }
}

class MortgageLoan extends Loan {
    private double overpaymentOption; // Represents the overpayment option for the mortgage loan.
    
    // Constructor with default values
    public MortgageLoan(String recordID) {
        super(recordID, "Mortgage", 0.0, 0 , 0.0); // default values for interest rate, time left, and amount left
    }

    // Constructor that initializes loan type to Mortgage
    public MortgageLoan(String recordID, String loanType, double interestRate, double amountLeft, int timeLeft, double overpaymentOption) {
        super(recordID, loanType, interestRate, timeLeft, amountLeft);
        this.overpaymentOption = overpaymentOption;
    }

    // Getter and setter for overpaymentOption
    public double getOverpaymentOption() {
        return overpaymentOption;
    }
    public void setOverpaymentOption(double overpaymentOption) {
        this.overpaymentOption = overpaymentOption;
    }
    @Override // Override method to print loan details
    public void printLoanDetails() {
        System.out.println("Loan Type: " + getLoanType());
        System.out.println("Interest Rate: " + getInterestRate());
        System.out.println("Loan Term Left: " + getLoanTermLeft());
        System.out.println("Overpayment Option: " + overpaymentOption);
    }
}
// Interface CheckerPrinter
interface CheckerPrinter {
    // Method to check eligibility based on the total amount left and annual income.
    // Returns true if the customer is eligible, false otherwise.
    boolean checkEligibility(double totalAmountLeft, double annualIncome);
    
    // Method to print customer details.
    // Prints information such as customer ID, eligibility status, and credit records in a table format.
    void printCustomerDetails();
}

//Class Customer implements CheckerPrinter interface
class Customer implements CheckerPrinter {
	
	// Private fields to store customer details:
    private String customerID;// Unique identifier for the customer
    double customerIncome;// Annual income of the customer
    private boolean eligibilityStatus;//Identifier used to fine out the eligibility of a customer to take on any loans
    ArrayList<Loan> creditRecords;// List to store credit records associated with the customer
   
    public Customer(String customerID, double customerIncome) { // Constructor to initialise customer details
        this.customerID = customerID;// Assign customer ID provided by customer
        this.customerIncome = customerIncome;// Assigns customer income
        this.eligibilityStatus = false; // Set eligibility status to false by default
        this.creditRecords = new ArrayList<>();// Initialise an empty list for credit records to be stored
    }


    public String getCustomerID() { // Getter method to retrieve the customer's unique identifier
        return customerID; // Return the customer ID
    }

    // Method to check the eligibility of the customer for a loan
    public boolean checkEligibility(double totalAmountLeft, double annualIncome) {
    	double totalAmountLeftInThousand = totalAmountLeft * 1000;// Calculate the total amount left in thousands
    	// Check if the total amount left is less than or equal to 4 times the annual income
    	return (totalAmountLeftInThousand) < (4 * annualIncome);//return true if eligiable, false if not eligible
    }

    public void printCustomerDetails() {// Method to print customer details
    	String eStatus = "";// Initialise a string to hold the eligibility status message
    	
        System.out.println("Customer ID: " + customerID);//checks the elgibility status and sets the appropriate message
        if (!eligibilityStatus) {
        	eStatus = "not eligible";//if elgibilityStatus returns false, customer not eligible
        } else {
        	eStatus = "eligible";//else elgibilityStatus is true, customer is eligible
        }
        
        // Print customer ID and eligibility status
        System.out.println("Eligibility Status: " + eStatus + " for another loan");
        System.out.println();
        StringBuilder tableBuilder = new StringBuilder();// Build the table headers
        tableBuilder.append("+---------------+---------------+---------------+---------------+---------------+\n");//table with headings recordID, LoanType,IntRate,AmountLeft, Time Left
        tableBuilder.append("| RecordID      | LoanType      |IntRate(%)     | AmountLeft(£) |TimeLeft(years)|\n");
        tableBuilder.append("+---------------+---------------+---------------+---------------+---------------+\n");
        
        
        for (Loan loan : creditRecords) {// Iterate over each loan in the customer's credit records and displays in the table
        	tableBuilder.append(String.format("| %-13s | %-13s | %-13.2f | %-13.2f | %-13d |\n",// Append loan details to the tableBuilder using formatted strings
        	        loan.recordID, loan.loanType, loan.interestRate, loan.amountLeft, loan.loanTermLeft));
        	
            tableBuilder.append("+---------------+---------------+---------------+---------------+---------------+\n");// Add a horizontal line after each loan entry to improve readability
        }
        
        System.out.println(tableBuilder.toString());//print the constructed table
    }
    
    public void registerCreditRecord(Loan loan) {// Method to register a credit record
        creditRecords.add(loan);// Add the provided loan to the customer's credit records list
    }

    public void updateCustomerInformation(double newIncome) {// Method to update customer information
        this.customerIncome = newIncome;// Update the customer's income with the provided value inputed by customer
        updateEligibilityStatus();// Update the eligibility status based on the new income
    }
    
    void updateEligibilityStatus() {// Method to update eligibility status
        double totalAmountLeft = 0;// Initialise a variable to hold the total amount left on all loans
        
        for (Loan loan : creditRecords) {// Iterate over each loan in the customer's credit records
            totalAmountLeft += loan.amountLeft;// sums up all the amount of loan left by going through each record
        }
        
        eligibilityStatus = checkEligibility(totalAmountLeft, customerIncome); // Update the eligibility status based on the total amount left and the customer's income
    }
    
	public void updateIncome(double newIncome) {// Method to update customer income and eligibility status
		this.customerIncome = newIncome;// Update the customer's income with the provided value	
	    updateEligibilityStatus();// Update the eligibility status based on the new income
	}
}

public class XYZBank {// Main class XYZBank
	
    private List<Customer> customers;// List to store the bank's customers
	private Scanner scanner;// Scanner object for user input
	
	public XYZBank() {// Constructor to initialise the list of customers and the scanner
        this.customers = new ArrayList<>();// Initialise an empty list of customers
        this.scanner = new Scanner(System.in);// Initialise a scanner to read user input
    }
	//method to validate customer ID format
	private boolean validateCustomerID(String customerId) {
		// Return true if the provided customer ID matches the specified format
        return customerId.matches("[A-Z]{3}\\d{3}");
    }
	// Method to register a new customer
    public void registerCustomer(String customerId, double income) {
    	//checks if customer already exists
    	 if (!customerExists(customerId)) {
             customers.add(new Customer(customerId, income));//creates new Customer object and adds it to the list of customers
             System.out.println("Customer registered successfully."); 
         } else {
             System.out.println("Customer already exists.");//Message that is displayed if customer already exists.
         }
     }

    //method to update customer's income
    public void updateCustomerIncome(String customerId, double newIncome) {
        Customer customer = findCustomer(customerId);//find the customer using their customerID
        if (customer != null) { //check if customer exists
        	//update customer income with the new value
            customer.updateIncome(newIncome);
            System.out.println("Customer income updated successfully.");
        } else {
            System.out.println("Customer not found.");//prints if customer not found
        }
    }
    
    //method to make a credit record for customer
    public void addCreditRecord(String customerId, Loan loan) {
    	Customer customer = findCustomer(customerId);
        if (customer != null) {
            // Calculate the total amount left for the customer's loans
            double totalAmountLeft = 0.0;
            //loops through customer records and sums up the amount left of loan
            for (Loan l : customer.creditRecords) {
                totalAmountLeft += l.amountLeft;
            }

            // Check eligibility based on the total amount left and customer's annual income
            if (customer.checkEligibility(totalAmountLeft, customer.customerIncome)) {
                if (loan.recordID.matches("\\d{6}")) {// Validate the record ID format. Must be 6 int numbers
                    boolean isUnique = true;// Check if the record ID is unique
                    for (Loan l : customer.creditRecords) {
                        if (l.recordID.equals(loan.recordID)) {
                            isUnique = false;
                            break;
                        }
                    }
                    // If the record ID is unique, add the credit record for the customer
                    if (isUnique) {
                        // Add the credit record for the customer
                        customer.registerCreditRecord(loan);
                        System.out.println("Credit record added successfully.");
                        customer.updateEligibilityStatus();// Update the eligibility status based on the new credit record
                    } else {
                        System.out.println("Record ID already exists.");//error message if recordID exists
                    }
                } else {
                    System.out.println("Invalid record ID format.");//error message if invalid ID entered
                }
            } else {
                System.out.println("Customer not found.");//error message if customer not found
            }
        }
        }
    
    public void printCustomerDetails(String customerId) {//method for printing a single customer's details
        Customer customer = findCustomer(customerId);//find customer using customer ID provided
        //if customer is found, print their details. Otherwise display error message
        if (customer != null) {
            customer.printCustomerDetails();//printCustomerDetails method called to format results and print the details
        } else {
            System.out.println("Customer not found.");//error message
        }
    }
    
    public void printAllCustomersDetails() {//method for printing all customers details
        for (Customer customer : customers) {//iterates over all customers and prints their details using the printCustomerDetail method
            customer.printCustomerDetails();
            System.out.println();
        }
    }
    private boolean customerExists(String customerId) {//method to find out if a customer exists in database
        for (Customer customer : customers) {//check if customer with provided ID exists in the list of customers
            if (customer.getCustomerID().equals(customerId)) {
                return true;//customer exists
            }
        }
        return false;//customer does not exist
    }
    
    private Customer findCustomer(String customerId) {// method used to find a customer and return them where needed
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerId)) {
                return customer;//return found customer
            }
        }
        return null;//customer not found
    }
    
    private void updateExistingLoan(String customerId, String loanId) {
        Customer customer = findCustomer(customerId);// Find the customer using provided customer ID
        
        if (customer == null) {
            System.out.println("Customer not found."); //if customer not found, display error message
            return;
        }

        Loan foundLoan = null;
        for (Loan loan : customer.creditRecords) {// Find the loan in the customer's credit records using the provided ID
            if (loan.recordID.equals(loanId)) {
                foundLoan = loan;
                break;
            }
        }
        if (foundLoan == null) {
            System.out.println("Loan not found for the given record ID."); //if loan not found, display error message and return
            return;
        }
        System.out.println("If you would like to keep a value the same, enter the same value as shown in the table.");
        // Store the original loan details before the update
        double originalInterestRate = foundLoan.interestRate;
        double originalAmountLeft = foundLoan.amountLeft;
        int originalLoanTermLeft = foundLoan.loanTermLeft;
        
        
        double newInterestRate = 0;
        while (true) {
            try {
            	System.out.print("Enter new interest rate: ");
                newInterestRate = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (newInterestRate < 0) {
                    System.out.println("Interest rate cannot be negative. Please enter a non-negative value:");
                } else {
                    break; // Exit the loop if input is valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number: ");
                scanner.next(); // Consume the invalid input
            }
        }
        
        
        
        double newAmountLeft = 0.0;

        while (true) {
            try {
                System.out.print("Enter new amount left: ");
                newAmountLeft = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                
                if (newAmountLeft < 0) {
                    System.out.println("Amount left cannot be negative. Please enter a non-negative value:");
                } else {
                    break; // Exit the loop if input is valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number: ");
                scanner.next(); // Consume the invalid input
            }
        }
        
        int newTimeLeft = 0;

        while (true) {
            try {
                System.out.print("Enter new time left: ");
                newTimeLeft = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                if (newTimeLeft < 0) {
                    System.out.println("Time left cannot be negative. Please enter a non-negative integer value:");
                } else {
                    break; // Exit the loop if input is valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer: ");
                scanner.next(); // Consume the invalid input
            }
        }
        
        //update loan details and eligibility status
        foundLoan.setInterestRate(newInterestRate);
        foundLoan.setAmountLeft(newAmountLeft);
        foundLoan.setLoanTermLeft(newTimeLeft);
        
    
        if (!customer.checkEligibility(foundLoan.amountLeft, customer.customerIncome)) { // Check eligibility after updating loan information
            System.out.println("The updated loan is not eligible. Reverting changes...");// If the updated loan is not eligible, display a message and revert the changes
            foundLoan.setInterestRate(originalInterestRate);
            foundLoan.setAmountLeft(originalAmountLeft);
            foundLoan.setLoanTermLeft(originalLoanTermLeft);
            return;
        }
        
        customer.updateEligibilityStatus();//update eligibility status after successful update
        System.out.println("Loan updated successfully.");
    }
    
    //method for deleting a customer record
    private void deleteExistingLoan(String customerId, String loanId) {
        
        Customer customer = findCustomer(customerId);// Find the customer using the provided ID
        if (customer == null) {
            System.out.println("Customer not found.");//if customer not found, display error message and return
            return;
        }
        Loan foundLoan = null;
        for (Loan loan : customer.creditRecords) {// Find the loan in the customer's credit records using the provided loan ID
            if (loan.recordID.equals(loanId)) {
                foundLoan = loan;
                break;
            }
        }

        if (foundLoan == null) {
            System.out.println("Loan not found for the given record ID.");//error message if loan not found
            return;
        }
        customer.creditRecords.remove(foundLoan);// Remove the loan from the customer's credit records
        System.out.println("Loan deleted successfully.");
    }
    
    public static void main(String[] args) {//initialise XYZBank and scanner for user input
        XYZBank bank = new XYZBank();
        Scanner scanner = new Scanner(System.in);
        
        //variables to store the maximum registered records and number or records that have been registered
        int maxRecords = 0;
        int registeredRecords = 0;
        
        //welcome message and input prompt for max number of records
        System.out.println("Welcome to XYZBank!");
        System.out.println("Enter the maximum amount of records you would like to input into the system: ");
        
        //loop until a valid input for maxRecords provided
        while (true) {
            try {
                maxRecords = scanner.nextInt();//reads input for maxRecord
                //validate if maxRecords is negative
                if (maxRecords < 0) {
                    System.out.println("Maximum amount of records cannot be negative. Please enter a non-negative value: ");
                } else {
                    break; // Exit the loop if input is valid
                }
            } catch (InputMismatchException e) {
            	//validate if maxRecord is not an int value
                System.out.println("Invalid input. Please enter a valid integer value: ");
                scanner.next(); // Consume the invalid input
            }
        }
        

        while (true) {
        	//displayed menu option for the user
            System.out.println("1. Register Customer");
            System.out.println("2. Add Credit Record to existing Customer ");
            System.out.println("3. Update Information about an existing Customer");
            System.out.println("4. Print a Customer's Details");
            System.out.println("5. Print All Customers Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice(1-6): ");

            try {
            	//prompt for user's choice (must be int)
            	int choice = scanner.nextInt();
                scanner.nextLine();
            
            switch (choice) {
            case 1:
                String customerId = null;//variables to store customer ID and income
                double income = 0;
                boolean validCustomerId = false;//Flags for exception handling for customer ID and income inputs
                boolean validIncome = false;
                System.out.println("------------------------------------------");
                
                while (true) {//Loop until valid input is provided
                    try {
                        while (!validCustomerId) {// Input customer ID ande checks if it is a valid input. loops until valid ID provided
                            System.out.print("Enter customer ID(e.g., ABC123): ");
                            customerId = bank.scanner.nextLine().toUpperCase().trim();//automatically capitalises customer ID
                            if (!bank.validateCustomerID(customerId)) {//calls method to validate customer ID
                                throw new IllegalArgumentException("Invalid customer ID format. Please enter a valid ID (e.g., ABC123)3 capital letters followed by 3 numbers:");
                            }
                            validCustomerId = true; // Mark customer ID as valid
                        }

                        // Input customer income if it's not valid. loops until valid input provided
                        while (!validIncome) {
                            System.out.print("Enter customer income: ");
                            income = Double.parseDouble(bank.scanner.nextLine());
                            if (income < 0) {//income cannot be negative
                                throw new IllegalArgumentException("Income cannot be negative. Please enter a valid income: ");
                            }
                            validIncome = true; // Mark income as valid
                        }
                        
                        bank.registerCustomer(customerId, income);// Register the customer if both inputs are valid
                        break; // Exit the loop if registration is successful
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input format. Please enter a valid number: ");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        if (e.getMessage().contains("customer ID")) {
                            validCustomerId = false; // Reset customer ID validation flag
                        } else {
                            validIncome = false; // Reset income validation flag
                        }
                    }
                }
                break;
                
            case 2:
            	System.out.println("------------------------------------------");
            	System.out.print("Enter customer ID(In the form AAAXXX- 3 capital letters followed by 3 numbers): ");//display prompt for customer ID input
                customerId = scanner.nextLine().toUpperCase().trim();
                
                Customer customer = bank.findCustomer(customerId);// Check if the customer exists
                if (customer == null) {
                    System.out.println("Customer not found.");
                    break;
                }
                
                double totalAmountLeft = 0.0;// Calculate the total amount left for the customer's loans
                for (Loan loan : customer.creditRecords) {
                    totalAmountLeft += loan.amountLeft;//sums up all of the total amount of loan left by looping through all records
                }

                if (!customer.checkEligibility(totalAmountLeft, customer.customerIncome)) { // Check eligibility status
                    System.out.println("Customer is not eligible for a loan. No extra loans can be added to this Customers records.");
                    break;//if customer not eligibile, no new credit records can be registered
                }
                
                System.out.print("Enter record ID(6 numbers): ");
                String recordId = scanner.nextLine();
                
                if (!recordId.matches("\\d{6}")) {// Check if the record ID format is valid
                    System.out.println("Invalid record ID format.");
                    break; // Exit the case
                }

                boolean isUnique = true;// Check if the record ID is unique
                for (Customer c : bank.customers) {
                    for (Loan l : c.creditRecords) {
                        if (l.recordID.equals(recordId)) {
                            isUnique = false;
                            break;
                        }
                    }
                }
                if (!isUnique) {
                    System.out.println("Record ID already exists.");
                    break; //if record ID provided exists, breaks
                }
                
                registeredRecords++;//counter for number of registered records
                if (registeredRecords > maxRecords) {//Check if maximum number of records has been reached
                    System.out.println("Maximum number of records reached. No more records can be added");
                    while (true) {
                        System.out.println("Would you like to increase the maximum number of records that can be entered? (y/n)");//user inputs y/n if they want to add more records or not
                        String maxRecordInc = scanner.nextLine().trim().toLowerCase();//auto lower case and trims input

                        if (maxRecordInc.equals("y")) {//max records is increased
                            System.out.println("Currently the maximum number of records that can be inputted is: " + maxRecords);
                            System.out.println("How many more records would you like to enter: ");

                            try {//exception handling for inputted number
                                int additionalRecords = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                maxRecords += additionalRecords;
                                registeredRecords -= 1; // Decrease registered records by 1 to adjust for the updated maximum
                                System.out.println("Maximum number of records updated successfully.");
                                break; // Exit the loop after updating the maximum records
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number.");
                                scanner.nextLine(); // Consume invalid input
                            }
                        } else if (maxRecordInc.equals("n")) {
                            break; // Exit the loop if the user chooses not to increase the maximum records
                        } else {
                            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                        }
                    }
                    
                    break;// Exit the case
                } else {
                	//displays which number of record the user is inputing
                    System.out.println("You Are Now Entering Record Number " + registeredRecords + " out of " + maxRecords);
                }
                
                String loanType = "";
                // Loop until a valid loan type is entered
                while (true) {
                    System.out.print("Enter loan type (Auto, Mortgage, Personal, Builder, Other): ");
                    loanType = scanner.nextLine().toUpperCase().trim(); // Trim whitespace, auto capitalises input
                    // Validate loan type
                    if (loanType.equals("AUTO") || loanType.equals("MORTGAGE") || loanType.equals("PERSONAL") ||
                            loanType.equals("BUILDER") || loanType.equals("OTHER")) {
                        break; // Exit the loop if loan type is valid
                    } else {
                        System.out.println("Invalid loan type. Please try again:");
                    }
                }
                
                double interestRate = 0.0;
             // Loop until a valid interest rate is entered
                while (true) {
                    try {
                    	System.out.print("Enter interest rate: ");
                        interestRate = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        if (interestRate < 0) {
                            System.out.println("Interest rate cannot be negative. Please enter a non-negative value:");
                        } else {
                            break; // Exit the loop if input is valid
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number: ");
                        scanner.next(); // Consume the invalid input
                    }
                }
                
                double amountLeft = 0.0;
                while (true) {// Loop until a valid amount left is entered
                	System.out.print("Enter amount left(in terms of 1000 e.g. 1 = 1000): ");
                    try {
                        amountLeft = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        if (amountLeft < 0) {
                            System.out.println("Amount left cannot be negative. Please enter a non-negative value: ");
                        } else {
                            break; // Exit the loop if input is valid
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number: ");
                        scanner.next(); // Consume the invalid input
                    }
                }
                int timeLeft = 0;
                while (true) {// Loop until a valid time left is entered
                	System.out.print("Enter time left: ");
                    try {
                        timeLeft = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (timeLeft < 0) {
                            System.out.println("Time left cannot be negative. Please enter a non-negative value. ");
                        } else {
                            break; // Exit the loop if input is valid
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer. ");
                        scanner.next(); // Consume the invalid input
                    }
                }
                double overpaymentOption = 0.0;
                if (loanType.equalsIgnoreCase("Builder") || loanType.equalsIgnoreCase("Mortgage")) {// Prompt for overpayment option input if the loan type is Builder or Mortgage
                    boolean validInput = false;
                    while (!validInput) {
                        System.out.print("Enter overpayment option (0 to 2): ");
                        if (scanner.hasNextDouble()) {
                            overpaymentOption = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            if (overpaymentOption >= 0 && overpaymentOption <= 2) {
                                validInput = true;
                            } else {
                                System.out.println("Overpayment option must be between 0 and 2: ");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid number between 0 and 2: ");
                            scanner.nextLine(); // Consume the invalid input
                        }
                    }
                }
                Loan loan = null;// Create the loan object based on the loan type
                switch (loanType) {
                    case "AUTO":
                        loan = new AutoLoan(recordId, customerId, interestRate, amountLeft, timeLeft);
                        break;
                    case "MORTGAGE":
                        loan = new MortgageLoan(recordId, customerId, interestRate, amountLeft, timeLeft, overpaymentOption);
                        break;
                    case "PERSONAL":
                        loan = new PersonalLoan(recordId, customerId, interestRate, amountLeft, timeLeft);
                        break;
                    case "BUILDER":
                        loan = new BuilderLoan(recordId, customerId, interestRate, amountLeft, timeLeft,overpaymentOption);
                        break;
                    case "OTHER":
                        loan = new OtherLoan(recordId, customerId, interestRate, amountLeft, timeLeft);
                        break;
                    default:
                        System.out.println("Invalid loan type.");
                        break;
                }
                if (loan != null) {// Add the credit record for the customer
                    bank.addCreditRecord(customerId, loan);
                }
                break;//exits loop and returns to options
                
            case 3:
            	System.out.println("------------------------------------------");
            	System.out.print("Enter customer ID: ");//customerID input
                customerId = scanner.nextLine().toUpperCase().strip();//auto capitalises input
                customer = bank.findCustomer(customerId);//find the customer
                
                
                if (customer != null) {
                    boolean backToPreviousOptions = false;//flag to ensure the 'update information' menu is displayed. Makes sure customer only taken to previous menu if they press 4
                    while (!backToPreviousOptions) {
                        System.out.println("Customer found. What would you like to update?");// Display options for updating customer information
                        System.out.println("1. Update Income");
                        System.out.println("2. Delete Loan Record");
                        System.out.println("3. Update Existing Loan");
                        System.out.println("4. Go Back To Previous Options");
                        System.out.print("Enter your choice (1-4): ");
                        int updateChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (updateChoice) {
                            case 1:
                                System.out.println("------------------------------------------");
                                System.out.print("Enter new income: ");// Prompt for new income input
                                double newIncome = 0;

                                while (true) {
                                    try {
                                        newIncome = scanner.nextDouble();
                                        scanner.nextLine(); // Consume newline
                                        if (newIncome < 0 || newIncome % 1 != 0) {
                                            System.out.println("Income must be a non-negative integer. Please enter a valid value:");
                                        } else {
                                            break; // Exit the loop if input is valid
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a valid number: ");
                                        scanner.nextLine(); // Consume the invalid input
                                    }
                                }
                                bank.updateCustomerIncome(customerId, (int) newIncome);// Update customer income
                                break;
                            case 2:
                                System.out.println("------------------------------------------");
                                System.out.println("Current Customer Details: ");
                                bank.printCustomerDetails(customerId);
                                System.out.print("Enter loan ID You Would Like to Delete: ");// Prompt for loan ID input to delete
                                String loanId = scanner.nextLine();
                                registeredRecords--;// Once record deleted, registered record counter decreases by 1
                                bank.deleteExistingLoan(customerId, loanId);// Record deleted
                                break;
                            case 3:
                                System.out.println("------------------------------------------");
                                System.out.println("Current Customer Details: ");
                                bank.printCustomerDetails(customerId);
                                System.out.print("Enter loan ID: ");// Prompt for loan ID input to update an existing loan
                                loanId = scanner.nextLine();
                                bank.updateExistingLoan(customerId, loanId);// Update existing loan details using updateExistingLoan method
                                break;
                            case 4:// Go back to previous options
                                backToPreviousOptions = true;
                                break;
                            default:
                                System.out.println("Invalid choice.");// Error message if invalid input for menu selection
                                break;
                        }
                    }
                } else {
                    System.out.println("Customer not found.");// Customer entered not found error message
                }
                break;//breaks and goes back to previous menu

            	

            case 4:
            	System.out.println("------------------------------------------");
                System.out.print("Enter customer ID: ");//prompt for customerID input
                customerId = scanner.nextLine().toUpperCase().strip();
                bank.printCustomerDetails(customerId);//print details of specific customer
                break;
            case 5://displays all registered records of all customers
            	System.out.println("------------------------------------------");
            	System.out.println("Maximum number of Records: "+ maxRecords);//displays number of maximum and number or registered records
            	System.out.println("Registered Records: " + registeredRecords);
            	System.out.println("------------------------------------------");
                bank.printAllCustomersDetails();//print details of all customers using printAllCustomerDetails method
                break;
            case 6:
            	//exit the program
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");//handles any invalid choices
                break;
        }
            } catch (InputMismatchException e) {//invalid input for menu options
                System.out.println("Invalid input. Please enter a valid number from 1 to 6.");
                scanner.nextLine();
        }      
     }
    }
}