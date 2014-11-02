package jp.ac.keio.sfc.ht.memsys.usa;

import jp.ac.keio.sfc.ht.memsys.usa.util.Complex;
import jp.ac.keio.sfc.ht.memsys.usa.util.DataParser;

import java.util.ArrayList;

/**
 * Created by usa on 10/31/14.
 */
public class Main {

    public static void main(String[] args) {
        int fftSize = 4000;
        int numDopplerBins = 81;

        Complex[] in = DataParser.convertToComplexArray("sampledata/in.dat");
        ArrayList<Complex[]> dopplerWipeoffs = DataParser.convertToComplexArrayList("sampledata/doppler_wipeoff.dat");
        Complex[] prn = DataParser.convertToComplexArray("sampledata/prn.dat");

        Acquisition acq = new Acquisition(in, dopplerWipeoffs, prn, numDopplerBins);
        double magt = acq.lookForPeak();

        System.out.println(magt);

    }
}
