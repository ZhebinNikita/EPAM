package by.epam.insurance.obligation.basis;


import by.epam.insurance.obligation.Obligation;

/**
 * По признаку обязательности - добровольное.
 * */
public class VoluntaryObligation extends Obligation implements SignableContract{

    private Contract contract;


    public VoluntaryObligation(){
        super();
    }

    public VoluntaryObligation(String name, int riskLevel, double cost, Contract contract){
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
        System.out.println("\nVoluntary Obligation: \nname: " + this.name + "; \nrisk level: " + this.riskLevel
                + "%; \ncost: " + this.cost + "$; \ninsurance premium: " + this.contract.getInsurancePremium() + "$.\n");
    }


}
