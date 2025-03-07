/*
 * The MIT License
 *
 * Copyright (c) 2009-2024 PrimeTek Informatics
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.primefaces.showcase.view.input;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

import io.quarkus.runtime.annotations.RegisterForReflection;

@Named("triStateCheckboxView")
@ViewScoped
@RegisterForReflection(serialization = true)
public class TriStateCheckboxView implements Serializable {

    private Boolean value1;
    private Boolean value2;
    private Boolean value3;

    @PostConstruct
    public void init() {
        value1 = Boolean.FALSE;
        value2 = Boolean.TRUE;
    }

    public Boolean getValue1() {
        return value1;
    }

    public void setValue1(Boolean value1) {
        this.value1 = value1;
    }

    public Boolean getValue2() {
        return value2;
    }

    public void setValue2(Boolean value2) {
        this.value2 = value2;
    }

    public Boolean getValue3() {
        return value3;
    }

    public void setValue3(Boolean value3) {
        this.value3 = value3;
    }

    public void addMessage() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "State has been changed", "State is = " + value2);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}