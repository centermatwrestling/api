package com.centermat.api.io.rest;

import com.centermat.api.model.BaseModel;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@CrossOrigin
public interface CrudRestController<T extends BaseModel> {

    @ApiOperation(value = "Schema definition")
    @RequestMapping(method = RequestMethod.GET, path = "/schema")
    JsonSchema getSchema() throws JsonMappingException;

    @ApiOperation(value = "Sample/Example of type")
    @RequestMapping(method = RequestMethod.GET, path = "/example")
    T getExample(@RequestParam(required = false) String fields);

    T getExample();

    @ApiOperation(value = "Collection of type")
    @RequestMapping(method = RequestMethod.GET)
    Page<T> get(@RequestParam(required = false, defaultValue = "0") Integer page,@RequestParam(required = false, defaultValue = "100")Integer size, @RequestParam(required = false) String fields) throws IOException;

    @ApiOperation(value = "Collection of type")
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    List<T> getList(@RequestParam(required = false, defaultValue = "0") Integer page,@RequestParam(required = false, defaultValue = "100")Integer size, @RequestParam(required = false) String fields) throws IOException;

    @ApiOperation(value = "Single instance of type")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    T get(@PathVariable UUID id, @RequestParam(required = false) String fields, @RequestParam(required = false) boolean loadAll);

    @ApiOperation(value = "Delete instance of type")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable UUID id, @RequestHeader(name = "Authorization") String jwtToken);

    @ApiOperation(value = "Create instance of type")
    @RequestMapping(method = RequestMethod.POST)
    UUID post(@RequestBody T body, @RequestHeader(name = "Authorization") String jwtToken);

    @ApiOperation(value = "Create bulk instances of type")
    @RequestMapping( method = RequestMethod.POST, value = "bulk")
    List<UUID> postBulk(@RequestBody List<T> b, @RequestHeader(name = "Authorization") String jwtToken);

    @ApiOperation(value = "Update instance of type")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    void put(@PathVariable UUID id, @RequestBody T body, @RequestHeader(name = "Authorization") String jwtToken);

}
