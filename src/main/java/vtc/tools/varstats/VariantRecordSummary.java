/**
 * 
 */
package vtc.tools.varstats;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import org.json.JSONException;
import org.json.JSONObject;

import org.broadinstitute.variant.variantcontext.Allele;

import vtc.tools.utilitybelt.UtilityBelt;

/**
 * @author markebbert
 *
 */
public class VariantRecordSummary {

	private String chr;
	private int position;
	private Allele ref;
	private TreeSet<Allele> alts;
	private TreeSet<String> insertions, deletions;
	private int snvCount, mnvCount, indelCount, insCount,
		delCount, structIndelCount, structInsCount,
		structDelCount, tiCount, tvCount, genoTiCount,
		genoTvCount, refGenotypeCount, refSampleCount,
		nSamples, nSamplesWithCall, nGenosCalled;
	private String quality;
	private HashMap<Allele, Integer> altGenotypeCounts, altSampleCounts,
		hetSampleCounts, homoVarSampleCounts;
	private Depth depth;
	

	/**
	 * @param chr
	 * @param position
	 * @param ref
	 * @param alts
	 */
	public VariantRecordSummary(String chr, int position, Allele ref, TreeSet<Allele> alts) {
		this.chr = chr;
		this.position = position;
		this.ref = ref;
		this.alts = alts;
		init();
	}

	/**
	 * @param snpCount
	 * @param mnpCount
	 * @param indelCount
	 * @param insCount
	 * @param delCount
	 * @param structIndelCount
	 * @param structInsCount
	 * @param structDelCount
	 * @param tiCount
	 * @param tvCount
	 */
	public VariantRecordSummary(String chr, int position, Allele ref, TreeSet<Allele> alts,
			int snpCount, int mnpCount, int indelCount,
			int insCount, int delCount, int structIndelCount,
			int structInsCount, int structDelCount, int tiCount, int tvCount) {
		this.chr = chr;
		this.position = position;
		this.ref = ref;
		this.alts = alts;
		this.snvCount = snpCount;
		this.mnvCount = mnpCount;
		this.indelCount = indelCount;
		this.insCount = insCount;
		this.delCount = delCount;
		this.structIndelCount = structIndelCount;
		this.structInsCount = structInsCount;
		this.structDelCount = structDelCount;
		this.tiCount = tiCount;
		this.tvCount = tvCount;
		init();
	}
	
	private void init(){
		this.insertions = new TreeSet<String>();
		this.deletions = new TreeSet<String>();
	}

	/**
	 * @return the chr
	 */
	public String getChr() {
		return chr;
	}

