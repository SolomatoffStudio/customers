package com.solomatoff.mvc.controller;

import com.solomatoff.mvc.model.ModelLogic;
import com.solomatoff.mvc.views.ViewLyaer;

public class Controller {
    private static Controller singletonInstance = new Controller();

    public static Controller getInstance() {
        return singletonInstance;
    }

    private Controller() {
    }

    // Field for Presentation layer object
    private ViewLyaer presentation;

    public ViewLyaer getPresentation() {
        return presentation;
    }

    public void setPresentation(ViewLyaer presentation) {
        this.presentation = presentation;
    }

    // Field for Logic layer object
    // A layer of logic (the controller refers to it, and it already refers to Persistent)
    private final ModelLogic logic = new ModelLogic();
    public ModelLogic getLogic() {
        return logic;
    }
}
