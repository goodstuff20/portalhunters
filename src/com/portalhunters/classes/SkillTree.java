package com.portalhunters.classes;

import com.portalhunters.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class SkillTree {

    private Skill skill;
    private SkillTree parent;
    private List<SkillTree> children;

    public SkillTree(SkillTree parent){
        this.parent = parent;
        children = new ArrayList<>();
    }

    public SkillTree addChild(SkillTree child){
        children.add(child);
        return child;
    }

    public SkillTree useThisAsBase() { //copy
        SkillTree skillTreeNew = new SkillTree(this.parent);
        recurFill(this, skillTreeNew);
        return skillTreeNew;
    }

    private void recurFill(SkillTree oldT, SkillTree newT) {
        newT.parent = oldT.parent;
        newT.skill = oldT.skill.cloneSkill();
        for(SkillTree child : oldT.children){
            recurFill(child, newT.addChild(new SkillTree(newT)));
        }
    }

    @Override
    public String toString() {
        String curS = "digraph G {\n";
        recurT(curS, this);
        curS = curS + "}";
        return curS;
    }

    private void recurT(String curS, SkillTree s){
        curS = curS + skill.name + "; children: {";
        for(SkillTree child : s.children) {
            recurT(curS, child);
        }
        curS = curS + "}, ";
    }

    public class Skill {
        // TODO: set unlocked skills etc. and load em on startup (per user)

        private String name;
        private Action action;
        private double cost; //skillpoint cost

        public Skill(String name, Action action, double cost) {
            this.name = name;
            this.action = action;
            this.cost = cost;
        }

        public Action getAction() {
            return action;
        }

        public String getName() {
            return name;
        }

        public double getCost() {
            return cost;
        }

        public Skill cloneSkill() {
            return new Skill(name, action, cost);
        }
    }

    public Skill getSkill() {
        return skill;
    }
}
