package es.upm.miw.voting;

import es.upm.miw.voting.util.http.HttpMethod;
import es.upm.miw.voting.util.http.HttpRequest;
import es.upm.miw.voting.util.http.HttpResponse;
import es.upm.miw.voting.util.http.HttpStatus;
import es.upm.miw.voting.web.presentation.frontController.FrontController;

public class Server {

    public HttpResponse send(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        if (HttpMethod.GET.equals(request.getMethod())) {
            new FrontController().doGet(request, response);
        } else if (HttpMethod.POST.equals(request.getMethod())) {
            new FrontController().doPost(request, response);
        }
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
