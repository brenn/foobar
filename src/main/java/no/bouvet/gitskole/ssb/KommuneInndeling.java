package no.bouvet.gitskole.ssb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KommuneInndeling {
    public String name;
    @SerializedName("classificationItems")
    public List<Kommune> kommuner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Kommune> getKommuner() {
        return kommuner;
    }

    public void setKommuner(List<Kommune> kommuner) {
        this.kommuner = kommuner;
    }

    public String kommuneKode(String kommuneNavn) {
        return kommuner.stream()
                .filter(kommune -> kommune.getName().equalsIgnoreCase(kommuneNavn))
                .findFirst()
                .orElseThrow()
                .getCode();
    }

    @Override
    public String toString() {
        return "KommuneInndeling{" +
                "name='" + name + '\'' +
                ", kommuner=" + kommuner +
                '}';
    }
}
