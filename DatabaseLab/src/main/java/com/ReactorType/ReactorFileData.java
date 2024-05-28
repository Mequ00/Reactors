package com.ReactorType;

import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

@Setter
@Getter
public class ReactorFileData {

    private String type;
    private Float burnup;
    private Float kpd;
    private Float enrichment;
    private Float termal_capacity;
    private Float electrical_capacity;
    private Float life_time;
    private Float first_load;
    private String source;

    public MutableTreeNode reactoreNode() {
        DefaultMutableTreeNode generalnode = new DefaultMutableTreeNode(type);
        generalnode.add(new DefaultMutableTreeNode("burnup: " + burnup));
        generalnode.add(new DefaultMutableTreeNode("kpd: " + kpd));
        generalnode.add(new DefaultMutableTreeNode("enrichment" + enrichment));
        generalnode.add(new DefaultMutableTreeNode("terminal capacity: " + termal_capacity));
        generalnode.add(new DefaultMutableTreeNode("electric capacity: " + electrical_capacity));
        generalnode.add(new DefaultMutableTreeNode("life time: " + life_time));
        generalnode.add(new DefaultMutableTreeNode("first load: " + first_load));
        generalnode.add(new DefaultMutableTreeNode("source: " + source));
        return generalnode;
    }
}
