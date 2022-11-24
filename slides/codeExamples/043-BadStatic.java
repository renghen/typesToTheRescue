package slides.codeExamples;

import java.util.ArrayList;

class Animal {
};

class Dog extends Animal {
};

class Wolf extends Dog {
};

class F<T extends Animal> {
    public static void println(ArrayList<? extends Dog> numbers) {        

        for (Dog num : numbers)
            System.out.println(num);        
    }

}
