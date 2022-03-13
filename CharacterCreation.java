import java.util.ArrayList;
import java.util.Scanner;
public class CharacterCreation {
    ArrayList<Task> taskHolder;
    Scanner input = new Scanner(System.in);
    Character player;

    public CharacterCreation() {
        taskHolder = new ArrayList<Task>();
    }

    private String askName() {
        System.out.print("Enter the character name: ");

        return input.nextLine();
    }

    private void showAllTasks() {
        for (int i = 0; i < taskHolder.size(); i++)
            System.out.format("%d. %s\n", i, taskHolder.get(i).getObjective());
    }

    public void taskCompleted(Task task) {
        player.setExp(player.getExp() + task.getExp());
        player.checkLevel();
        taskHolder.remove(task);
    }

    public void askForTask() {
        System.out.println("Enter the task name: ");
        String taskName = input.nextLine();
        System.out.println("Enter how much exp this task will be worth: ");
        int taskExp = input.nextInt();


        Task task = new Task(taskName, taskExp);
        taskHolder.add(task);
    }

    public void createCharacter() {
        String name = askName();
        player = new Character(name);
        System.out.printf("Character %s created.", player.getName());
    }

    public void clearCompletedTasks() {
        for (int i = 0; i < taskHolder.size(); i++) // since size of taskHolder will change on each iteration, check for bugs.
            if (!taskHolder.get(i).isCompleted()) // removes task if not completed
                taskHolder.remove(i);
    }

    public Character getCharacter() {
        return this.player;
    }

    private void promptMenu() {
        System.out.println("Select an option from the following: ");
        System.out.println("1. Add task");
        System.out.println("2. Start a battle");
        System.out.println("3. Hand in task");
        System.out.println("4. Exit");
    }

    public void menu() {

        Scanner input = new Scanner(System.in);
        promptMenu();
        int option = input.nextInt();
        while (option != 1 && option != 2 && option != 3 && option != 4) {
            System.out.println("Please enter either 1, 2, 3, or 4!");
            option = input.nextInt();
        }

        if (option == 1) {
            askForTask();
        }

        if (option == 2) {
            Monster monster = new Monster("Monster");
            BattleFrame battle = new BattleFrame(player, monster);
            battle.fightTurns();
        }
        if (option == 3) {
            System.out.println("Avaliable Tasks:");
            showAllTasks();
            System.out.println("Select the task to hand in:");
            int taskSelected = input.nextInt();
            Task selectedTask = taskHolder.get(taskSelected);
            while (!taskHolder.contains(selectedTask)) {
                System.out.println("Please select a valid option");
                option = input.nextInt();
            }
            taskCompleted(selectedTask);
            System.out.printf("Task: %d completed! %d xp has been rewarded!\n", taskSelected, selectedTask.getExp());
        }

        if (option == 4) {
            System.exit(0);
        }
    }
}
