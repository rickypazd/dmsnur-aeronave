package UseCases.Command.Aeronaves.Editar;

import static org.mockito.ArgumentMatchers.any;
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

public class EditarAeronaveHandler_Test {

    IAeronaveFactory aeronaveFactory = Mockito.mock(IAeronaveFactory.class);
    IAeronaveRepository aeronaveRepository = Mockito.mock(IAeronaveRepository.class);
    IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

    @Before
    public void setUp() {

    }

    @Test
    public void HandleCorrectly() throws HttpException {
        String matricula = "ASD";
        Aeronave a = new Aeronave(matricula);
        when(aeronaveRepository.FindByKey(any())).thenReturn(a);

        EditarAeronaveHandler handler = new EditarAeronaveHandler(aeronaveFactory, aeronaveRepository, _unitOfWork);

        AeronaveDto aeronaveDto = new AeronaveDto();
        aeronaveDto.matricula = matricula;

        EditarAeronaveCommand command = new EditarAeronaveCommand(aeronaveDto);
        Aeronave resp = handler.handle(command);
        Assert.assertEquals(matricula, resp.matricula);
    }

    @Test
    public void HandleFailed() throws HttpException {
        when(aeronaveRepository.FindByKey(any())).thenReturn(null);

        EditarAeronaveHandler handler = new EditarAeronaveHandler(aeronaveFactory, aeronaveRepository, _unitOfWork);

        AeronaveDto aeronaveDto = new AeronaveDto();
        aeronaveDto.matricula = "ABC";

        EditarAeronaveCommand command = new EditarAeronaveCommand(aeronaveDto);
        try {
            Aeronave resp = handler.handle(command);
        } catch (HttpException e) {
            Assert.assertEquals(400, e.getCode());

        }

    }
}
