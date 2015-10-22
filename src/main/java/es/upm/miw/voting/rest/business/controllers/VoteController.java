package es.upm.miw.voting.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.voting.rest.business.models.Theme;
import es.upm.miw.voting.rest.business.models.Vote;
import es.upm.miw.voting.rest.business.views.ThemeTransfer;
import es.upm.miw.voting.rest.business.views.VoteTransfer;
import es.upm.miw.voting.rest.data.models.daos.DaoFactory;
import es.upm.miw.voting.rest.data.models.repository.ThemeRepository;

public class VoteController {
    
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
            themeTransfers.add(new ThemeTransfer(theme.getName(), new ThemeRepository().themeAverage(theme)));
        }
        
        return themeTransfers;
    }
}
