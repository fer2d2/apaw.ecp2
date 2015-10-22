package es.upm.miw.voting.application;

import es.upm.miw.voting.util.http.HttpRequest;
import es.upm.miw.voting.util.http.HttpResponse;

public class Client {

    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
