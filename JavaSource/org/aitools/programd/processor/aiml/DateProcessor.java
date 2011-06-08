/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.aitools.programd.processor.aiml;

import org.w3c.dom.Element;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aitools.programd.Core;
import org.aitools.programd.parser.TemplateParser;

/**
 * Handles a
 * <code><a href="http://aitools.org/aiml/TR/2001/WD-aiml/#section-date">date</a></code>
 * element.
 * 
 * @version 4.5
 * @author Pedro Colla
 * @author <a href="mailto:noel@aitools.org">Noel Bush</a>
 */
public class DateProcessor extends AIMLProcessor
{
    /** The label (as required by the registration scheme). */
    public static final String label = "date";

    /**
     * Creates a new DateProcessor using the given Core.
     * 
     * @param coreToUse the Core object to use
     */
    public DateProcessor(Core coreToUse)
    {
        super(coreToUse);
    }

    /**
     * @see AIMLProcessor#process(Element, TemplateParser)
     */
    @Override
    public String process(@SuppressWarnings("unused") Element element, @SuppressWarnings("unused") TemplateParser parser)
    {
    	String date = "";
    	
    	String format = element.getAttribute("format");
    	if (!format.equals("")) {
	    	// TODO: refactory
	    	format = format
	    		  .replaceAll("%a", "E")	// Abbreviated weekday name
	    		  .replaceAll("%A", "EEEE")	// Full weekday name
	    		  .replaceAll("%b", "MMM")	// Abbreviated month name
	    		  .replaceAll("%B", "MMMM")	// Full month name
	    		  							// TODO: %c Date and time representation appropriate for locale
	    		  .replaceAll("%d", "dd")	// Day of month as decimal number (01 . 31)
	    		  .replaceAll("%H", "HH")	// Hour in 24-hour format (00 . 23)
	    		  .replaceAll("%I", "hh")	// Hour in 12-hour format (01 . 12)
	    		  							// TODO: %j Day of year as decimal number (001 . 366)
	    		  .replaceAll("%m", "MM")	// Month as decimal number (01 . 12)
	    		  .replaceAll("%M", "mm")	// Minute as decimal number (00 . 59)
	    		  							// TODO: %p Current locale.s A.M./P.M. indicator for 12-hour clock
	    		  .replaceAll("%S", "ss")	// Second as decimal number (00 . 59)
	    		  							// TODO: %U Week of year as decimal number, with Sunday as first day of week (00 . 53)
	    		  							// TODO: %w Weekday as decimal number (0 . 6; Sunday is 0)
	    		  							// TODO: %W Week of year as decimal number, with Monday as first day of week (00 . 53)
	    		  							// TODO: %x Date representation for current locale
	    		  							// TODO: %X Time representation for current locale
	    		  .replaceAll("%y", "yy")	// Year without century, as decimal number (00 . 99)
	    		  .replaceAll("%Y", "yyyy");// Year with century, as decimal number
	    		  							// TODO: %Z Time-zone name or abbreviation; no characters if time zone is unknown
	    									// TODO: %% Percent sign
	    	Format formatter = new SimpleDateFormat(format);
	    	date = formatter.format(new Date());
    	} else {
    		date = new Date().toString();
    	}
        return date;
    }
}