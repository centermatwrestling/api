package com.centermat.api.io.rest;

import com.centermat.api.driver.AbstractDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.events.Event;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractRestController<T> {
    protected AbstractDriver<T> driver;

    public AbstractRestController(AbstractDriver<T> driver) {
        this.driver = driver;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<T> get() {
        return driver.fetchAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable UUID id) {
        return driver.findOne(id);
    }
}
