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

import java.sql.ResultSet;
import java.sql.SQLException;
import la.alsocan.jsonshapeshifterserver.api.TransformationTo;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * @author Florian Poulin - https://github.com/fpoulin
 */
public class TransformationMapper implements ResultSetMapper<TransformationTo> {

	@Override
	public TransformationTo map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		
		// parse dates
		DateTime dtc = new DateTime(r.getTimestamp("creationDate"), DateTimeZone.UTC);
		DateTime dtm = new DateTime(r.getTimestamp("lastModificationDate"), DateTimeZone.UTC);
		
		// build to
		return new TransformationTo(
				  r.getInt("id"), dtc, dtm, 
				  r.getInt("sourceSchemaId"), 
				  r.getInt("targetSchemaId"));
	}
}