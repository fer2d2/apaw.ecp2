package es.upm.miw.voting.web.presentation.frontController;

import es.upm.miw.voting.util.http.HttpRequest;
import es.upm.miw.voting.util.http.HttpResponse;
import es.upm.miw.voting.web.presentation.models.Model;
import es.upm.miw.voting.web.presentation.presenters.ThemeManagerPresenter;
import es.upm.miw.voting.web.presentation.presenters.VotingPresenter;
import es.upm.miw.voting.web.presentation.views.ErrorView;
import es.upm.miw.voting.web.presentation.views.ThemeManagerView;
import es.upm.miw.voting.web.presentation.views.View;
import es.upm.miw.voting.web.presentation.views.VotingView;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            model.put("votes", votingPresenter.process(model));
            break;
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            model.put("themes", themeManagerPresenter.process(model));
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";
        String action = request.getParams().get("action");
        String themeName = request.getParams().get("themeName");

        switch (presenter) {
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();

            if ("voteTheme".equals(action)) {
                String value = request.getParams().get("value");
                model.put("value", Integer.parseInt(value));
                model.put("themeName", themeName);
                votingPresenter.voteTheme(model);
                model.put("votes", votingPresenter.process(model));
            } else {
                model.put("error", "Acción no permitida: " + action);
            }

            break;
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            model.put("themeName", themeName);

            if ("createTheme".equals(action)) {
                themeManagerPresenter.createTheme(model);
                model.put("themes", themeManagerPresenter.process(model));

            } else {
                model.put("error", "Acción no permitida: " + action);
            }

            break;
        }
        this.show(nextView, model);
    }

    private void show(String nextView, Model model) {
        View view;

        switch (nextView) {
        case "VotingView":
            view = new VotingView();
            break;
        case "ThemeManagerView":
            view = new ThemeManagerView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }
}
