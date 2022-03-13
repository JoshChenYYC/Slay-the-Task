public class Task {
    String objective;
    int exp;
    boolean completed;

    public Task(String objective, int exp) {
        this.objective = objective;
        this.exp = exp;
        completed = false;
    }


    private void taskEdit(String objective, int exp) {
        this.objective = objective;
        this.exp = exp;
    }
    public String getObjective() {return this.objective;}
    public int getExp() {return this.exp;}
    public boolean isCompleted() {return this.completed;}
}

