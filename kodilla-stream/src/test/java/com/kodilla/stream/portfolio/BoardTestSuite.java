package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    public void testAddTaskList(){

        Board project = prepareTestData();

        assertEquals(3, project.getTaskLists().size());

    }

    @Test
    public void testAddTaskListFindUsersTask(){
        Board project = prepareTestData();
        User user = new User("developer1", "John Smith");

        List<Task> tasks = project.getTaskLists().stream()
                                    .flatMap(n -> n.getTasks().stream())
                                    .filter(n -> n.getAssignedUser().equals(user))
                                    .collect(Collectors.toList());

        String developer = project.getTaskLists().stream()
                                    .flatMap(n -> n.getTasks().stream())
                                    .filter(n -> n.getAssignedUser().getUsername().equals(user.getUsername()))
                                    .map(n -> n.getAssignedUser().getUsername())
                                    .findFirst().get();

//        assertEquals(user.getUsername(), developer);
//        assertEquals(2, tasks.size());
//        assertEquals(user, tasks.get(0).getAssignedUser());
//        assertEquals(user, tasks.get(1).getAssignedUser());

    }

    @Test
    public void testAddTaskListFindOutDatedTasks(){
        Board project = prepareTestData();

        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                            .filter(undoneTasks::contains)
                            .flatMap(n -> n.getTasks().stream())
                            .filter(n -> n.getDeadline().isBefore(LocalDate.now()))
                            .collect(Collectors.toList());

//        assertEquals(1, tasks.size());
//        assertEquals("HQLs for analysis",tasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListFindLongTasks(){
        Board project = prepareTestData();

        List<TaskList> inProgress = new ArrayList<>();
        inProgress.add(new TaskList("In progress"));
        long tasksInProgress = project.getTaskLists().stream()
                                    .filter(inProgress::contains)
                                    .flatMap(n -> n.getTasks().stream())
                                    .map(Task::getCreated)
                                    .filter(n -> n.compareTo(LocalDate.now().minusDays(10)) <= 0)
                                    .count();

//        assertEquals(2, tasksInProgress);

    }

    @Test
    public void testAddTaskListAverageWorkingOnTask(){
        Board project = prepareTestData();

        List<TaskList> inProgress = new ArrayList<>();
        inProgress.add(new TaskList("In progress"));
        double elementsAverage = project.getTaskLists().stream()
                                .filter(inProgress::contains)
                                .flatMap(n -> n.getTasks().stream())
                                .map(Task::getCreated)
                                .map(n -> LocalDate.now().minusDays(n.getDayOfMonth()))
                                .map(n -> n.getDayOfMonth()).mapToDouble(Integer::doubleValue).average().getAsDouble();

        double elementsSum = project.getTaskLists().stream()
                .filter(inProgress::contains)
                .flatMap(n -> n.getTasks().stream())
                .map(Task::getCreated)
                .map(n -> LocalDate.now().minusDays(n.getDayOfMonth()))
                .map(n -> n.getDayOfMonth()).mapToDouble(Integer::doubleValue).sum();

        double elementsAmount = project.getTaskLists().stream()
                .filter(inProgress::contains)
                .flatMap(n -> n.getTasks().stream())
                .map(Task::getCreated)
                .map(n -> LocalDate.now().minusDays(n.getDayOfMonth()))
                .map(n -> n.getDayOfMonth()).count();

//        assertEquals(4.0, elementsAverage);
//        assertEquals(12, elementsSum);
//        assertEquals(3, elementsAmount);
    }

    private Board prepareTestData(){
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(2),
//                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
//                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(4),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now().minusDays(6),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

}
