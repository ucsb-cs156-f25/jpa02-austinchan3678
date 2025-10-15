package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Austin", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("austinchan3678", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team_name() {
        Team  t = Developer.getTeam();
        assertEquals("f25-06", t.getName());
    }
    
    @Test
    public void getTeam_returns_correct_team_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("ABHIRAM"), "Team does not contain ABHIRAM");
        assertTrue(t.getMembers().contains("ANDREW ZHUO"), "Team does not contain ANDREW ZHUO");
        assertTrue(t.getMembers().contains("JULIA"), "Team does not contain JULIA");
        assertTrue(t.getMembers().contains("AUSTIN"), "Team does not contain AUSTIN");
        assertTrue(t.getMembers().contains("LONGJIAO"), "Team does not contain LONGJIAO");
        assertTrue(t.getMembers().contains("NATALIE MARIE"), "Team does not contain NATALIE MARIE");
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
