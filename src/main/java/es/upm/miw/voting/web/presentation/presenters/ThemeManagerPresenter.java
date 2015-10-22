package es.upm.miw.voting.web.presentation.presenters;

import java.util.List;

import es.upm.miw.voting.rest.business.controllers.BusinessController;
import es.upm.miw.voting.web.presentation.models.Model;

public class ThemeManagerPresenter {

    public List<String> process(Model model) {
        return this.showThemes(model);
    }

    public void createTheme(Model model) {
        new BusinessController().createTheme((String) model.get("themeName"));
    }

    private List<String> showThemes(Model model) {
        return new BusinessController().getThemes();
    }
}
