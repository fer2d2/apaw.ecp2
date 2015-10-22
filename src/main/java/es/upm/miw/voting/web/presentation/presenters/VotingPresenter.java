package es.upm.miw.voting.web.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.voting.rest.business.controllers.ThemeController;
import es.upm.miw.voting.rest.business.controllers.VoteController;
import es.upm.miw.voting.rest.business.views.ThemeTransfer;
import es.upm.miw.voting.rest.business.views.VoteTransfer;
import es.upm.miw.voting.web.presentation.models.Model;

public class VotingPresenter {

    public List<String> process(Model model) {
        return this.getAverages(model);
    }

    public void voteTheme(Model model) {
        VoteTransfer voteModel = new VoteTransfer((String) model.get("themeName"), (int) model.get("value"));
        new VoteController().voteTheme(voteModel);
    }
    
    private List<String> getAverages(Model model) {
        List<ThemeTransfer> themeTransfers = new VoteController().getThemesAndAverages();
        
        List<String> averages = new ArrayList<>();
        for (ThemeTransfer themeTransfer : themeTransfers) {
            averages.add("[themeName=" + themeTransfer.getThemeName() + ", average=" + themeTransfer.getThemeAverage() + "]");
        }
        
        return averages;
        
    }

}
