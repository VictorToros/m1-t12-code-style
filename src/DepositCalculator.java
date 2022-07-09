import java.util.Scanner;

public class DepositCalculator  { // перед фигурной скобкой стоят два пробела вместо одного
    double calculateComplexPercentFunction(double doubleAmount, double doubleYearRate, int depositPeriod) {
        // постфикс Function в названии по условию не нужен и в названиях переменных указывать их тип (double) не надо
        double pay = doubleAmount * Math.pow ((1 + doubleYearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercentFunction(double doubleAmount, double doubleYearRate, int depositPeriod) {
        // постфикс Function в названии по условию не нужен и в названиях переменных указывать их тип (double) не надо
        return round (doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow (10, places);
        return Math.round (value * scale) / scale;
    }

    void doImportantJob() { // по условию требуется какое-то название, описывающее суть происходящего внутри
        int period;
        int action;
        final double yearRate = 0.06;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outDoubleVar = 0; // в названиях переменных тип самой переменной (Double) и того,
        // что это переменная (Var) быть не должно
        if (action == 1) outDoubleVar = calculateSimplePercentFunction(amount, yearRate, period);
        // аналогично предыдущему
        else if (action == 2) {
            outDoubleVar = calculateComplexPercentFunction(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().doImportantJob();
    }
// мне кажется, эта пропущенная строка - лишняя
}
