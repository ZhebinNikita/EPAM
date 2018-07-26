package by.epam.insurance.derivative;

import by.epam.insurance.obligation.Obligation;
import com.sun.istack.internal.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.*;


/**
 * Дериватив - договор (контракт), по которому стороны получают право
 * или обязуются выполнить некоторые действия в отношении базового актива (страхового обязательства).
 * Используемая валюта - $ (USD);
 * */
public class Derivative {

    private final static Logger LOG = LogManager.getRootLogger();
    private String name;
    private double cost; // цена, которую обязан внести страхователь при заключении договорва (дериватива)
    private List<Obligation> obligations;
    private Date finishDate; // дереватив заключается на определенный срок


    public Derivative(){
        cost = 0;
        name = "Default_Derivative";
        obligations = new ArrayList<>();
        finishDate = new Date();
    }

    public Derivative(String name, Date finishDate, Obligation...args) {
        cost = 0;
        this.name = name;
        obligations = new ArrayList<>();
        addObligations(args);
        setFinishDate(finishDate);
    }

    public Derivative(String name, String finishDate, Obligation...args) {
        cost = 0;
        this.name = name;
        obligations = new ArrayList<>();
        addObligations(args);
        setFinishDate(finishDate);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addObligations(Obligation...args){
        for (int i = 0; i < args.length; i++) {
            obligations.add(i, args[i]);
        }
    }

    public void removeObligation(String obligationName){
        for(int i = 0; i < obligations.size(); i++){
            if(obligations.get(i).getName().compareTo(obligationName) == 0){
                obligations.remove(i);
                break;
            }
            else if(i == obligations.size()-1){
                LOG.info("There is no Obligation - \"" + obligationName + "\" to remove it");
            }
        }
    }

    public void removeObligation(Obligation obligation){
        boolean removed = obligations.remove(obligation);
        if(!removed){
            LOG.info("There is no Obligation - \"" + obligation.getName() + "\" to remove it");
        }
    }


    /**
     * Date Format Pattern: "dd.MM.yyyy"
     * */
    public void setFinishDate(Date date){
        checkDateValidity(date);
        this.finishDate = date;
    }
    /**
     * Date Format Pattern: "dd.MM.yyyy"
     * */
    public void setFinishDate(String date){
        try {
            finishDate = new SimpleDateFormat("dd.MM.yyyy").parse(date);
            checkDateValidity(finishDate);
        } catch (ParseException e){
            LOG.error("Parse Exception: ", e);
        }
    }

    public Date getFinishDate() {
        return finishDate;
    }


    public void calculateCost(){
        cost = 0;
        for(Obligation oblig : obligations){
            cost += oblig.getCost();
        }
    }

    public double getCost() {
        return cost;
    }


    public void sortByIncreasingRisk(){
        obligations.sort(Comparator.comparingInt(Obligation::getRiskLevel));
    }

    public void sortByDecreasingRisk(){
        Collections.sort(obligations, new Comparator<Obligation>() {
            @Override
            public int compare(Obligation o1, Obligation o2) {
                if (o1.getRiskLevel() > o2.getRiskLevel()) {
                    return -1;
                }
                else if(o1.getRiskLevel() < o2.getRiskLevel()){
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });
    }


    public List<Obligation> getObligations() {
        return obligations;
    }


    public void showObligationsData(){
        for(Obligation obligation : obligations){
            obligation.showObligationData();
        }
    }


    public void showDerivativeData(){
        calculateCost();
        System.out.println("Derivative - name: " + this.name + "; cost: " + this.cost
                + "; Finish Date: " + new SimpleDateFormat("dd.MM.yyyy").format(this.finishDate) + "; ");
    }



    public List<Obligation> searchByName(String text){
        List<Obligation> result = new ArrayList<>();
        for (Obligation obligation : obligations){
            if(obligation.getName().contains(text)){
                result.add(obligation);
            }
        }
        if(result.isEmpty()){
            LOG.info("searchByName returned empty list.");
        }
        return result;
    }

    public List<Obligation> searchByRisk(int minRisk, int maxRisk){
        List<Obligation> result = new ArrayList<>();
        for (Obligation obligation : obligations){
            if(obligation.getRiskLevel() > minRisk && obligation.getRiskLevel() < maxRisk){
                result.add(obligation);
            }
        }
        if(result.isEmpty()){
            LOG.info("searchByRisk returned empty list.");
        }
        return result;
    }

    public List<Obligation> searchByCost(double minCost, double maxCost){
        List<Obligation> result = new ArrayList<>();
        for (Obligation obligation : obligations){
            if(obligation.getCost() > minCost && obligation.getCost() < maxCost){
                result.add(obligation);
            }
        }
        if(result.isEmpty()){
            LOG.info("searchByCost returned empty list.");
        }
        return result;
    }

    public List<Obligation> search(String text, int minRisk, int maxRisk, double minCost, double maxCost){
        List<Obligation> result = new ArrayList<>();
        for (Obligation obligation : obligations){
            if(obligation.getName().contains(text) &&
                    obligation.getRiskLevel() > minRisk && obligation.getRiskLevel() < maxRisk
                    && obligation.getCost() > minCost && obligation.getCost() < maxCost){
                result.add(obligation);
            }
        }
        if(result.isEmpty()){
            LOG.info("search returned empty list.");
        }
        return result;
    }


    private void checkDateValidity(Date date){
        if(date.compareTo(new Date()) <= 0){
            LOG.error("Wrong Derivative Date!");
        }
    }


}
