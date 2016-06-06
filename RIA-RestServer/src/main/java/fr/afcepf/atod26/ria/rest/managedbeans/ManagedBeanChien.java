/*
 * Créé le 6 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.managedbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import fr.afcepf.atod26.ria.rest.api.IDaoPetitChien;
import fr.afcepf.atod26.ria.rest.entity.PetitChien;

/**
 * Pour afficher le tableau des chiens.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
@ManagedBean
@SessionScoped
public class ManagedBeanChien {

    private IDaoPetitChien daoPetitChien;

    private List<PetitChien> lesPetitChiens;

    private PetitChien petitChien;

    private BarChartModel barChartModel;

    public ManagedBeanChien() {
        try {
            Context context = new InitialContext();
            daoPetitChien = (IDaoPetitChien) context
                    .lookup("java:global/RIA-RestServer/DaoPetitChienImpl");
            lesPetitChiens = daoPetitChien.getAllChien();
            initChart();
        } catch (NamingException e) {
        }
    }

    public void onRowSelect(SelectEvent event) {
        petitChien = (PetitChien) event.getObject();
    }

    private void initChart() {
        barChartModel = new BarChartModel();
        Map<String, List<PetitChien>> race = new HashMap<>();
        for (PetitChien localPetitChien : lesPetitChiens) {
            if (!race.containsKey(localPetitChien.getRace())) {
                List<PetitChien> chiens = new ArrayList<>();
                chiens.add(localPetitChien);
                race.put(localPetitChien.getRace(), chiens);
            } else {
                race.get(localPetitChien.getRace()).add(localPetitChien);
            }
        }
        int maxAge = 0;
        for (Entry<String, List<PetitChien>> clefRace : race.entrySet()) {
            ChartSeries chiens = new ChartSeries();
            chiens.setLabel(clefRace.getKey());
            int ageRace = 0;
            for (PetitChien localPetitChien : race.get(clefRace.getKey())) {
                ageRace += localPetitChien.getAge();
                if (ageRace > maxAge) {
                    maxAge = ageRace;
                }
            }
            chiens.set(clefRace, ageRace);
            barChartModel.addSeries(chiens);
        }
        Axis xAxis = barChartModel.getAxis(AxisType.X);
        xAxis.setLabel("Race");
        Axis yAxis = barChartModel.getAxis(AxisType.Y);
        yAxis.setLabel("Age cumulé");
        yAxis.setMin(0);
        yAxis.setMax(maxAge + 2);
        yAxis.setTickCount(1);
        barChartModel.setTitle("Age des chiens en fonction de la race");
        barChartModel.setLegendPosition("ne");
    }

    public List<PetitChien> getLesPetitChiens() {
        return lesPetitChiens;
    }

    public void setLesPetitChiens(List<PetitChien> paramLesPetitChiens) {
        lesPetitChiens = paramLesPetitChiens;
    }

    public PetitChien getPetitChien() {
        return petitChien;
    }

    public void setPetitChien(PetitChien paramPetitChien) {
        petitChien = paramPetitChien;
    }

    public BarChartModel getBarChartModel() {
        return barChartModel;
    }

    public void setBarChartModel(BarChartModel paramBarChartModel) {
        barChartModel = paramBarChartModel;
    }

}
