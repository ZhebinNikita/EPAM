package by.epam.insurance.obligation.basis;


import by.epam.insurance.obligation.Obligation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * По признаку обязательности - добровольное.
 * */
public class VoluntaryObligation extends Obligation implements SignableContract{

    private final static Logger LOG = LogManager.getRootLogger();
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
        try {
            System.out.println("\nVoluntary Obligation: \nname: " + this.name + "; \nrisk level: " + this.riskLevel
                    + "%; \ncost: " + this.cost + "$; \ninsurance premium: " + this.contract.getInsurancePremium() + "$.\n");
        } catch (Exception e) {
            LOG.error("Some Obligation Data are missing! ", e);
        }
    }


}
