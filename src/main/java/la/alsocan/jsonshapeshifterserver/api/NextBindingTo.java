/*
 * The MIT License
 *
 * Copyright 2014 Florian Poulin - https://github.com/fpoulin.
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
package la.alsocan.jsonshapeshifterserver.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Florian Poulin - https://github.com/fpoulin
 */
public class NextBindingTo {
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String path;
	
	@JsonProperty
	private String type;
	
	@JsonProperty
	private Set<SchemaNodeTo> legalSourceNodes;

	public NextBindingTo() {
		this.legalSourceNodes = new TreeSet<>();
	}

	public NextBindingTo(String name, String path, String type) {
		this();
		this.name = name;
		this.path = path;
		this.type = type;
	}
	
	public NextBindingTo addLegalSourceNode(SchemaNodeTo to) {
		legalSourceNodes.add(to);
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}