package edu.kit.aifb.geo.builder;

import edu.kit.aifb.geo.builder.util.ComponentSelect;
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
    private List<ComponentSelect> c2 = new ArrayList<>();
    private long _limit;

    public String getQuery(String qry) {
        ExportQuery eq = new ExportQuery(qry);
        Query query = eq.buildSimpleQuery();
        if (eq.getLimit() < 0) {
            _limit = -1;
        } else {
            _limit = eq.getLimit();
        }
        c.addAll(eq.getListComponents());
        if (eq.getComponentes_select() != null) {
            c2.addAll(eq.getComponentes_select());
        }
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

    public void setC2(List<ComponentSelect> c2) {
        this.c2 = c2;
    }

    public List<ComponentSelect> getC2() {
        return c2;
    }

}
