package es.upm.miw.voting.rest.business.controllers;

import java.util.List;

import es.upm.miw.voting.rest.business.models.Theme;
import es.upm.miw.voting.rest.data.models.daos.DaoFactory;

public class ThemeController {

    public List<String> getThemes() {
        return DaoFactory.getFactory().getThemeDao().findAllNames();
    }

    public void createTheme(String themeName) {
        int id = DaoFactory.getFactory().getThemeDao().findAll().size() + 1;
        DaoFactory.getFactory().getThemeDao().create(new Theme(id, themeName));
    }

}
