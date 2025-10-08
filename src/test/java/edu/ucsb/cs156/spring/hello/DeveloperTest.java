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
        assertTrue(t.getMembers().contains("Austin"), "Team does not contain Austin");
        assertTrue(t.getMembers().contains("Helen"), "Team does not contain Helen");
        assertTrue(t.getMembers().contains("Andrew"), "Team does not contain Andrew");
        assertTrue(t.getMembers().contains("Abriham"), "Team does not contain Abriham");
        assertTrue(t.getMembers().contains("Julia"), "Team does not contain Julia");
        assertTrue(t.getMembers().contains("Natalie"), "Team does not contain Natalie");
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
