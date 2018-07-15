package by.epam.insurance.obligation;


/**
 * Страховое обязательство - обязательство, в силу которого одна сторона (страхователь)
 * может получить денежную сумму при наступлении обусловленных обстоятельств (страхового случая)
 * и несет обязанность по утрате страховых платежей, а другая сторона (страховщик)
 * обязуется выплатить указан­ную сумму.
 * */
public abstract class Obligation {

    protected String name;
    protected int riskLevel;
    protected double cost;


    public Obligation(){
        this.name = "NO_NAME";
        this.riskLevel = 0;
        this.cost = 0;
    }

    public Obligation(String name, int riskLevel, double cost){
        this.name = name;
        this.riskLevel = riskLevel;
        this.cost = cost;
    }


    public void setData(String name, int riskLevel, double cost){
        this.name = name;
        this.riskLevel = riskLevel;
        this.cost = cost;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }


    public void setRiskLevel(int riskLevel){
        this.riskLevel = riskLevel;
    }

    public int getRiskLevel(){
        return this.riskLevel;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }


    public abstract void showObligationData();


}
