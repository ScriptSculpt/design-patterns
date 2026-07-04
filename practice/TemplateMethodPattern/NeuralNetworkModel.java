package practice.TemplateMethodPattern;

public class NeuralNetworkModel extends ModelTrainer {

    @Override
    protected void trainModel() {
        System.out.println("Training Neural Network Model...");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("Evaluating Neural Network Model...");
    }
    
}
