package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void equals_returns_correct_bool() {
        Team copy = new Team("test-team");
        Team membered = new Team("test-team");
        membered.addMember("Austin");
        Team typo = new Team("tst-team");
        assertEquals(true, team.equals(team));
        assertEquals(false, team.equals(1));
        assertEquals(true, team.equals(copy));
        assertEquals(false, team.equals(membered));
        assertEquals(false, team.equals(typo));
    }

    @Test
    public void hashCode_returns_correct_hash() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
}
