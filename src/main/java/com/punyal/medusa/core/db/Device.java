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
package com.punyal.medusa.core.db;

import com.punyal.medusa.core.security.Authenticator;
import java.net.InetAddress;

/**
 *
 * @author Pablo Puñal Pereira <pablo.punal@ltu.se>
 */
public class Device {
    private InetAddress address;
    private final String id;
    private String password;
    private Authenticator authenticator;

    public Device(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    public void updatePassword(String password) {
        this.password = password;
    }
    
    public void setAuthenticator(InetAddress address, Authenticator authenticator) {
        this.address = address;
        this.authenticator = authenticator;
    }
    
    public InetAddress getAddress() {
        return address;
    }
    
    public String getID() {
        return id;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Authenticator getAuthenticator() {
        return authenticator;
    }
    
    
    
}