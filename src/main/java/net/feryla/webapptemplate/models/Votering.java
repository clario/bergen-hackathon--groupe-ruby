package net.feryla.webapptemplate.models;

/**
 *
 * @author sondre
 */
public class Votering {
    
    private Representative rep;
   
    private int vote;

    public Votering() {
    }

    public Representative getRep() {
        return rep;
    }

    public void setRep(Representative rep) {
        this.rep = rep;
    }

    /***
     * 1 Ikkje tilstede, 2 For, 3 Mot
     * @return 
     */
    public int getVote() {
        return vote;
    }

     /***
     * 1 Ikkje tilstede, 2 For, 3 Mot
     * 
     */
    public void setVote(int vote) {
        this.vote = vote;
    }
 
    
}
