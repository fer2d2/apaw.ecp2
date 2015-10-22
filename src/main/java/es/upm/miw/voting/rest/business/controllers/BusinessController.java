package es.upm.miw.voting.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.voting.rest.business.models.Theme;
import es.upm.miw.voting.rest.business.models.Vote;
import es.upm.miw.voting.rest.business.views.ThemeTransfer;
import es.upm.miw.voting.rest.business.views.VoteTransfer;
import es.upm.miw.voting.rest.data.models.daos.DaoFactory;
import es.upm.miw.voting.rest.data.models.daos.ThemeDao;
import es.upm.miw.voting.rest.data.models.daos.VoteDao;


public class BusinessController {
    
    public void voteTheme(VoteTransfer voteTransfer) {
        int id = DaoFactory.getFactory().getVoteDao().findAll().size() + 1;
        Theme chosenTheme = DaoFactory.getFactory().getThemeDao().findByName(voteTransfer.getThemeName());
        
        DaoFactory.getFactory().getVoteDao().create(new Vote(id, voteTransfer.getVoteValue(), chosenTheme));
    }

    public List<ThemeTransfer> getThemesAndAverages() {
        List<String> themesNames = DaoFactory.getFactory().getThemeDao().findAllNames();
        List<Theme> themes = new ArrayList<Theme>();
        
        for(String themeName : themesNames) {
            themes.add(DaoFactory.getFactory().getThemeDao().findByName(themeName));
        }
        
        List<ThemeTransfer> themeTransfers = new ArrayList<ThemeTransfer>();
        
        for(Theme theme : themes) {
            themeTransfers.add(new ThemeTransfer(theme.getName(), this.themeAverage(theme)));
        }
        
        return themeTransfers;
    }

    private double themeAverage(Theme theme) {
        List<Vote> votes = DaoFactory.getFactory().getVoteDao().findByTheme(theme);
        
        int average = 0;
        for (Vote vote : votes) {
            average += vote.getVote();
        }
        
        return (average / votes.size());
    }
    
    public List<String> getThemes() {
        return DaoFactory.getFactory().getThemeDao().findAllNames();
    }
    
    public void createTheme(String themeName) {
        int id = DaoFactory.getFactory().getThemeDao().findAll().size() + 1;
        DaoFactory.getFactory().getThemeDao().create(new Theme(id, themeName));
    }


    
}
