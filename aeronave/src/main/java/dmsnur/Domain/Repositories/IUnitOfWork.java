package dmsnur.Domain.Repositories;

import dmsnur.SharedKernel.http.Exception.HttpException;

public interface IUnitOfWork {
    //TODO: change void for task
    public void commit() throws HttpException;
}
