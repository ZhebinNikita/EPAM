package by.epam.insurance.obligation.basis;


import by.epam.insurance.obligation.Obligation;

/**
 * По признаку обязательности - обязательное.
 * */
public class ObligatoryObligation extends Obligation implements SignableContract{

    private Contract contract;


    public ObligatoryObligation(){
        super();
    }

    public ObligatoryObligation(String name, int riskLevel, double cost, Contract contract){
        super(name, riskLevel, cost);
        this.contract = contract;
    }


    @Override
    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public Contract getContract() {
        return this.contract;
    }


    @Override
    public void showObligationData() {
        System.out.println("\nObligatory Obligation: \nname: " + this.name + "; \nrisk level: " + this.riskLevel
                + "%; \ncost: " + this.cost + "$; \ninsurance premium: " + this.contract.getInsurancePremium() + "$.\n");
    }


}
