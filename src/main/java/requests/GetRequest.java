package requests;

import responses.Response;

public class GetRequest implements Request{

    private String data;
    public GetRequest(String data) {
        this.data = data;
    }

    @Override
    public Response solve() {
        return null;
    }
}
