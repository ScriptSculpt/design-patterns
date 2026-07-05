package practice.templateMethodPattern;

public abstract class ModelTrainer {
    protected void loadData() {
        System.out.println("Loading data...");
    }

    protected void preprocessData() {
        System.out.println("Preprocessing data...");
    }

    abstract protected void trainModel();
    abstract protected void evaluateModel();
    
    protected void saveModel() {
        System.out.println("Saving model...");
    }

    public final void train() {
        loadData();
        preprocessData();
        trainModel();
        evaluateModel();
        saveModel();
    }
}
