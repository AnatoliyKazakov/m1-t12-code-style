import java.util.Scanner;

public class DepositCalculator {
    //здесь нужен Enter
    public static void main(String[] args) {
//здесь не нужен Enter 
        new DepositCalculator().calculateDeposit();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double income = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getProfit(income);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double income = amount + amount * yearRate * depositPeriod;
        return getProfit(income); 
    }
    //название не соответсвует логике - тут происходит округление 
    double getProfit(double income) {
        return Math.round(income);
    }

    void calculateDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        double profit = 0;
// 
        if (action == 1) {
            profit = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            profit = calculateComplexPercent(amount, 0.06, period);
        } 
//
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + profit);
    }
}
