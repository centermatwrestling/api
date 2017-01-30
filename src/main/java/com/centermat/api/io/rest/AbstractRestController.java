package com.centermat.api.io.rest;

import com.centermat.api.driver.AbstractDriver;
import com.centermat.api.model.BaseModel;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.google.common.base.Strings;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
public abstract class AbstractRestController<T extends BaseModel> {
    protected static final UUID example_id = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static final String NAME = "";

    protected AbstractDriver<T> driver;
    protected Class<T> clazz;

    public AbstractRestController(Class<T> clazz,AbstractDriver<T> driver) {
        this.clazz = clazz;
        this.driver = driver;
    }

    @ApiOperation(value = "Schema definition")
    @RequestMapping(method = RequestMethod.GET, path = "/schema")
    public JsonSchema getSchema() throws JsonMappingException {
        final JsonSchema jsonSchema = new ObjectMapper().generateJsonSchema(clazz);
        final JsonNode properties = jsonSchema.getSchemaNode().get("properties");
        for (JsonNode property : properties) {
        }
        return jsonSchema;
    }

    @ApiOperation(value = "Sample/Example of type")
    @RequestMapping(method = RequestMethod.GET, path = "/example")
    public T getExample(@RequestParam(required = false) String fields) {
        return getExample();
    }

    public abstract T getExample();

    @ApiOperation(value = "Collection of type")
    @RequestMapping(method = RequestMethod.GET)
    public Page<T> get(@RequestParam(required = false, defaultValue = "0") Integer page,@RequestParam(required = false, defaultValue = "100")Integer size, @RequestParam(required = false) String fields) throws IOException {
        PageRequest pageable = new PageRequest(page,size);
        return driver.fetchAll(pageable);
    }

    @ApiOperation(value = "Single instance of type")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable UUID id, @RequestParam(required = false) String fields) {
        return driver.findOne(id);
    }

    @ApiOperation(value = "Delete instance of type")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable UUID id, @RequestHeader(name = "Authorization") String jwtToken) {
        driver.delete(id);
    }

    @ApiOperation(value = "Create instance of type")
    @RequestMapping(method = RequestMethod.POST)
    public UUID post(@RequestBody T body, @RequestHeader(name = "Authorization") String jwtToken) {
        driver.post(body);
        return body.getId();
    }

    @ApiOperation(value = "Create bulk instances of type")
    @RequestMapping( method = RequestMethod.POST, value = "bulk")
    public List<UUID> postBulk(@RequestBody List<T> b, @RequestHeader(name = "Authorization") String jwtToken) {
        b.forEach(t -> driver.post(t));
        return b.stream().map(t -> t.getId()).collect(Collectors.toList());
    }

    @ApiOperation(value = "Update instance of type")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void put(@PathVariable UUID id, @RequestBody T body, @RequestHeader(name = "Authorization") String jwtToken) {
        driver.put(id,body);
    }

}
