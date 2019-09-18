package com.example.app;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
@JsModule("./tab-handler.js")
public class MainView extends VerticalLayout {

    public MainView() {
        TextField tf = new TextField("Enter 'foo' here");
        TextArea ta = new TextArea("Enter 'foo' here");
        TextField tf2 = new TextField("Just some other field");
        TextField tf3 = new TextField("Focus moves here on 'foo'");

        add(tf, ta, tf2, tf3);

        onTabMoveFocus(tf, "foo", tf3);
        onTabMoveFocus(ta, "foo", tf3);

    }

    private void onTabMoveFocus(AbstractField<?, ?> tf, String valueToMatch, AbstractField<?, ?> tf3) {
        tf.getElement().executeJs("window.tabHandler(this,$0,$1)", valueToMatch, tf3);

    }

}