	/**
	 * @param chr the chr to set
	 */
	public void setChr(String chr) {
		this.chr = chr;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String getID() {
		return this.getChr() + ":" + this.getPosition() + ":" + this.getRef().getBaseString();
	}

	/**
	 * @return the ref
	 */
	public Allele getRef() {
		return ref;
	}

	/**
	 * @param ref the ref to set
	 */
	public void setRef(Allele ref) {
		this.ref = ref;
	}

	/**
	 * @return the alts
	 */
	public TreeSet<Allele> getAlts() {
		return alts;
	}

	/**
	 * @param alts the alts to set
	 */
	public void setAlts(TreeSet<Allele> alts) {
		this.alts = alts;
	}

	/**
	 * @return the snpCount
	 */
	public int getSnvCount() {
		return snvCount;
	}

	/**
	 * @param snpCount the snpCount to set
	 */
	public void setSnvCount(int snpCount) {
		this.snvCount = snpCount;
	}

	/**
	 * @return the mnpCount
	 */
	public int getMnvCount() {
		return mnvCount;
	}

	/**
	 * @param mnpCount the mnpCount to set
	 */
	public void setMnvCount(int mnvCount) {
		this.mnvCount = mnvCount;
	}

	/**
	 * @return the indelCount
	 */
	public int getIndelCount() {
		return indelCount;
	}

	/**
	 * @param indelCount the indelCount to set
	 */
	public void setIndelCount(int indelCount) {
		this.indelCount = indelCount;
	}

	/**
	 * @return the insCount
	 */
	public int getInsCount() {
		return insCount;
	}

	/**
	 * @param insCount the insCount to set
	 */
	public void setInsCount(int insCount) {
		this.insCount = insCount;
	}

	/**
	 * @return the delCount
	 */
	public int getDelCount() {
		return delCount;
	}

	/**
	 * @param delCount the delCount to set
	 */
	public void setDelCount(int delCount) {
		this.delCount = delCount;
	}

	/**
	 * @return the structIndelCount
	 */
	public int getStructIndelCount() {
		return structIndelCount;
	}

	/**
	 * @param structIndelCount the structIndelCount to set
	 */
	public void setStructIndelCount(int structIndelCount) {
		this.structIndelCount = structIndelCount;
	}

	/**
	 * @return the structInsCount
	 */
	public int getStructInsCount() {
		return structInsCount;
	}

	/**
	 * @param structInsCount the structInsCount to set
	 */
	public void setStructInsCount(int structInsCount) {
		this.structInsCount = structInsCount;
	}

	/**
	 * @return the structDelCount
	 */
	public int getStructDelCount() {
		return structDelCount;
	}

	/**
	 * @param structDelCount the structDelCount to set
	 */
	public void setStructDelCount(int structDelCount) {
		this.structDelCount = structDelCount;
	}

	/**
	 * @return the tiCount
	 */
	public int getTiCount() {
		return tiCount;
	}

	/**
	 * @param tiCount the tiCount to set
	 */
	public void setTiCount(int tiCount) {
		this.tiCount = tiCount;
	}

	/**
	 * @return the tvCount
	 */
	public int getTvCount() {
		return tvCount;
	}

	/**
	 * @param tvCount the tvCount to set
	 */
	public void setTvCount(int tvCount) {
		this.tvCount = tvCount;
	}

	/**
	 * @return the genoTiCount
	 */
	public int getGenoTiCount() {
		return genoTiCount;
	}

	/**
	 * @param genoTiCount the genoTiCount to set
	 */
	public void setGenoTiCount(int genoTiCount) {
		this.genoTiCount = genoTiCount;
	}

	/**
	 * @return the genoTvCount
	 */
	public int getGenoTvCount() {
		return genoTvCount;
	}

	/**
	 * @param genoTvCount the genoTvCount to set
	 */
	public void setGenoTvCount(int genoTvCount) {
		this.genoTvCount = genoTvCount;
	}

	/**
	 * @return the refGenotypeCount
	 */
	public int getRefGenotypeCount() {
		return refGenotypeCount;
	}

	/**
	 * @param refGenotypeCount the refGenotypeCount to set
	 */
	public void setRefGenotypeCount(int refGenotypeCount) {
		this.refGenotypeCount = refGenotypeCount;
	}

	/**
	 * @return the refSampleCount
	 */
	public int getRefSampleCount() {
		return refSampleCount;
	}

	/**
	 * @param refSampleCount the refSampleCount to set
	 */
	public void setRefSampleCount(int refSampleCount) {
		this.refSampleCount = refSampleCount;
	}

	/**
	 * @return the altSampleCounts
	 */
	public HashMap<Allele, Integer> getAltSampleCounts() {
		return altSampleCounts;
	}
	
	/**
	 * @param alt
	 * @return The number of samples 'alt' was observed in
	 */
	public Integer getAltSampleCount(Allele alt){
		if(this.getAltSampleCounts().get(alt) != null){
            return this.getAltSampleCounts().get(alt);
		}
		return 0;
	}

	/**
	 * @param altSampleCounts the altSampleCounts to set
	 */
	public void setAltSampleCounts(HashMap<Allele, Integer> altSampleCounts) {
		this.altSampleCounts = altSampleCounts;
	}

	/**
	 * @return the altGenotypeCounts
	 */
	public HashMap<Allele, Integer> getAltGenotypeCounts() {
		return altGenotypeCounts;
	}
	
	/**
	 * Get the genotype count for 'alt'
	 * @param alt
	 * @return the number of 'alt' alleles in this record
	 */
	public Integer getAltGenotypeCount(Allele alt){
		if(this.getAltGenotypeCounts().get(alt) != null){
            return this.getAltGenotypeCounts().get(alt);
		}
		return 0;
	}

	/**
	 * @param altGenotypeCounts the altGenotypeCounts to set
	 */
	public void setAltGenotypeCounts(HashMap<Allele, Integer> altGenotypeCounts) {
		this.altGenotypeCounts = altGenotypeCounts;
	}
	
	public HashMap<Allele, Integer> getHetSampleCounts(){
		return this.hetSampleCounts;
	}
	
	public Integer getHetSampleCount(Allele alt){
		if(this.getHetSampleCounts().get(alt) != null){
            return this.getHetSampleCounts().get(alt);
		}
		return 0;
	}
	
	public void setHetSampleCounts(HashMap<Allele, Integer> hetSampleCounts){
		this.hetSampleCounts = hetSampleCounts;
	}
	
	public HashMap<Allele, Integer> getHomoVarSampleCounts(){
		return this.homoVarSampleCounts;
	}
		
	public Integer getHomoVarSampleCount(Allele alt){
		if(this.getHomoVarSampleCounts().get(alt) != null){
            return this.getHomoVarSampleCounts().get(alt);
		}
		return 0;
	}

	public void setHomoVarSampleCounts(HashMap<Allele, Integer> homoVarSampleCounts){
		this.homoVarSampleCounts = homoVarSampleCounts;
	}
	
	/**
	 * @return HashMap<Allele, Double> of the frequency of samples
	 * each alternate allele was observed in.
	 */
	public HashMap<Allele, Double> getAltSampleFreqs() {
		
		HashMap<Allele, Double> altSampleFreqs = new HashMap<Allele, Double>();
		for(Allele alt : this.getAlts()){
			double altSampFreq = (this.getnSamplesWithCall() > 0) ?
					UtilityBelt.round((double)this.getAltSampleCount(alt)/this.getnSamplesWithCall(),
							2, BigDecimal.ROUND_HALF_UP) : 0;
			altSampleFreqs.put(alt, altSampFreq);
		}
		return altSampleFreqs;
	}
	
	/**
	 * @return HashMap<Allele, Double> of the genotype frequencies for
	 * each alt allele
	 */
	public HashMap<Allele, Double> getAltGenotypeFreqs(){
		HashMap<Allele, Double> altGenoFreqs = new HashMap<Allele, Double>();
		for(Allele alt : this.getAlts()){
            double altGenoFreq = (this.getnGenosCalled() > 0) ?
            		UtilityBelt.round((double)this.getAltGenotypeCount(alt)/this.getnGenosCalled(),
            				2, BigDecimal.ROUND_HALF_UP) : 0;
            altGenoFreqs.put(alt, altGenoFreq);
		}
		return altGenoFreqs;
	}
	
	/**
	 * @return the quality
	 */
	public String getQuality() {
		return quality;
	}

	/**
	 * @param quality the quality to set
	 */
	public void setQuality(String quality) {
		this.quality = quality;
	}

	/**
	 * @return the depth, or null if does not exist
	 */
	public Depth getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(Depth depth) {
		this.depth = depth;
	}
	
	public TreeSet<String> getInsertions(){
		return this.insertions;
	}
	
	public void addInsertion(String insertion){
		this.insertions.add(insertion);
	}
	
	/**
	 * Get the smallest insertion length
	 * @return
	 */
	public int getSmallestInsertionLength(){
		return UtilityBelt.getSmallestLength(this.insertions);
	}
	
	/**
	 * Get the largest insertion length
	 * @return
	 */
	public int getLargestInsertionLength(){
		return UtilityBelt.getLargestLength(this.insertions);
	}
	
	/**
	 * Get the average insertion length
	 * @return
	 */
	public double getAverageInsertionLength(){
		return UtilityBelt.getAverageLength(this.insertions);
	}
	
	public TreeSet<String> getDeletions(){
		return this.deletions;
	}
	
	public void addDeletion(String deletion){
		this.deletions.add(deletion);
	}
	
		/**
	 * Get the smallest deletion length
	 * @return
	 */
	public int getSmallestDeletionLength(){
		return UtilityBelt.getSmallestLength(this.deletions);
	}
	
	/**
	 * Get the largest deletion length
	 * @return
	 */
	public int getLargestDeletionLength(){
		return UtilityBelt.getLargestLength(this.deletions);
	}
	
	/**
	 * Get average deletion length
	 * @return
	 */
	public double getAverageDeletionLength(){
		return UtilityBelt.getAverageLength(this.deletions);
	}
	
	/**
	 * @return the nSamples
	 */
	public int getnSamples() {
		return nSamples;
	}

	/**
	 * @param nSamples the nSamples to set
	 */
	public void setnSamples(int nSamples) {
		this.nSamples = nSamples;
	}

	/**
	 * @return the nSamplesWithCall
	 */
	public int getnSamplesWithCall() {
		return nSamplesWithCall;
	}

	/**
	 * @param nSamplesWithCall the nSamplesWithCall to set
	 */
	public void setnSamplesWithCall(int nSamplesWithCall) {
		this.nSamplesWithCall = nSamplesWithCall;
	}
	
	public int getnGenosCalled() {
		return nGenosCalled;
	}
	
	public void setnGenosCalled(int nGenosCalled) {
		this.nGenosCalled = nGenosCalled;
	}

	/**
	 * Create a comma-separated string
	 * with all alts
	 * 
	 * @param alts
	 * @return
	 */
	public String altToString(){
		
		StringBuilder altString = new StringBuilder();
		TreeSet<Allele> alts = this.getAlts();
		if(alts.isEmpty()){
			altString.append(".");
			return altString.toString();
		}

		boolean first = true;
		for(Allele alt : alts){
			if(!first){
				altString.append(",");
			}
            altString.append(alt);
            first = false;
		}
		return altString.toString();
	}
	
	/**
	 * Format the given statistic for each alternate allele.
	 * @param altStat
	 * @return
	 */
	public String altStatArrayToString(HashMap<Allele, ?> altStat){
		StringBuilder sb = new StringBuilder();
		TreeSet<Allele> alts = this.getAlts();
		if(alts.isEmpty()){
			sb.append("0");
			return sb.toString();
		}

		boolean first = true;
		for(Allele alt : this.getAlts()){
			if(!first){
				sb.append(",");
			}
            sb.append(altStat.get(alt));
            first = false;
		}
		return sb.toString();
	}
	
	/**
	 * Generate a String including the Chr, pos, ref,
	 * alt, number of Het samples for the alt, number
	 * of Homo samples for the alt, total number of
	 * samples where the locus was callable, and the
	 * total number of samples where calls were attempted
	 * at this locus. All of this information is generated
	 * for each alternate allele on separate lines using
	 * '\n'
	 * @return
	 */
	public String toStringSimpleByAlt(){
		if(this.getAlts().size() == 0){
			return generateString(null);
		}
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		for(Allele alt : this.getAlts()){
			if(!first){ // If more than one alt, add newline
				sb.append("\n");
			}
			sb.append(generateString(alt));
            first = false;
		}
		return sb.toString();
	}
	
	public String generateString(Allele alt){
		StringBuilder sb = new StringBuilder();
        sb.append(this.getChr());
        sb.append(",");
        sb.append(this.getPosition());
        sb.append(",");
        sb.append(this.getRef().getBaseString());
        sb.append(",");
        if(alt != null){
            sb.append(alt.getBaseString());
            sb.append(",");
            sb.append(this.getHetSampleCount(alt));
            sb.append(",");
            sb.append(this.getHomoVarSampleCount(alt));
            sb.append(",");
            sb.append(this.getnSamplesWithCall());
            sb.append(",");
            sb.append(this.getnSamples());	
        }
        else{
            sb.append(",");
            sb.append(",");
            sb.append(",");
            sb.append(this.getnSamplesWithCall());
            sb.append(",");
            sb.append(this.getnSamples());	
        }
        return sb.toString();
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.getChr());
		sb.append("\t");
		sb.append(this.getPosition());
		sb.append("\t");
		sb.append(this.getID());
		sb.append("\t");
		sb.append(this.getRef().getBaseString());
		sb.append("\t");
		sb.append(this.altToString());
		sb.append("\t");
		sb.append(this.getRefGenotypeCount());
		sb.append("\t");
		sb.append(this.altStatArrayToString(this.getAltGenotypeCounts()));
		sb.append("\t");
		sb.append(this.getRefSampleCount());
		sb.append("\t");
		sb.append(this.altStatArrayToString(this.getAltSampleCounts()));
		sb.append("\t");
		sb.append(this.getnSamplesWithCall());
		sb.append("\t");
		sb.append(this.getnGenosCalled());
		sb.append("\t");
		sb.append(this.getnSamples());
		sb.append("\t");
		sb.append(this.altStatArrayToString(this.getAltGenotypeFreqs()));
		sb.append("\t");
		sb.append(this.altStatArrayToString(this.getAltSampleFreqs()));
		if(this.getDepth() != null){
            sb.append("\t");
            sb.append(this.getDepth().getMinDepth());
            sb.append("\t");
            sb.append(this.getDepth().getMaxDepth());
            sb.append("\t");
            sb.append(this.getDepth().getAvgDepth());
		}
		else{
            sb.append("\t");
            sb.append("NA");
            sb.append("\t");
            sb.append("NA");
            sb.append("\t");
            sb.append("NA");
		}
		sb.append("\t");
		sb.append(this.getQuality());
		return sb.toString();
	}
	
