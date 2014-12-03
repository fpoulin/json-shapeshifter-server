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
package la.alsocan.symbiot.api.to.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import static la.alsocan.symbiot.api.to.bindings.StringConstantBindingTo.TYPE;

/**
 * @author Florian Poulin - https://github.com/fpoulin
 */
public class FilesystemInputTo extends InputTo {
	
	public static final String TYPE = "filesystemInput";
	
	@JsonProperty
	private String folder;
	
	@JsonProperty
	private String regex;
	
	@JsonProperty
	private Boolean deleteAfterRead;

	@Override
	public String getType() {
		return TYPE;
	}
	
	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public Boolean getDeleteAfterRead() {
		return deleteAfterRead;
	}

	public void setDeleteAfterRead(Boolean deleteAfterRead) {
		this.deleteAfterRead = deleteAfterRead;
	}
}
