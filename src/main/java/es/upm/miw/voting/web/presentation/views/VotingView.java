package es.upm.miw.voting.web.presentation.views;

import es.upm.miw.voting.util.IO.OutputGenerator;
import es.upm.miw.voting.web.presentation.models.Model;

public class VotingView implements View {

    @Override
    public void show(Model model) {
        OutputGenerator outputGenerator = new OutputGenerator();
        outputGenerator.printListWithSubtitle("Temas", "ThemeTransfer", model.get("votes"));
    }

}
