package mediator;

import java.lang.reflect.InvocationTargetException;

import http.Exception.HttpException;

public interface Mediator {

    public <T, E> Response<E> send(Request<T> request) throws HttpException;

    public Response notify(Notification notification) throws HttpException;
}
