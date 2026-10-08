public class EmployeePayroll {

    public static void main(String[] args) {

        // Check arguments
        if (args.length < 4) {
            System.out.println("Usage:");
            System.out.println(
                "java EmployeePayroll <ID> <Name> <BasicSalary> <WorkingDays>"
            );
            return;
        }

        // Read command-line arguments
        int id = Integer.parseInt(args[0]);
        String name = args[1];
        double basicSalary = Double.parseDouble(args[2]);
        int workingDays = Integer.parseInt(args[3]);

        // Calculate salary based on working days
        double earnedBasic = (basicSalary / 26) * workingDays;

        // Allowances
        double hra = earnedBasic * 0.20;
        double da = earnedBasic * 0.10;

        double totalAllowance = hra + da;

        // Deduction
        double pf = earnedBasic * 0.12;

        // Net salary
        double netSalary = earnedBasic + totalAllowance - pf;

        // Payroll report
        System.out.println("\n================================");
        System.out.println("       EMPLOYEE PAYROLL");
        System.out.println("================================");

        System.out.println("Employee ID     : " + id);
        System.out.println("Employee Name   : " + name);
        System.out.printf("Basic Salary    : ₹%.2f%n", basicSalary);
        System.out.println("Working Days    : " + workingDays);

        System.out.println("--------------------------------");
        System.out.printf("Earned Basic    : ₹%.2f%n", earnedBasic);
        System.out.printf("HRA (20%%)       : ₹%.2f%n", hra);
        System.out.printf("DA (10%%)        : ₹%.2f%n", da);
        System.out.printf("Total Allowance : ₹%.2f%n", totalAllowance);
        System.out.printf("PF (12%%)        : ₹%.2f%n", pf);

        System.out.println("--------------------------------");
        System.out.printf("NET SALARY      : ₹%.2f%n", netSalary);
        System.out.println("================================");
    }
}