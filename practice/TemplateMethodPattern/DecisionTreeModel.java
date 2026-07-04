package practice.TemplateMethodPattern;

public class DecisionTreeModel extends ModelTrainer {

    @Override
    protected void evaluateModel() {
        System.out.println("Evaluating Decision Tree Model...");
    }

    @Override
    protected void trainModel() {
        System.out.println("Training Decision Tree Model...");
    }

    @Override
    protected void saveModel() {
        System.out.println("Saving Decision Tree Model...");
    }
    
}
