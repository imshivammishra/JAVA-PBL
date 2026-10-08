import java.util.Scanner;

class ElectricityBill {

    int customerId;
    String name;
    int units;

    ElectricityBill(int customerId, String name, int units) {
        this.customerId = customerId;
        this.name = name;
        this.units = units;
    }

    double calculateEnergyCharge() {

        double charge = 0;

        if (units <= 100) {
            charge = units * 1.50;
        }
        else if (units <= 200) {
            charge = (100 * 1.50)
                   + ((units - 100) * 2.50);
        }
        else if (units <= 500) {
            charge = (100 * 1.50)
                   + (100 * 2.50)
                   + ((units - 200) * 4.00);
        }
        else {
            charge = (100 * 1.50)
                   + (100 * 2.50)
                   + (300 * 4.00)
                   + ((units - 500) * 6.00);
        }

        return charge;
    }

    void generateBill() {

        double energyCharge = calculateEnergyCharge();
        double fixedCharge = 100;
        double subtotal = energyCharge + fixedCharge;
        double tax = subtotal * 0.05;
        double finalAmount = subtotal + tax;

        System.out.println("\n===== ELECTRICITY BILL =====");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + name);
        System.out.println("Units Consumed: " + units);
        System.out.println("Energy Charge: ₹" + energyCharge);
        System.out.println("Fixed Charge: ₹" + fixedCharge);
        System.out.println("Tax (5%): ₹" + tax);
        System.out.println("----------------------------");
        System.out.println("Final Payable: ₹" + finalAmount);
    }
}

public class ElectricityBillSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nCustomer " + i);

            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Units Consumed: ");
            int units = sc.nextInt();

            ElectricityBill bill =
                    new ElectricityBill(id, name, units);

            bill.generateBill();
        }

        sc.close();
    }
}