package es.upm.miw.voting.web.presentation.frontController;

import es.upm.miw.voting.util.http.HttpRequest;
import es.upm.miw.voting.util.http.HttpResponse;
import es.upm.miw.voting.web.presentation.models.Model;
import es.upm.miw.voting.web.presentation.views.ErrorView;
import es.upm.miw.voting.web.presentation.views.ThemeManagerView;
import es.upm.miw.voting.web.presentation.views.View;
import es.upm.miw.voting.web.presentation.views.VotingView;


public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        
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
