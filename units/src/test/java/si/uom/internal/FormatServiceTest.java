/*
 * International System of Units (SI)
 * Copyright (c) 2005-2019, Jean-Marie Dautelle, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to
 *    endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package si.uom.internal;

import static org.junit.Assert.*;

import javax.measure.spi.FormatService;
import javax.measure.spi.FormatService.FormatType;
import javax.measure.spi.ServiceProvider;
import org.junit.Test;

public class FormatServiceTest {

	@Test
	public void testNumberOfFormatServices() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			final String providerName = provider.getClass().getName();
			//System.out.println(providerName);
            FormatService formatService = provider.getFormatService();
            //System.out.println(formatService.toString());
            assertEquals(4, formatService.getAvailableFormatNames(FormatType.UNIT_FORMAT).size());
            assertEquals(4, formatService.getAvailableFormatNames(FormatType.QUANTITY_FORMAT).size());
        }
	}
	
	@Test
	public void testUnitFormatServices() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			final String providerName = provider.getClass().getName();
			//System.out.println(providerName);
            FormatService formatService = provider.getFormatService();
            for (String serviceName : formatService.getAvailableFormatNames(FormatType.UNIT_FORMAT)) {
            	assertNotNull(formatService.getUnitFormat(serviceName));
            }
        }
	}
	
	@Test
	public void testQuantityFormatServices() {
		for (ServiceProvider provider : ServiceProvider.available()) {
			final String providerName = provider.getClass().getName();
			//System.out.println(providerName);
            FormatService formatService = provider.getFormatService();
            for (String serviceName : formatService.getAvailableFormatNames(FormatType.QUANTITY_FORMAT)) {
            	assertNotNull(formatService.getQuantityFormat(serviceName));
            }
        }
	}
}