	/**
	 * Form an ArrayList<JSONObject> for each alternate allele in
	 * this VariantRecordSummary
	 * 
	 * @return
	 * @throws JSONException
	 */
	public ArrayList<JSONObject> toJSON() throws JSONException{
		ArrayList<JSONObject> altAlleleSummaries = new ArrayList<JSONObject>();
		JSONObject summary;
		
		for(Allele alt : this.getAlts()){
			summary = new JSONObject();
            summary.put("chr", this.getChr());
            summary.put("pos", this.getPosition());
            summary.put("ref", this.getRef());
            summary.put("alt", alt);
            summary.put("hetSampleCount", this.getHetSampleCount(alt));
            summary.put("homoVarSampleCount", this.getHomoVarSampleCount(alt));
            summary.put("totalSamplesWithCoverage", this.getnSamplesWithCall());
            summary.put("totalSamples", this.getnSamples());
            altAlleleSummaries.add(summary);
		}
		return altAlleleSummaries;
	}
	
	/**
	 * Add two VariantRecordSummary objects together
	 * 
	 * @param vrs1
	 * @param vrs2
	 * @return a new VariantRecordSummary
	 */
	public static VariantRecordSummary addVariantRecordSummaries(VariantRecordSummary vrs1, VariantRecordSummary vrs2){
		
		String vrs1Key = vrs1.getChr() + ":" + vrs1.getPosition() + ":" + vrs1.getRef().getBaseString();
		String vrs2Key = vrs2.getChr() + ":" + vrs2.getPosition() + ":" + vrs2.getRef().getBaseString();
		/* Make sure the two are for the same position and ref */
		if(vrs1Key.equals(vrs2Key)){
			
			/* Add all vrs1 alleles and then add any new alleles from vrs2 */
			TreeSet<Allele> newAlts = new TreeSet<Allele>(vrs1.getAlts());
			newAlts.addAll(vrs2.getAlts());

            VariantRecordSummary newVRS = new VariantRecordSummary(vrs1.getChr(), vrs1.getPosition(), vrs1.getRef(), newAlts);
			newVRS.setIndelCount(vrs1.getIndelCount() + vrs2.getIndelCount());
			newVRS.setInsCount(vrs1.getInsCount() + vrs2.getInsCount());
			newVRS.setDelCount(vrs1.getDelCount() + vrs2.getDelCount());
			newVRS.setDepth(null);
			newVRS.setGenoTiCount(vrs1.getGenoTiCount() + vrs2.getGenoTiCount());
			newVRS.setGenoTvCount(vrs1.getGenoTvCount() + vrs2.getGenoTvCount());
			newVRS.setMnvCount(vrs1.getMnvCount() + vrs2.getMnvCount());
			newVRS.setnGenosCalled(vrs1.getnGenosCalled() + vrs2.getnGenosCalled());
			newVRS.setnSamples(vrs1.getnSamples() + vrs2.getnSamples());
			newVRS.setnSamplesWithCall(vrs1.getnSamplesWithCall() + vrs2.getnSamplesWithCall());
			newVRS.setQuality("NA");
			newVRS.setRefGenotypeCount(vrs1.getRefGenotypeCount() + vrs2.getRefGenotypeCount());
			newVRS.setRefSampleCount(vrs1.getRefSampleCount() + vrs2.getRefSampleCount());
			newVRS.setSnvCount(vrs1.getSnvCount() + vrs2.getSnvCount());
			newVRS.setStructIndelCount(vrs1.getStructIndelCount() + vrs2.getStructIndelCount());
			newVRS.setStructInsCount(vrs1.getStructInsCount() + vrs2.getStructInsCount());
			newVRS.setStructDelCount(vrs1.getStructDelCount() + vrs2.getStructDelCount());
			newVRS.setTiCount(vrs1.getTiCount() + vrs2.getTiCount());
			newVRS.setTvCount(vrs1.getTvCount() + vrs2.getTvCount());
			
			/* Set alt-specific values */
            HashMap<Allele, Integer> altGenotypeCounts = new HashMap<Allele, Integer>(),
                altSampleCounts = new HashMap<Allele, Integer>(),
                hetSampleCounts = new HashMap<Allele, Integer>(),
                homoVarSampleCounts = new HashMap<Allele, Integer>();
			for(Allele alt : newAlts){
				altGenotypeCounts.put(alt, vrs1.getAltGenotypeCount(alt) + vrs2.getAltGenotypeCount(alt));
				altSampleCounts.put(alt, vrs1.getAltSampleCount(alt) + vrs2.getAltSampleCount(alt));
				hetSampleCounts.put(alt, vrs1.getHetSampleCount(alt) + vrs2.getHetSampleCount(alt));
				homoVarSampleCounts.put(alt, vrs1.getHomoVarSampleCount(alt) + vrs2.getHomoVarSampleCount(alt));
			}
            newVRS.setAltGenotypeCounts(altGenotypeCounts);
            newVRS.setAltSampleCounts(altSampleCounts);
            newVRS.setHetSampleCounts(hetSampleCounts);
            newVRS.setHomoVarSampleCounts(homoVarSampleCounts);
            
            return newVRS;
		}
		else{
			throw new RuntimeException("Something is very wrong! Cannot add two VariantRecordSummary objects unless" +
					" they have the same chr:pos:ref. Trying to add " + vrs1Key + " and " + vrs2Key);
		}
	}
	
}
