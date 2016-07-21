package de.spqrinfo.cups4j.cli;

/**
 * Copyright (C) 2009 Harald Weyhing
 * <p>
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * <p>
 * See the GNU Lesser General Public License for more details. You should have received a copy of
 * the GNU Lesser General Public License along with this program; if not, see
 * <http://www.gnu.org/licenses/>.
 */

import de.spqrinfo.vppserver.ippclient.IppResult;
import de.spqrinfo.cups4j.CupsPrinter;
import de.spqrinfo.cups4j.PrintJob;
import de.spqrinfo.cups4j.operations.ipp.IppGetPrinterAttributesOperation;
import de.spqrinfo.cups4j.util.IppResultPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.net.URL;

public class WindowsXPTest {

    private static final Logger logger = LoggerFactory.getLogger(WindowsXPTest.class);

    public static void main(String[] args) {

        try {

            IppGetPrinterAttributesOperation o = new IppGetPrinterAttributesOperation(80);
            IppResult result = o.request(new URL("http://192.168.1.2:80/printers/PDFCreator"), null);
            IppResultPrinter.print(result);

            CupsPrinter printer = new CupsPrinter(new URL("http://192.168.1.2:80/printers/PDFCreator"), "PDFCreator", false);
            PrintJob printJob = new PrintJob.Builder(new FileInputStream("cups4j.ps")).userName("anonymous").jobName("1")
                    .build();
            printer.print(printJob);
            System.exit(0);
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.exit(1);
        }
    }
}
