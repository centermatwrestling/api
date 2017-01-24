package com.centermat.api.io.rest;

import com.centermat.api.driver.AbstractDriver;
import com.centermat.api.model.BaseModel;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@CrossOrigin
public abstract class AbstractRestController<T> {
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
    public List<T> get(@RequestParam(required = false) String fields) {
        return driver.fetchAll();
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
    @RequestMapping(method = RequestMethod.PUT)
    public void put(@RequestBody T body, @RequestHeader(name = "Authorization") String jwtToken) {
        driver.put(body);
    }

    @ApiOperation(value = "Update instance of type")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void put(@PathVariable UUID id, @RequestBody T body, @RequestHeader(name = "Authorization") String jwtToken) {
        driver.post(id,body);
    }

}
