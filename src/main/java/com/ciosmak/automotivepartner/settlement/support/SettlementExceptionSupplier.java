package com.ciosmak.automotivepartner.settlement.support;

import com.ciosmak.automotivepartner.settlement.support.exception.*;

import java.util.function.Supplier;

public class SettlementExceptionSupplier
{
    public static Supplier<BugAlreadyReportedException> bugAlreadyReported()
    {
        return BugAlreadyReportedException::new;
    }

    public static Supplier<EmptyNetAmountException> emptyNetAmount()
    {
        return EmptyNetAmountException::new;
    }

    public static Supplier<EmptyTipAmountException> emptyTipAmount()
    {
        return EmptyTipAmountException::new;
    }

    public static Supplier<IncorrectNetAmountException> incorrectNetAmount()
    {
        return IncorrectNetAmountException::new;
    }

    public static Supplier<IncorrectOptionalFactorException> incorrectOptionalFactor()
    {
        return IncorrectOptionalFactorException::new;
    }

    public static Supplier<IncorrectOptionalPenaltyAmountException> incorrectOptionalPenaltyAmount()
    {
        return IncorrectOptionalPenaltyAmountException::new;
    }

    public static Supplier<IncorrectTipAmountException> incorrectTipAmount()
    {
        return IncorrectTipAmountException::new;
    }

    public static Supplier<SettlementAlreadyCompletedException> settlementAlreadyCompleted()
    {
        return SettlementAlreadyCompletedException::new;
    }

    public static Supplier<SettlementIncompleteException> settlementIncomplete()
    {
        return SettlementIncompleteException::new;
    }

    public static Supplier<SettlementNotFoundException> settlementNotFound(Long id)
    {
        return () -> new SettlementNotFoundException(id);
    }
}
