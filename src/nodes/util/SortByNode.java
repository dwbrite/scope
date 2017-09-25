package nodes.util;

import java.util.Comparator;

public class SortByNode implements Comparator<RealNode> {
    @Override
    public int compare(RealNode n1, RealNode n2) {
        if(n1.nodePriority == n2.nodePriority) {
            return n1.name.compareTo(n2.name);
        } else if (n1.nodePriority > n2.nodePriority) {
            return 1;
        } else {
            return -1;
        }
    }
}
