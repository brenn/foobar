package no.bouvet.gitskole.ssb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FylkesInndeling {
    private String name;
    private String description;
    @SerializedName("classificationItems")
    private List<Fylke> fylker;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Fylke> getFylker() {
        return fylker;
    }

    public void setFylker(List<Fylke> fylker) {
        this.fylker = fylker;
    }

    public String fylkesKode(String fylkeNavn) {
        return fylker.stream()
                .filter(fylke -> fylke.getName().equalsIgnoreCase(fylkeNavn))
                .findFirst().orElseThrow().getCode();
    }

    @Override
    public String toString() {
        return "FylkesInndeling{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fylker=" + fylker +
                '}';
    }
}
