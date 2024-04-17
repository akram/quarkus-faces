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
package org.primefaces.showcase.view.dnd;

import org.primefaces.event.DragDropEvent;
import org.primefaces.showcase.domain.Product;
import org.primefaces.showcase.service.ProductService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("dndProductsView")
@ViewScoped
public class DNDProductsView implements Serializable {

    @Inject
    ProductService service;

    private List<Product> products;

    private List<Product> droppedProducts;

    private Product selectedProduct;

    @PostConstruct
    public void init() {
        products = service.getProducts(9);
        droppedProducts = new ArrayList<>();
    }

    public void onProductDrop(DragDropEvent<Product> ddEvent) {
        Product product = ddEvent.getData();

        droppedProducts.add(product);
        products.remove(product);
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getDroppedProducts() {
        return droppedProducts;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
}
