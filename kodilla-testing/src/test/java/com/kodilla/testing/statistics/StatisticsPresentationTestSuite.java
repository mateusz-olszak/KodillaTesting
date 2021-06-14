package com.kodilla.testing.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StatisticsPresentationTestSuite {

    @Mock
    private Statistics statistics;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("TestSuite: start");
    }

    @AfterAll
    public static void afterAll(){
        Statistics statistics = Mockito.mock(Statistics.class);
        StatisticsPresentation statisticsPresentation = new StatisticsPresentation();
        Mockito.when(statistics.usersNames()).thenReturn(prepareDataForUsers(30));
        Mockito.when(statistics.postsCount()).thenReturn(35);
        Mockito.when(statistics.commentsCount()).thenReturn(55);
        statisticsPresentation.calculateAdvStatistics(statistics);

        System.out.println(statisticsPresentation.showStatistics());
        System.out.println("TestSuite: end");
    }

    @Test
    public void testCountUsersOf0(){
        StatisticsPresentation statisticsPresentation = new StatisticsPresentation();
        Mockito.when(statistics.usersNames()).thenReturn(prepareDataForUsers(0));
        statisticsPresentation.calculateAdvStatistics(statistics);

        List<String> resultList = statisticsPresentation.getUsers();

        Assertions.assertEquals(0, resultList.size());

    }

    @Test
    public void testCountUsersOf100(){
        StatisticsPresentation statisticsPresentation = new StatisticsPresentation();
        Mockito.when(statistics.usersNames()).thenReturn(prepareDataForUsers(100));
        statisticsPresentation.calculateAdvStatistics(statistics);

        List<String> resultList = statisticsPresentation.getUsers();

        Assertions.assertEquals(100, resultList.size());
    }

    @Test
    public void testCountPostsOf0(){
        StatisticsPresentation statisticsPresentation = new StatisticsPresentation();
        Mockito.when(statistics.postsCount()).thenReturn(0);
        statisticsPresentation.calculateAdvStatistics(statistics);

        int result = statisticsPresentation.getPostsQuantity();

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCountPostsOf1000(){
        StatisticsPresentation statisticsPresentation = new StatisticsPresentation();
        Mockito.when(statistics.postsCount()).thenReturn(1000);
        statisticsPresentation.calculateAdvStatistics(statistics);

        int result = statisticsPresentation.getPostsQuantity();

        Assertions.assertEquals(1000, result);
    }

    @Test
    public void testCountCommentsOf0(){
        StatisticsPresentation statisticsPresentation = new StatisticsPresentation();
        Mockito.when(statistics.commentsCount()).thenReturn(0);
        statisticsPresentation.calculateAdvStatistics(statistics);

        int result = statisticsPresentation.getCommentsQuantity();

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testCommentsLessThanPosts(){
        StatisticsPresentation statisticsPresentation = new StatisticsPresentation();
        Mockito.when(statistics.commentsCount()).thenReturn(20);
        Mockito.when(statistics.postsCount()).thenReturn(40);
        statisticsPresentation.calculateAdvStatistics(statistics);

        double result = statisticsPresentation.getAverageCommentsPerPost();

        Assertions.assertEquals(0.5, result);
    }

    @Test
    public void testCommentsMoreThanPosts(){
        StatisticsPresentation statisticsPresentation = new StatisticsPresentation();
        Mockito.when(statistics.commentsCount()).thenReturn(20);
        Mockito.when(statistics.postsCount()).thenReturn(10);
        statisticsPresentation.calculateAdvStatistics(statistics);

        double result = statisticsPresentation.getAverageCommentsPerPost();

        Assertions.assertEquals(2, result);
    }

    private static List<String> prepareDataForUsers(int n){
        List<String> usernames = new ArrayList<>();
        for (int i=0; i<n; i++){
            usernames.add("Name"+i);
        }
        return usernames;
    }

}
