package com.eventdrivenmsapoc.buildingblocks.altinn;

import java.util.List;

public class AltinnData {
    private Long income;
    private List<Debt> debts;

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public List<Debt> getDebts() {
        return debts;
    }

    public void setDebts(List<Debt> debts) {
        this.debts = debts;
    }

    @Override
    public String toString() {
        return "AltinnData{" +
                "income=" + income +
                ", debts=" + debts +
                '}';
    }

    public static class Debt {

        public Debt(Long amount, String source) {
            this.amount = amount;
            this.source = source;
        }

        private Long amount;
        private String source;

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        @Override
        public String toString() {
            return "Debt{" +
                    "amount=" + amount +
                    ", source='" + source + '\'' +
                    '}';
        }
    }
}
