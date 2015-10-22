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
import es.upm.miw.voting.rest.data.models.repository.ThemeRepository;


public class ThemeController {
    
    public List<String> getThemes() {
        return DaoFactory.getFactory().getThemeDao().findAllNames();
    }
    
    public void createTheme(String themeName) {
        int id = DaoFactory.getFactory().getThemeDao().findAll().size() + 1;
        DaoFactory.getFactory().getThemeDao().create(new Theme(id, themeName));
    }
    
}
