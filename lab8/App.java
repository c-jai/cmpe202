/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

/**
 *  Main App Class for Displaying Screen.
 */
public class App {

    private Screen screen;
    private CreditCardNum num;
    private CreditCardExp exp;
    private CreditCardCVC cvc;
    private int count;
    private CreditCardNumDecorator numberDecorator;
    private CreditCardExpDecorator expDecorator;
    
    public App() {

        screen = new Screen();
        num = new CreditCardNum();
        exp = new CreditCardExp();
        cvc = new CreditCardCVC();
        numberDecorator = new CreditCardNumDecorator(num);
        expDecorator = new CreditCardExpDecorator(exp);

        screen.addSubComponent(numberDecorator);
        screen.addSubComponent(expDecorator);
        screen.addSubComponent(cvc);

        count = 0;

    }

    public String display() {
        String output = "";
        output += "========================================\n";
        output += screen.name() + "\n";
        output += "========================================\n";
        output += "\n\n\n\n";
        output += screen.display() + "\n";
        output += "\n\n\n\n";
        output += "========================================\n";
        return output;
    }

    public void key(String ch) {
    	if("X".equals(ch))
    		count--;
    	else
    		count++;
        screen.key(ch, count);
    }

}

