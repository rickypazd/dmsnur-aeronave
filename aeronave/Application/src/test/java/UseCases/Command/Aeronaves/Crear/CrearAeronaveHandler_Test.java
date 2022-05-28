package UseCases.Command.Aeronaves.Crear;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.AeronaveDto;
import Event.AeronaveCreado;
import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;

public class CrearAeronaveHandler_Test {

    IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
    IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);
    IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

    public CrearAeronaveHandler_Test() {
    }
    @Before
    public void setUp() {
        
    }

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
