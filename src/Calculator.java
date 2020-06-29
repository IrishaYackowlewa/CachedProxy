public class Calculator implements InterCalculator{

    public Calculator(){}

    @Override
    public double square(double num) {
        return num*num;
    }

    @Override
    public double multip(double mulp1, double mulp2) {
        return mulp1*mulp2;
    }

    @Override
    public double sum(double num1, double num2) {
        return num1+num2;
    }
}
