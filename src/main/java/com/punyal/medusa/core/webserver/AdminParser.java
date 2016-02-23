/*
 * The MIT License
 *
 * Copyright 2016 Pablo Puñal Pereira <pablo.punal@ltu.se>.
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
package com.punyal.medusa.core.webserver;

import static com.punyal.medusa.constants.JsonKeys.*;
import com.punyal.medusa.core.MedusaDevice;
import com.punyal.medusa.core.configuration.Configuration;
import com.punyal.medusa.core.database.DBtools;
import com.punyal.medusa.logger.MedusaLogger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Pablo Puñal Pereira <pablo.punal@ltu.se>
 */
public class AdminParser {
    private static final MedusaLogger log = new MedusaLogger();
    private final Configuration configuration;
    
    
    public AdminParser(Configuration configuration) {
        this.configuration = configuration;
    }
    
    public boolean parseRequest(JSONArray allItems) {
        log.debug("Parsing "+allItems.size()+" devices");
        JSONObject json;
        MedusaDevice device;
        
        
        
        for (Object item: allItems) {
            json = (JSONObject) item;
            
            // Ignore cases with empty name or pass
            if (!json.get(JSON_KEY_NAME).toString().isEmpty() && !json.get(JSON_KEY_PASSWORD).toString().isEmpty()) {
                device = new MedusaDevice(json.get(JSON_KEY_NAME).toString(), json.get(JSON_KEY_PASSWORD).toString());
                log.debug(device.toString());

                switch(json.get(JSON_KEY_STATUS).toString()) {
                    case "OK":
                        log.debug("OK");
                        break;
                    case "new":
                        log.debug("new");
                        DBtools.addNewDevice(configuration.getDatabase(), json.get(JSON_KEY_NAME).toString(), json.get(JSON_KEY_PASSWORD).toString());
                        break;
                    case "delete":
                        log.debug("delete");
                        DBtools.deleteDevice(configuration.getDatabase(), Integer.parseInt(json.get(JSON_KEY_ID).toString()));
                        break;
                    case "changed":
                        log.debug("changed");
                        break;
                    default:
                        log.error("Admin Parser: unknown Status "+json.get(JSON_KEY_STATUS).toString());
                }
            }
            
        }
        
        
        
        
        return true;
    }
}