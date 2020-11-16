/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        /*System.out.println("json-muotoinen data:");
        System.out.println( bodyText );*/

        Gson mapper = new Gson();
        List<Player> players = Arrays.asList(mapper.fromJson(bodyText, Player[].class));
        System.out.println("Suomalaiset pelaajat:");
        players.stream()
                .filter( p -> p.getNationality().equals("FIN"))
                .sorted((a,b) -> b.getTotalPoints() - a.getTotalPoints())
                .forEach(System.out::println);
    }

}