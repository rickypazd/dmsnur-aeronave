package dmsnur.Application.UseCases.Command.Aeronaves.Crear;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import dmsnur.Application.Dto.AeronaveDto;
import dmsnur.Domain.Event.AeronaveCreado;
import dmsnur.Domain.Factories.IAeronaveFactory;
import dmsnur.Domain.Model.Aeronaves.Aeronave;
import dmsnur.Domain.Repositories.IAeronaveRepository;
import dmsnur.Domain.Repositories.IUnitOfWork;
import dmsnur.SharedKernel.http.Exception.HttpException;

public class CrearAeronaveHandler_Test {
    IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
    IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);
    IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

    
    @Test
    public void HandleCorrectly() throws HttpException {
        String matricula = "ASD";
        Aeronave a = new Aeronave(matricula);
        when(aeronaveFactory.Create(matricula)).thenReturn(a);

        CrearAeronaveHandler handler = new CrearAeronaveHandler(aeronaveFactory, aeronaveRepository, _unitOfWork);

        AeronaveDto aeronaveDto = new AeronaveDto();
        aeronaveDto.matricula = matricula;

        CrearAeronaveCommand command = new CrearAeronaveCommand(aeronaveDto);
        Aeronave resp =  handler.handle(command);

        verify(aeronaveRepository).Create(resp);
        verify(_unitOfWork).commit();

        Assert.assertEquals(AeronaveCreado.class, resp.domainEvents.get(0).getClass());
        Assert.assertEquals(matricula,resp.matricula);



    }
}
