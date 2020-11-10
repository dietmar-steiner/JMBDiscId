package examples;

import com.axokoi.discid.JMBDiscId;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * Copyright (C) 2012 Dietmar Steiner <jmusicbrainz [at] d-steiner.com>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */

/**
 * @author Dietmar Steiner
 */
public class Main {

    private static Log log = LogFactory.getLog(Main.class);

    /**
     * This class is an example on how to use JMBDiscId.
     *
     * @param args args[0] contains the full path to the library file. args[1]
     *             contains the path to the cd drive
     */
    public static void main(String[] args) {
        int ret = 0;
        System.out.println("start");
        System.out.println("JVM architecture: " + System.getProperty("os.arch"));
        if (args.length < 2) {
            outputHelp();
            ret = 1;
        } else {
            JMBDiscId discId = new JMBDiscId();
            if (discId.init(args[0])) {
                System.out.println("MusicBrainz DiscID: " + discId.getDiscId(args[1]));
                System.out.println("FreeDB DiscID: " + discId.getFreeDBId(args[1]));
                System.out.println("Submission Url: " + discId.getSubmissionUrl(args[1]));
                System.out.println("DataUrl: " + discId.getDiscIdLookupUrl(args[1]));
            } else {
                ret = 2;
            }
        }
        System.exit(ret);
    }

    private static void outputHelp() {
        System.out.println("usage : java JMBDiscId.jar <path to lib including lib name and extention> <drive path to use>");
    }
}
