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
package com.punyal.medusa.core;

import static com.punyal.medusa.constants.Defaults.*;
import com.punyal.medusa.utils.DateUtils;
import java.net.InetAddress;

/**
 *
 * @author Pablo Puñal Pereira <pablo.punal@ltu.se>
 */
public class MedusaDevice {
    private int id;
    private final String name;
    private String password;
    private String address;
    private String ticket;
    private boolean valid;
    private long expireTime;
    private long lastLogin;
    private String protocols;
    private int timeout;
    
    public MedusaDevice(int id, String name, String password, String address, String ticket, boolean valid, long expireTime, long lastLogin, String protocols, int timeout) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.ticket = ticket;
        this.valid = valid;
        this.lastLogin = lastLogin;
        this.expireTime = expireTime;
        this.protocols = protocols;
        this.timeout = timeout;
    }
    
    public MedusaDevice(int id, String name, String password, String address, String ticket, boolean valid, String expireTime, String lastLogin, String protocols, int timeout) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.ticket = ticket;        
        this.valid = valid;
        this.lastLogin = DateUtils.date2Long(lastLogin);
        this.expireTime = DateUtils.date2Long(expireTime);
        this.protocols = protocols;
        this.timeout = timeout;
    }
       
    public MedusaDevice(String name, String password) {
        this.id = 0;
        this.name = name;
        this.password = password;
        this.address = "";
        this.ticket = "";
        this.valid = false;
        this.lastLogin = 0;
        this.expireTime = 0;
        this.protocols = "";
        this.timeout = DEFAULT_TICKET_TIMEOUT;
    }
    
    public void changePassword(String password) {
        this.password = password;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setAddress(InetAddress address) {
        this.address = address.getHostAddress();
    }
    
    public void setValid() {
        valid = true;
    }
    
    public void setNotValid() {
        valid = false;
    }
    
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    
    public void setLastLogin(long lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
    
    public void setProtocols(String protocols) {
        this.protocols = protocols;
    }
    
    public void setTimeoutMillis(int millis) {
        this.timeout = millis;
    }
    
    public void setTimeoutSeconds(int seconds) {
        this.timeout = seconds*1000;
    }
    
    public void setTimeoutMinutes(int minutes) {
        this.timeout = minutes*60000;
    }
    
    public void setTimeoutHours(int hours) {
        this.timeout = hours*3600000;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getTicket() {
        return ticket;
    }
    
    public boolean isValid() {
        return valid;
    }
    
    public long getLastLogin() {
        return lastLogin;
    }
    
    public long getExpireTime() {
        return expireTime;
    }
    
    public String getProtocols() {
        return protocols;
    }
    
    public int getTimeoutMillis() {
        return timeout;
    }
    
    public int getTimeoutSeconds() {
        return (int)(timeout/1000);
    }
    
    public int getTimeoutMinutes() {
        return (int)(timeout/60000);
    }
    
    public int getTimeoutHours() {
        return (int)(timeout/3600000);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Humman readable configuration
        sb.append("Device id: ").append(id).append("\n");
        sb.append("\tName: ").append(name).append("\n");
        sb.append("\tPassword: ").append(password).append("\n");
        sb.append("\tIP: ").append(address).append("\n");
        sb.append("\tTicket: ").append(ticket).append("\n");
        sb.append("\tValid: ").append(valid).append("\n");
        sb.append("\tExpireTime:    ").append(DateUtils.long2DateMillis(expireTime)).append("\n");
        sb.append("\tLast Login: ").append(DateUtils.long2DateMillis(lastLogin)).append("\n");
        sb.append("\tProtocols: ").append(protocols).append("\n");
        sb.append("\tTimeout: ").append(timeout).append("\n");
        return sb.toString();
    }
}
