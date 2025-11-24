import java.util.Scanner;

public class WasteSegregationSystem {

    // Method to classify waste automatically based on keywords
    public static void classifyWaste(String item) {

        // Convert input to lowercase for easier matching
        String waste = item.toLowerCase();

        System.out.println();

        // Check for keywords to find the waste category
        if (waste.contains("food") || waste.contains("fruit") || waste.contains("peel") || waste.contains("vegetable")) {
            System.out.println("Category   : Wet Waste");
            System.out.println("Bin        : Green Bin");
            System.out.println("Suggestion : Compost if possible to reduce landfill waste.");
        } 
        else if (waste.contains("paper") || waste.contains("cardboard") || waste.contains("newspaper")) {
            System.out.println("Category   : Dry Waste");
            System.out.println("Bin        : Blue Bin");
            System.out.println("Suggestion : Recycle or reuse to save trees.");
        } 
        else if (waste.contains("plastic") || waste.contains("bottle") || waste.contains("metal") || waste.contains("glass")) {
            System.out.println("Category   : Recyclable Waste");
            System.out.println("Bin        : Blue Bin");
            System.out.println("Suggestion : Rinse before recycling.");
        } 
        else if (waste.contains("battery") || waste.contains("chemical") || waste.contains("paint")) {
            System.out.println("Category   : Hazardous Waste");
            System.out.println("Bin        : Red Bin");
            System.out.println("Suggestion : Dispose at authorized e-waste collection center.");
        } 
        else if (waste.contains("mask") || waste.contains("medicine") || waste.contains("syringe")) {
            System.out.println("Category   : Biomedical Waste");
            System.out.println("Bin        : Yellow Bin");
            System.out.println("Suggestion : Seal in a bag and hand over to medical authorities.");
        } 
        else {
            // If nothing matches → unknown category
            System.out.println("⚠ Unknown item. Please dispose responsibly!");
        }
        System.out.println();
    }

    // Display all waste categories and corresponding bins
    public static void showCategories() {
        System.out.println("\n------- Waste Categories -------");
        System.out.println("Wet Waste        → Green Bin");
        System.out.println("Dry Waste        → Blue Bin");
        System.out.println("Recyclable Waste → Blue Bin");
        System.out.println("Hazardous Waste  → Red Bin");
        System.out.println("Biomedical Waste → Yellow Bin");
        System.out.println("--------------------------------\n");
    }

    // Main method — menu and program control
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  // Scanner for input
        int choice;                            // Stores menu choice
        String item;                           // Stores waste item name
        char again;                            // To repeat classification

        // Loop until user selects Exit option (choice 3)
        do {
            System.out.println("-------------------------------------");
            System.out.println("WASTE SEGREGATION SUGGESTION SYSTEM");
            System.out.println("-------------------------------------");
            System.out.println("1. Classify Waste by Typing Name");
            System.out.println("2. View Waste Categories");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");
            
            choice = sc.nextInt(); // reading numeric choice
            sc.nextLine(); // extra line consumed (avoids skipping input)

            switch (choice) {
                case 1:
                    // Loop to allow repeated checking
                    do {
                        System.out.print("\nEnter a waste item: ");
                        item = sc.nextLine(); // read waste name
                        classifyWaste(item);  // call method

                        System.out.print("Check another item? (Y/N): ");
                        again = sc.next().charAt(0);
                        sc.nextLine(); // consume leftover newline

                    } while (again == 'Y' || again == 'y');
                    break;

                case 2:
                    // Show waste categories
                    showCategories();
                    break;

                case 3:
                    // Exit message
                    System.out.println("\nThank you for keeping Earth clean! 🌍");
                    break;

                default:
                    // Invalid selection
                    System.out.println("\nInvalid choice! Please try again.\n");
            }

        } while (choice != 3); // loop ends when user chooses Exit

        sc.close(); // close input stream
    }
}
