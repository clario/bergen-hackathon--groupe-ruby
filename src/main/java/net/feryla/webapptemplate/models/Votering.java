package net.feryla.webapptemplate.models;

/**
 *
 * @author sondre
 */
public class Votering {
    
    private Representative rep;
    private Vote vote;

    public Votering() {
    }

    public Representative getRep() {
        return rep;
    }

    public void setRep(Representative rep) {
        this.rep = rep;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
 
    
}
