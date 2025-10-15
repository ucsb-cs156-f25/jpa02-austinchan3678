package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void equals_returns_correct_same_object() {
        Team team2 = new Team("team2");
        assertEquals(true, team.equals(team));
        assertEquals(false, !team.equals(team));
        assertEquals(true, !team.equals(team2));
        assertEquals(false, team.equals(team2));

    }

    @Test 
    public void equals_returns_correct_different_class() {
        Object obj = new Object();
        assertEquals(true, !team.equals(obj));
        assertEquals(false, team.equals(obj));

    }
    @Test
    public void equals_returns_correct_same_team() {
        Team team0 = new Team("test-team");
        assertEquals(true, team.equals(team0));
        assertEquals(false, !team.equals(team0));


        Team team1 = new Team("team1");
        Team team2 = new Team("team1"); // same as team 1
        Team team3 = new Team("team1"); // same name but different members
        Team team4 = new Team("team2"); // different name and same members
        Team team5 = new Team("team2"); // different name and different members
        assertEquals(true, team1.equals(team2));
        assertEquals(false, !team1.equals(team2));
        team1.addMember("Austin");
        team2.addMember("Austin");
        assertEquals(true, team1.equals(team2));
        assertEquals(false, !team1.equals(team2)); // team 1 and team 2 are equal now
        assertEquals(false, team1.equals(team3));
        assertEquals(true, !team1.equals(team3));
        team4.addMember("Austin");
        assertEquals(false, team1.equals(team4));
        assertEquals(true, !team1.equals(team4));
        assertEquals(false, team1.equals(team5));
        assertEquals(true, !team1.equals(team5));
        assertEquals(team.toString(), team.toString());


    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test  
    public void hashCode_returns_correct_hashcode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());


        // instantiate t as a Team object
        int result = t1.hashCode();
        int expectedResult = 130294;
        assertEquals(expectedResult, result);
    }

}
