package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ToDoListTest extends TestCase {
   // Define Test Fixtures
   private ToDoList todos;
   private Task unfinishedTask;
   private Task finishedTask;


   public ToDoListTest() {
      super();
   }

   @Before
   public void setUp() throws Exception {
      // Initialise Test Fixtures
      todos = new ToDoList();
      unfinishedTask = new Task("unfinishedTask", false);
      finishedTask = new Task("finishedTask", true);
      todos.addTask(finishedTask);
      todos.addTask(unfinishedTask);
   }

   @After
   public void tearDown() throws Exception {
      // Uninitialise test Fixtures
      todos = null;
      unfinishedTask = null;
      finishedTask = null;
      System.out.println("tearDown");
   }

   @Test
   public void testAddUnifishedTask() {
      Task newUnfinished = new Task("task1", false);
      todos.addTask(newUnfinished);
      assertTrue(todos.getAllTasks().contains(newUnfinished));
   }

   @Test
   public void testAddFishedTask() {
      Task newFinished = new Task("task2", true);
      todos.addTask(newFinished);
      assertTrue(todos.getAllTasks().contains(newFinished));
   }

   @Test
   public void testGetStatusFalse() {
      assertFalse(todos.getStatus(unfinishedTask.getDescription()));
   }

   @Test
   public void testGetStatusTrue() {
      assertTrue(todos.getStatus(finishedTask.getDescription()));
   }

   @Test
   public void testRemoveFinishedTask() {
      assertEquals(finishedTask, todos.removeTask(finishedTask.getDescription()));
   }

   @Test
   public void testRemoveUnfinishedTask() {
      assertEquals(unfinishedTask, todos.removeTask(unfinishedTask.getDescription()));
   }

   @Test
   public void testGetCompletedTasksWithOneCompleted() {
      assertEquals(1, todos.getCompletedTasks().size());
   }

   @Test
   public void testGetCompletedTasksWithZeroCompleted() {
      todos.removeTask(finishedTask.getDescription());
      assertEquals(0, todos.getCompletedTasks().size());
   }
}
