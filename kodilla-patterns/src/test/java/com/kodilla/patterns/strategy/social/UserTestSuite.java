package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.types.FacebookPublisher;
import com.kodilla.patterns.strategy.social.types.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.users.Millenials;
import com.kodilla.patterns.strategy.social.users.User;
import com.kodilla.patterns.strategy.social.users.YGeneration;
import com.kodilla.patterns.strategy.social.users.ZGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies(){
        //Given
        User mark = new YGeneration("Mark Zuckerberg");
        User jack = new Millenials("Jack Dorsey");
        User evan = new ZGeneration("Evan Spiegel");

        //When
        String markSocial = mark.sharePost();
        System.out.println("Mark's favourite social media: " + markSocial);
        String jackSocial = jack.sharePost();
        System.out.println("Jack's favourite social media: " + jackSocial);
        String evanSocial = evan.sharePost();
        System.out.println("Evan's favourite social media: " + evanSocial);

        //Then
        assertEquals("[Facebook] your favourite social media channel is Facebook",markSocial);
        assertEquals("[Snapchat] your favourite social media channel is Snapchat",evanSocial);
        assertEquals("[Twitter] your favourite social media channel is Twitter",jackSocial);
    }

    @Test
    void testIndividualSharingStrategies(){
        //Given
        User john = new YGeneration("John Kowalsky");

        //When
        String johnSocial = john.sharePost();
        System.out.println("John's favourite social media: " + johnSocial);
        john.setSocialPublisher(new SnapchatPublisher());
        johnSocial = john.sharePost();
        System.out.println("John's new favourite social media: " + johnSocial);

        //Then
        assertNotEquals("[Facebook] your favourite social media channel is Facebook",johnSocial);
        assertEquals("[Snapchat] your favourite social media channel is Snapchat",johnSocial);
    }

}
