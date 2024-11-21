package application;

public class Polinom {
    private Array roots; // корни
    private Array fixedOdds; // кофф а
    private int polynomialDegree;


    public Polinom(Array roots, Array fixedOdds, int polynomialDegree) {
        if(polynomialDegree<0) {
            System.out.println("Ошибка степень полинома не может быть отрицательной");

        }
        else {
            this.roots = roots;
            this.fixedOdds = fixedOdds;
            this.polynomialDegree = polynomialDegree;
            calculateFixedOdds();
        }
    }


    public String showWithFixedOdds(){
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = fixedOdds.getSize()-1;i>=0;i--) {
            if (polynomialDegree - count == 0) {
                stringBuilder.append("(").append(fixedOdds.getElement(i)).append(")");

            } else {
                stringBuilder.append("(").append(fixedOdds.getElement(i)).append(")").append("*X^").append(polynomialDegree - count).append(" + ");
            }
            count++;
        }
        return String.valueOf(stringBuilder);

    }

    public String showWithRoots(){
        StringBuilder stringBuilder = new StringBuilder();
        if(roots.getSize()==0){
            stringBuilder.append("(").append(fixedOdds.getElement(0)).append(")");
        }
        else {
            for (int i = 0; i < roots.getSize(); i++) {
                if (roots.getSize() == 1) {
                    stringBuilder.append("(").append(fixedOdds.getElement(i)).append(")").append(" * (X - (").append(roots.getElement(i)).append("))");
                    return String.valueOf(stringBuilder);
                } else if (i == 0) {
                    stringBuilder.append("(").append(fixedOdds.getElement(fixedOdds.getSize() - 1 - i)).append(")").append(" * (X - (").append(roots.getElement(i)).append(")) *");
                } else if (polynomialDegree - i != 1) {
                    stringBuilder.append(" (X - (").append(roots.getElement(i)).append(")) *");
                } else {
                    stringBuilder.append(" (X - (").append(roots.getElement(i)).append("))");
                }
            }
        }
        return String.valueOf(stringBuilder);
    }

    private void calculateFixedOdds(){
        fixedOdds.resize(polynomialDegree+1);

        for(int i = 0;i<polynomialDegree;i++){
            Number number = roots.getElement(i);

            Array newCoefficients = new Array(polynomialDegree+1);

            for(int j = 0;j<polynomialDegree+1;j++){
                Number num1 = fixedOdds.getElement(j);
                Number res = num1.numberMul(num1,number);
                Number newNumber = newCoefficients.getElement(j);
                res = res.numberDif(newNumber,res);
                newCoefficients.insertElement(j,res);
                if(j+1<polynomialDegree+1){
                    Number sum = new Number();
                    newCoefficients.insertElement(j+1,sum.numberSum(newCoefficients.getElement(j+1),fixedOdds.getElement(j)));
                }
            }
            fixedOdds = newCoefficients;
        }

    }


    public void changeRoot(int index, Number number){
        roots.insertElement(index,number);
        Number temp = fixedOdds.getElement(fixedOdds.getSize()-1);
        for (int i = 0; i < fixedOdds.getSize(); i++) {
            fixedOdds.insertElement(i,new Number(0,0));
        }
        fixedOdds.insertElement(0,temp);
        calculateFixedOdds();
    }

    public void changeFixedOdds(Number number){
        for (int i = 0; i < fixedOdds.getSize(); i++) {
            fixedOdds.insertElement(i,new Number(0,0));
        }
        fixedOdds.insertElement(0,number);
        calculateFixedOdds();
    }

    public int getPolynomialDegree() {
        return polynomialDegree;
    }

    public String calculate(Number number){

        Number result = new Number(1,0);
        Array newArray = new Array(roots.getSize());
        for(int i = 0;i<roots.getSize();i++){
            Number res = new Number();
            res = res.numberDif(number,roots.getElement(i));
            newArray.insertElement(i,res);
        }

        for(int i = 0;i<newArray.getSize();i++){
            result = result.numberMul(result,newArray.getElement(i));
        }


        return String.valueOf(result.numberMul(result,fixedOdds.getElement(fixedOdds.getSize()-1)));
    }




}
