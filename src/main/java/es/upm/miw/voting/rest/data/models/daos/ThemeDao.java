package es.upm.miw.voting.rest.data.models.daos;

import java.util.List;

import es.upm.miw.voting.rest.business.models.Theme;

public interface ThemeDao {

    Theme findByName(String themeName);

    List<String> findAllNames();

}
