package dmsnur.Domain.Model.Aeronaves.ValueObjects;

import dmsnur.SharedKernel.core.BussinessRuleValidateExeption;
import dmsnur.SharedKernel.core.ValueObject;
import dmsnur.SharedKernel.rule.StringNotNullOrEmptyRule;

public class MatriculaAeronave extends ValueObject {
    private String value;

    public MatriculaAeronave(String Value) throws BussinessRuleValidateExeption {
        CheckRule(new StringNotNullOrEmptyRule(Value));
        this.value = Value;
    }
    @Override
    public String toString() {
        return value;
    }
}
