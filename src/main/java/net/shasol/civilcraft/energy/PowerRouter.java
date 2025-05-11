package net.shasol.civilcraft.energy;

import java.util.*;

public class PowerRouter {
    public static List<PowerGraph.Edge> route(PowerGraph g, PowerGraph.Node start, PowerGraph.Node goal) {
        Map<PowerGraph.Node,Double> dist = new HashMap<>();
        Map<PowerGraph.Node,PowerGraph.Edge> prev = new HashMap<>();
        PriorityQueue<PowerGraph.Node> pq = new PriorityQueue<>(Comparator.comparingDouble(dist::get));

        for(var n: g.nodes()) dist.put(n, Double.POSITIVE_INFINITY);
        dist.put(start, 0.0);
        pq.add(start);

        while(!pq.isEmpty()) {
            var u = pq.poll();
            if(u.equals(goal)) break;
            for(var e: g.edges(u)) {
                double nd = dist.get(u) + e.resistance;
                if(nd < dist.get(e.to)) {
                    dist.put(e.to, nd);
                    prev.put(e.to, e);
                    pq.add(e.to);
                }
            }
        }

        List<PowerGraph.Edge> path = new ArrayList<>();
        for(var cur = goal; prev.containsKey(cur); cur = prev.get(cur).from)
            path.add(0, prev.get(cur));
        return path;
    }
}
