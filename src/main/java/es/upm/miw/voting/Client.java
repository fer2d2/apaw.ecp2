package es.upm.miw.voting;
public class Client {

    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
