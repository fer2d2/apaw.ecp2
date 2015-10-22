package es.upm.miw.voting.rest.data.models.repository;

import java.util.List;

import es.upm.miw.voting.rest.business.models.Theme;
import es.upm.miw.voting.rest.business.models.Vote;
import es.upm.miw.voting.rest.data.models.daos.DaoFactory;

public class ThemeRepository {
    public double themeAverage(Theme theme) {
        List<Vote> votes = DaoFactory.getFactory().getVoteDao().findByTheme(theme);
        
        double average = 0;
        for (Vote vote : votes) {
            average += vote.getVote();
        }
        
        return (average / votes.size());
    }
}
