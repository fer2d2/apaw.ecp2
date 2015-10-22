package es.upm.miw.voting.web.presentation.views;

import java.util.List;

import es.upm.miw.voting.util.IO.OutputGenerator;
import es.upm.miw.voting.web.presentation.models.Model;

public class ThemeManagerView implements View {

    @Override
    public void show(Model model) {
        OutputGenerator outputGenerator = new OutputGenerator();
        outputGenerator.printList("Temas", model.get("themes"));
    }

}
