package requests;

import exceptions.MethodParseError;


import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

public class RequestParser {
    public RequestParser() {

    }

    public Request parseRequest(String data) throws MethodParseError {
        StringTokenizer parse = new StringTokenizer(data);
        String method = parse.nextToken().toUpperCase();
        if (method.equals("GET"))
            return new GetRequest(data);
        return null;
    }

}
