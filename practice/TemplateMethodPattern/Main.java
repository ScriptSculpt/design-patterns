package practice.TemplateMethodPattern;

public class Main {
    public static void main(String[] args) {
        ModelTrainer decisionTreeTrainer = new DecisionTreeModel();
        System.out.println("Training Decision Tree Model:");
        decisionTreeTrainer.train();
        System.out.println(" ---------------------------------------------------- ");
        ModelTrainer neuralNetworkTrainer = new NeuralNetworkModel();
        System.out.println("Training Neural Network Model:");
        neuralNetworkTrainer.train();
    }
}
