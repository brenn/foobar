package no.bouvet.gitskole.ssb;

import com.google.gson.Gson;
import no.bouvet.gitskole.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SsbGateway {
//    private static final String SSB_BASE_URL = "https://data.ssb.no/api/klass/v1";
//    private static final String FYLKER_URL = SSB_BASE_URL + "/classifications/104.json";
//    private static final String KOMMUNER_URL = SSB_BASE_URL + "/versions/1160.json";

    private static FylkesInndeling fylkesInndeling;
    private static KommuneInndeling kommuneInndeling;

    static {
        Gson gson = new Gson();
        try {
            InputStream is = FileUtils.getFileFromResourceAsStream("fylkesinndeling.json");
            fylkesInndeling = gson.fromJson(new InputStreamReader(is), FylkesInndeling.class);
            is.close();
            is = FileUtils.getFileFromResourceAsStream("kommuneInndeling.json");
            kommuneInndeling = gson.fromJson(new InputStreamReader(is), KommuneInndeling.class);
            is.close();
        } catch (IOException e) {
            System.err.println("FEIL: klarte ikke initialisere SSB metadata");
            e.printStackTrace();
        }
    }

    public static String fylkesKode(String fylkesNavn) {
        return fylkesInndeling.fylkesKode(fylkesNavn);
    }

    public static String kommuneKode(String kommuneNavn) {
        return kommuneInndeling.kommuneKode(kommuneNavn);
    }

}
