package application;

public class Array {
    private Number[] elements;
    private int size;
    private int capacity;


    public Array() {
        this.size = 0;
        this.capacity = 5;
        this.elements = new Number[capacity];
        for(int i = 0;i<capacity;i++){
            elements[i] = new Number();
        }
    }

    public Array(int size) {
        this.size = size;
        this.capacity = size*2;
        this.elements = new Number[capacity];
        for(int i = 0;i<capacity;i++){
            elements[i] = new Number();
        }
    }

    public void input(){
        for (int i = 0; i < elements.length; i++) {
            System.out.print("Введите элемент массива в виде a + bi,(если какая-то часть комплексного числа отсутствует то введите вместо нее 0): ");
            Number value = new Number();
            value = value.scannerNumber();
            elements[i] = value;
        }
        size = capacity;

    }

    public void resize(int newSize){
        Number[] numbers = new Number[newSize];
        for(int i = 0;i<newSize;i++){
            if(elements.length>i) {
                numbers[i] = elements[i];
            }
            else {
                numbers[i] = new Number();
            }
        }
        elements = numbers;
        capacity = newSize;
    }

    public int getSize() {
        return size;
    }

    public void showArray(){
        for (int i = 0;i<size;i++) {
            if(size == 1){
                System.out.print("[" + elements[i] + "]");
                return;
            }
            if(i == 0){
                System.out.print("[" + elements[i] + ", ");
            }
            else if(i==size-1){
                System.out.print(elements[i] + "]");
            }
            else {
                System.out.print(elements[i] + ", ");
            }
        }
        System.out.println();
    }

    public void calculate(){
        int numberOfValues = elements.length;
        if(numberOfValues==0){
            System.out.println("The array is empty");
            return;
        }
        Number sum = new Number();
        for (Number element : elements) {
            sum = sum.numberSum(sum,element);
        }
        Number result1 = sum.numberDiv(sum,numberOfValues);
        System.out.println("The mean deviation is equal to " + result1);

        sum = new Number();
        Number difference = new Number();
        Number pow = new Number();
        for (Number element : elements) {
            difference = difference.numberDif(element,result1);
            pow = pow.numberSquare(difference);
            sum = sum.numberSum(sum,pow);
        }
        Number result2 = sum.numberDiv(sum,elements.length-1);
        System.out.println("The standard deviation is equal to "+ result2.numberSqrt(result2));
    }

    public void sortAscending(){
        for(int i = 0;i<elements.length-1;i++){
            boolean swapped = true;
            for(int j = 0; j<elements.length-1-i;j++){
                Number temp;
                if(elements[j].comparisonNumber(elements[j],elements[j+1]) == 1){
                    temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                    swapped = false;
                }
            }
            if(swapped){
                break;
            }
        }
    }

    public void sortDescending(){
        for(int i = 0;i<elements.length-1;i++){
            boolean swapped = true;
            for(int j = 0; j<elements.length-1-i;j++){
                Number temp;
                if(elements[j].comparisonNumber(elements[j],elements[j+1]) == -1){
                    temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                    swapped = false;
                }
            }
            if(swapped){
                break;
            }
        }
    }

    public void elementReplacement(int index){
        if(index<0 || index>=size){
            System.out.println("Ошибка индекс вне диапазона");
            return;
        }
        Number newNumber = new Number();
        System.out.print("Введите новое значение: ");
        elements[index] = newNumber.scannerNumber();

    }

    public Number getElement(int index){
        if(index<0 || index>=capacity){
            System.out.println("Ошибка индекс вне диапазона");
            return null;
        }
         return elements[index];
    }


    public void insertElement(int index, Number number){
        if(index<0 || index>=capacity){
            System.out.println("Ошибка индекс вне диапазона");
            return;
        }
        elements[index] = number;
    }





}
