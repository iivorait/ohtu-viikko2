/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;

/**
 *
 * @author iivo
 */
public class QueryBuilder {
    private ArrayList<Matcher> matchers;
    
    public QueryBuilder () {
        matchers = new ArrayList<Matcher>();
    }
    
    public Matcher build() {
        Matcher[] matcherArray = new Matcher[matchers.size()];
        for(int i = 0; i < matchers.size(); i++) {
            matcherArray[i] = matchers.get(i);
        }
        Matcher tulos = new And( matcherArray );
        
        //tyhjennetään ehdot builderin uusiokäyttöä varten
        matchers.clear();
        
        return tulos;
    }
    
    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matchers.add( new Or(matchers) );
        return this;
    }

}
