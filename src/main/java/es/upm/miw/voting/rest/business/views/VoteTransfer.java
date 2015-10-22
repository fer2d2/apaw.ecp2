package es.upm.miw.voting.rest.business.views;

public class VoteTransfer {

    private String themeName;

    private int voteValue;

    public VoteTransfer(String themeName, int voteValue) {
        this.themeName = themeName;
        this.voteValue = voteValue;
    }

    public String getThemeName() {
        return themeName;
    }

    public int getVoteValue() {
        return voteValue;
    }

}
