/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kit.aifb.geo.builder;

import edu.kit.aifb.geo.builder.util.Components;
import edu.kit.aifb.geo.builder.util.ExportQuery;
import java.util.ArrayList;
import java.util.List;
import org.apache.jena.query.Query;

/**
 *
 * @author paul
 */
public class BuildQuery {

    private List<Components> c = new ArrayList<>();
    private long _limit = 0 ;

    public String getQuery(String qry) {
        ExportQuery eq = new ExportQuery(qry);
        Query query = eq.buildSimpleQuery();
        _limit = eq.getLimit();
        c.addAll(eq.getListComponents());
        return query.toString();
    }

    public long getLimit() {
        return _limit;
    }

    public List<Components> getC() {
        return c;
    }

    public void setC(List<Components> c) {
        this.c = c;
    }

}
