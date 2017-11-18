package more;

/*
        "Static factory method is simply a static method that returns an instance of a class." (c) Effective Java, Joshua Bloch.

        The key idea of Factory Method is to delegate decision
        of what instance of class to create inside Factory Method
 */
public class MyFactoryMethod {
    public static void main(String[] args) {

        /*
         the constructor has the same name as the class, which means that you
         can only have one constructor with a given signature.
         Factories are not so constrained, which means you can
         have two different methods that accept the same argument types
         */

        // create different instance
        Answer go = Answer.sayStart();
        System.out.println(go.getStAnswer());
        go = Answer.sayEnd();
        System.out.println(go.getStAnswer());

        //create instance of subclass
        go = Answer.answerSubclass();
        System.out.println(go.getStAnswer());
    }
}

class Answer {
    private String stAnswer;

    public Answer() {

    }

    public Answer(String a) {
        this.stAnswer = a;
    }

    public static Answer sayStart() {
        return new Answer("Start");
    }

    public static Answer sayEnd() {
        return new Answer("End");
    }

    public static Answer answerSubclass() {
        return (new AnswerSubclass("AnswerSubclass"));
    }

    public String getStAnswer() {
        return this.stAnswer;
    }
}

class AnswerSubclass extends Answer {
    private String stAnswer1;

    public AnswerSubclass(String stAnswer) {
        this.stAnswer1 = stAnswer;
    }

    public String getStAnswer() {
        return stAnswer1;
    }
}
