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
import java.util.LinkedList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * @author Florian Poulin - https://github.com/fpoulin
 */
public class TransformationTo {

	@JsonProperty
	private int id;
	
	@JsonProperty
	private DateTime creationDate;
	
	@JsonProperty
	private DateTime lastModificationDate;
	
	@JsonProperty
	private int sourceSchemaId;
	
	@JsonProperty
	private int targetSchemaId;
	
	@JsonProperty
	private List<BindingTo> existingBindings;
	
	@JsonProperty
	private List<BindingTo> remainingBindings;
	
	@JsonProperty
	private List<Link> links;
	
	public TransformationTo() {
		this.links = new LinkedList<>();
		this.existingBindings = new LinkedList<>();
		this.remainingBindings = new LinkedList<>();
	}

	public TransformationTo(int id, DateTime creationDate, DateTime lastModificationDate, int sourceSchemaId, int targetSchemaId) {
		this();
		this.id = id;
		this.creationDate = creationDate;
		this.lastModificationDate = lastModificationDate;
		this.sourceSchemaId = sourceSchemaId;
		this.targetSchemaId = targetSchemaId;
	}
	
	public TransformationTo addLink(Link link) {
		this.links.add(link);
		return this;
	}
	
	public TransformationTo addExistingBinding(BindingTo binding) {
		this.existingBindings.add(binding);
		return this;
	}
	
	public TransformationTo addRemainingBinding(BindingTo binding) {
		this.remainingBindings.add(binding);
		return this;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}

	public DateTime getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(DateTime lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public int getSourceSchemaId() {
		return sourceSchemaId;
	}

	public void setSourceSchemaId(int sourceSchemaId) {
		this.sourceSchemaId = sourceSchemaId;
	}

	public int getTargetSchemaId() {
		return targetSchemaId;
	}

	public void setTargetSchemaId(int targetSchemaId) {
		this.targetSchemaId = targetSchemaId;
	}
}
