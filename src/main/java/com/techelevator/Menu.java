package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> options;

    public Menu() {
        this.options = new ArrayList<>();
    }

    public Menu(List<String> options) {
        this.options = options;
    }

    public void addOption(String option) {
        options.add(option);
    }

    public List<String> getOptions() {
        return options;
    }

}