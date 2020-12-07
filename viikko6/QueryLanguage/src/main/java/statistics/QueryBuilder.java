/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import java.util.ArrayList;
import statistics.matcher.*;

/**
 *
 * @author anttiollikkala
 */
public class QueryBuilder {
    
    private ArrayList<Matcher> matchers;
    
    public QueryBuilder() {
        this.matchers = new ArrayList<Matcher>();
        this.matchers.add(new All());
    }
   
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public Matcher build() {
        Matcher matcher = new And(this.matchers.toArray(new Matcher[0]));
        this.matchers.clear();
        return matcher;
    }
    
}
