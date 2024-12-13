package com.example.calcolatrice.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Calcolatrice {
    private List<Double> operands;

    private String operator;

    public Double makeOperation(){
        Double retVal = 0.;
        switch (operator){
            case "+":
                retVal = operands.stream().mapToDouble(Double::doubleValue).sum();

            case "*":
                Double total = 1d;
                for(Double operand:operands)
                    total*=operand;
                retVal = total;

            case "/":
                List<Double> noZeroOperands = operands.stream()
                        .filter(c-> c!=0)
                        .toList();
                Double res = noZeroOperands.getFirst();
                noZeroOperands.removeFirst();
                for(Double nonZeroOperand : noZeroOperands)
                    res/=nonZeroOperand;
                retVal = res;

            case "-":
                Double subRes = 0.;
                for(Double operand : operands)
                    subRes-=operand;
                retVal = subRes;

        }
        return retVal;
    }
}
