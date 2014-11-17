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
package la.alsocan.jsonshapeshifterserver.jdbi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import la.alsocan.jsonshapeshifterserver.api.SchemaTo;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Florian Poulin - https://github.com/fpoulin
 */
public class SchemaMapper implements ResultSetMapper<SchemaTo> {

	@Override
	public SchemaTo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		
		// parse date
		DateTime dt = new DateTime(r.getTimestamp("creationDate"), DateTimeZone.UTC);
		
		// parse schema node
		ObjectMapper om = new ObjectMapper();
		JsonNode node;
		try {
			node = om.readTree(r.getString("schemaStr"));
		} catch (IOException ex) {
			return null;
		}
		
		// build to
		return new SchemaTo(r.getInt("id"), dt, node);
	}
}