package com.bornfire.xbrl.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.BRBS.Ecl_upload_Entity;
import com.bornfire.xbrl.entities.BRBS.Ecl_upload_Repo;

@Service
public class EclmasterService {

	@Autowired
	Ecl_upload_Repo Ecl_upload_Repo;

	@Autowired
	SessionFactory sessionFactory;

	public String UploadPO(String screenId, MultipartFile file, String userid, Ecl_upload_Entity ecl_upload_Entity)
			throws SQLException, FileNotFoundException, IOException {
		System.out.println("Entering Second Service Succesfully");
		String fileName = file.getOriginalFilename();

		String fileExt = "";
		String msg = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			fileExt = fileName.substring(i + 1);
		}

		ArrayList<Ecl_upload_Entity> result = new ArrayList<Ecl_upload_Entity>();
		if (fileExt.equals("xlsx") || fileExt.equals("xls")) {

			try {
				Workbook workbook = WorkbookFactory.create(file.getInputStream());

				List<HashMap<Integer, String>> mapList = new ArrayList<>();
				for (Sheet s : workbook) {
					for (Row r : s) {

						if (!isRowEmpty(r)) {
							if (r.getRowNum() == 0) {
								continue;
							}

							String val = null;

							HashMap<Integer, String> map = new HashMap<>();

							for (int j = 0; j < 65; j++) {

								Cell cell = r.getCell(j);
								DataFormatter formatter = new DataFormatter();
								String text = formatter.formatCellValue(cell);
								map.put(j, text);
							}
							mapList.add(map);

						}

					}

				}

				for (HashMap<Integer, String> item : mapList) {
					Ecl_upload_Entity PO = new Ecl_upload_Entity();

					if (item.get(0) == null || item.get(0).isEmpty()) {
						msg = "Excel Sheet Empty";
						System.out.println(msg);
					} else {
						if (item.get(0) != null) {

							// PO.setFacilityid(numberBD);
						} else {
							// Handle the case where item.get(4) is null or not suitable for conversion
							System.err.println("Transaction amount is null or not convertible to BigDecimal.");
						}

						// BIGDECIMAL-dpdbucket
						String dpdbucket = item.get(9);
						BigDecimal dpdbucket1 = null;

						// Check for null or empty before attempting conversion
						if (dpdbucket != null && !dpdbucket.trim().isEmpty()) {
							try {
								dpdbucket1 = new BigDecimal(dpdbucket.trim());
								System.out.println("The number as BigDecimal is:dpdbucket " + dpdbucket);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// BIGDECIMAL-limit
						String limit = item.get(11);
						BigDecimal limit1 = null;

						// Check for null or empty before attempting conversion
						if (limit != null && !limit.trim().isEmpty()) {
							try {
								limit1 = new BigDecimal(limit.trim());
								System.out.println("The number as BigDecimal is limit: " + limit);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}

						// BIGDECIMAL-drawnamount
						String drawnamount = item.get(12);
						BigDecimal drawnamount1 = null;

						// Check for null or empty before attempting conversion
						if (drawnamount != null && !drawnamount.trim().isEmpty()) {
							try {
								drawnamount1 = new BigDecimal(drawnamount.trim());
								System.out.println("The number as BigDecimal is drawnamount: " + drawnamount);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// BIGDECIMAL-undrawnamount
						String undrawnamount = item.get(13);
						BigDecimal undrawnamount1 = null;

						// Check for null or empty before attempting conversion
						if (undrawnamount != null && !undrawnamount.trim().isEmpty()) {
							try {
								undrawnamount1 = new BigDecimal(undrawnamount.trim());
								System.out.println("The number as BigDecimal is: undrawnamount1 " + undrawnamount);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// BIGDECIMAL-ccf
						String ccf = item.get(14);
						BigDecimal ccf1 = null;

						// Check for null or empty before attempting conversion
						if (ccf != null && !ccf.trim().isEmpty()) {
							try {
								ccf1 = new BigDecimal(ccf.trim());
								System.out.println("The number as BigDecimal is ccf: " + ccf);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// BIGDECIMAL-ead
						String ead = item.get(15);
						BigDecimal ead1 = null;

						// Check for null or empty before attempting conversion
						if (ead != null && !ead.trim().isEmpty()) {
							try {
								ead1 = new BigDecimal(ead.trim());
								System.out.println("The number as BigDecimal is ead: " + ead);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						String paymentfrequency = item.get(19);
						BigDecimal paymentfrequency1 = null;

						// Check for null or empty before attempting conversion
						if (paymentfrequency != null && !paymentfrequency.trim().isEmpty()) {
							try {
								paymentfrequency1 = new BigDecimal(paymentfrequency.trim());
								System.out.println("The number as BigDecimal is: " + paymentfrequency);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// eir
						String eir = item.get(20);
						BigDecimal eir1 = null;

						// Check for null or empty before attempting conversion
						if (eir != null && !eir.trim().isEmpty()) {
							try {
								eir1 = new BigDecimal(eir.trim());
								System.out.println("The number as BigDecimal is: " + eir);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// collateralvalue
						String collateralvalue = item.get(22);
						BigDecimal collateralvalue1 = null;

						// Check for null or empty before attempting conversion
						if (collateralvalue != null && !collateralvalue.trim().isEmpty()) {
							try {
								collateralvalue1 = new BigDecimal(collateralvalue.trim());
								System.out.println("The number as BigDecimal is: " + collateralvalue);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// basepd
						String basepd = item.get(23);
						BigDecimal basepd1 = null;

						// Check for null or empty before attempting conversion
						if (basepd != null && !basepd.trim().isEmpty()) {
							try {
								basepd1 = new BigDecimal(basepd.trim());
								System.out.println("The number as BigDecimal is basepd: " + basepd);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// positivepd
						String positivepd = item.get(24);
						BigDecimal positivepd1 = null;

						// Check for null or empty before attempting conversion
						if (positivepd != null && !positivepd.trim().isEmpty()) {
							try {
								positivepd1 = new BigDecimal(positivepd.trim());
								System.out.println("The number as BigDecimal is: " + positivepd);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
												// collateralvalue
						String negativepd = item.get(25);
						BigDecimal negativepd1 = null;

						// Check for null or empty before attempting conversion
						if (negativepd != null && !negativepd.trim().isEmpty()) {
							try {
								negativepd1 = new BigDecimal(negativepd.trim());
								System.out.println("The number as BigDecimal is: " + negativepd);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// unsecuredlgdrate
						String unsecuredlgdrate = item.get(27);
						BigDecimal unsecuredlgdrate1 = null;

						// Check for null or empty before attempting conversion
						if (unsecuredlgdrate != null && !unsecuredlgdrate.trim().isEmpty()) {
							try {
								unsecuredlgdrate1 = new BigDecimal(unsecuredlgdrate.trim());
								System.out.println("The number as BigDecimal is: " + unsecuredlgdrate);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// collateralvalue
						String lgdrate = item.get(28);
						BigDecimal lgdrate1 = null;

						// Check for null or empty before attempting conversion
						if (lgdrate != null && !lgdrate.trim().isEmpty()) {
							try {
								lgdrate1 = new BigDecimal(lgdrate.trim());
								System.out.println("The number as BigDecimal is: " + lgdrate);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
							// pastduedays
						String pastduedays = item.get(29);
						BigDecimal pastduedays1 = null;

						// Check for null or empty before attempting conversion
						if (pastduedays != null && !pastduedays.trim().isEmpty()) {
							try {
								pastduedays1 = new BigDecimal(pastduedays.trim());
								System.out.println("The number as BigDecimal is: " + pastduedays);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						
						// lecl_base
						String lecl_base = item.get(32);
						BigDecimal lecl_base1 = null;

						// Check for null or empty before attempting conversion
						if (lecl_base != null && !lecl_base.trim().isEmpty()) {
							try {
								lecl_base1 = new BigDecimal(lecl_base.trim());
								System.out.println("The number as BigDecimal islecl_base: " + lecl_base);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// lecl_positive
						String lecl_positive = item.get(33);
						BigDecimal lecl_positive1 = null;

						// Check for null or empty before attempting conversion
						if (lecl_positive != null && !lecl_positive.trim().isEmpty()) {
							try {
								lecl_positive1 = new BigDecimal(lecl_positive.trim());
								System.out.println("The number as BigDecimal islecl_positive: " + lgdrate);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
							// lecl_negative

						String lecl_negative = item.get(34);
						BigDecimal lecl_negative1 = null;

						// Check for null or empty before attempting conversion
						if (lecl_negative != null && !lecl_negative.trim().isEmpty()) {
							try {
								lecl_negative1 = new BigDecimal(lecl_negative.trim());
								System.out.println("The number as BigDecimal islecl_negative: " + lecl_negative);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
					
							// life_time_weigthed

						String life_time_weigthed = item.get(35);
						BigDecimal life_time_weigthed1 = null;

						// Check for null or empty before attempting conversion
						if (life_time_weigthed != null && !life_time_weigthed.trim().isEmpty()) {
							try {
								life_time_weigthed1 = new BigDecimal(life_time_weigthed.trim());
								System.out.println("The number as BigDecimal life_time_weigthed: " + life_time_weigthed);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// ecl12m_base



						String ecl12m_base = item.get(36);
						BigDecimal ecl12m_base1 = null;

						// Check for null or empty before attempting conversion
						if (ecl12m_base != null && !ecl12m_base.trim().isEmpty()) {
							try {
								ecl12m_base1 = new BigDecimal(ecl12m_base.trim());
								System.out.println("The number as BigDecimal ecl12m_base: " + ecl12m_base);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						
											// ecl12m_positive


						String ecl12m_positive = item.get(37);
						BigDecimal ecl12m_positive1 = null;

						// Check for null or empty before attempting conversion
						if (ecl12m_positive != null && !ecl12m_positive.trim().isEmpty()) {
							try {
								ecl12m_positive1 = new BigDecimal(ecl12m_positive.trim());
								System.out.println("The number as BigDecimal ecl12m_positive: " + ecl12m_positive);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// ecl12m_positive

						String ecl12m_negative = item.get(38);
						BigDecimal ecl12m_negative1 = null;

						// Check for null or empty before attempting conversion
						if (ecl12m_negative != null && !ecl12m_negative.trim().isEmpty()) {
							try {
								ecl12m_negative1 = new BigDecimal(ecl12m_negative.trim());
								System.out.println("The number as BigDecimal ecl12m_negative: " + ecl12m_negative);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
							// a12monthweighted


						String a12monthweighted = item.get(39);
						BigDecimal a12monthweighted1 = null;

						// Check for null or empty before attempting conversion
						if (a12monthweighted != null && !a12monthweighted.trim().isEmpty()) {
							try {
								a12monthweighted1 = new BigDecimal(a12monthweighted.trim());
								System.out.println("The number as BigDecimal a12monthweighted: " + a12monthweighted);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
							// ifrs9_ecl_number_base


						String ifrs9_ecl_number_base = item.get(40);
						BigDecimal ifrs9_ecl_number_base1 = null;

						// Check for null or empty before attempting conversion
						if (ifrs9_ecl_number_base != null && !ifrs9_ecl_number_base.trim().isEmpty()) {
							try {
								ifrs9_ecl_number_base1 = new BigDecimal(ifrs9_ecl_number_base.trim());
								System.out.println("The number as BigDecimal ifrs9_ecl_number_base: " + ifrs9_ecl_number_base);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
							// ifrs9_ecl_number_positive


						String ifrs9_ecl_number_positive = item.get(41);
						BigDecimal ifrs9_ecl_number_positive1 = null;

						// Check for null or empty before attempting conversion
						if (ifrs9_ecl_number_positive != null && !ifrs9_ecl_number_positive.trim().isEmpty()) {
							try {
								ifrs9_ecl_number_positive1 = new BigDecimal(ifrs9_ecl_number_positive.trim());
								System.out.println("The number as BigDecimal ifrs9_ecl_number_positive: " + ifrs9_ecl_number_positive);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
							// ifrs9_ecl_number_negative


						String ifrs9_ecl_number_negative = item.get(42);
						BigDecimal ifrs9_ecl_number_negative1 = null;

						// Check for null or empty before attempting conversion
						if (ifrs9_ecl_number_negative != null && !ifrs9_ecl_number_negative.trim().isEmpty()) {
							try {
								ifrs9_ecl_number_negative1 = new BigDecimal(ifrs9_ecl_number_negative.trim());
								System.out.println("The number as BigDecimal ifrs9_ecl_number_negative: " + ifrs9_ecl_number_negative);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						
							// finalweightedecl


						String finalweightedecl = item.get(43);
						BigDecimal finalweightedecl1 = null;

						// Check for null or empty before attempting conversion
						if (finalweightedecl != null && !finalweightedecl.trim().isEmpty()) {
							try {
								finalweightedecl1 = new BigDecimal(finalweightedecl.trim());
								System.out.println("The number as BigDecimal finalweightedecl: " + finalweightedecl);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// ecl_incul_deferral

						String ecl_incul_deferral = item.get(45);
						BigDecimal ecl_incul_deferral1 = null;

						// Check for null or empty before attempting conversion
						if (ecl_incul_deferral != null && !ecl_incul_deferral.trim().isEmpty()) {
							try {
								ecl_incul_deferral1 = new BigDecimal(ecl_incul_deferral.trim());
								System.out.println("The number as BigDecimal ecl_incul_deferral: " + ecl_incul_deferral);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// ecl_mgmt_overlay

						String ecl_mgmt_overlay = item.get(46);
						BigDecimal ecl_mgmt_overlay1 = null;

						// Check for null or empty before attempting conversion
						if (ecl_mgmt_overlay != null && !ecl_mgmt_overlay.trim().isEmpty()) {
							try {
								ecl_mgmt_overlay1 = new BigDecimal(ecl_mgmt_overlay.trim());
								System.out.println(" ecl_mgmt_overlay: " + ecl_mgmt_overlay);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
							// specific_provision


						String specific_provision = item.get(47);
						BigDecimal specific_provision1 = null;

						// Check for null or empty before attempting conversion
						if (specific_provision != null && !specific_provision.trim().isEmpty()) {
							try {
								specific_provision1 = new BigDecimal(specific_provision.trim());
								System.out.println("The number as BigDecimal specific_provision: " + specific_provision);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
					
							// interest_suspense



						String interest_suspense = item.get(48);
						BigDecimal interest_suspense1 = null;

						// Check for null or empty before attempting conversion
						if (interest_suspense != null && !interest_suspense.trim().isEmpty()) {
							try {
								interest_suspense1 = new BigDecimal(interest_suspense.trim());
								System.out.println("interest_suspense: " + interest_suspense);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// modificationflag




						String modificationflag = item.get(49);
						BigDecimal modificationflag1 = null;

						// Check for null or empty before attempting conversion
						if (modificationflag != null && !modificationflag.trim().isEmpty()) {
							try {
								modificationflag1 = new BigDecimal(modificationflag.trim());
								System.out.println("The number as BigDecimal modificationflag: " + modificationflag);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						
											// modificationvalue



						String modificationvalue = item.get(50);
						BigDecimal modificationvalue1 = null;

						// Check for null or empty before attempting conversion
						if (modificationvalue != null && !modificationvalue.trim().isEmpty()) {
							try {
								modificationvalue1 = new BigDecimal(modificationvalue.trim());
								System.out.println("The number as BigDecimal modificationvalue: " + modificationvalue);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// writtenoffflag


						String writtenoffflag = item.get(51);
						BigDecimal writtenoffflag1 = null;

						// Check for null or empty before attempting conversion
						if (writtenoffflag != null && !writtenoffflag.trim().isEmpty()) {
							try {
								writtenoffflag1 = new BigDecimal(writtenoffflag.trim());
								System.out.println("The number as BigDecimal writtenoffflag: " + writtenoffflag);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
							// writtenoffvalue



						String writtenoffvalue = item.get(52);
						BigDecimal writtenoffvalue1 = null;

						// Check for null or empty before attempting conversion
						if (writtenoffvalue != null && !writtenoffvalue.trim().isEmpty()) {
							try {
								writtenoffvalue1 = new BigDecimal(writtenoffvalue.trim());
								System.out.println("The number as BigDecimal writtenoffvalue: " + writtenoffvalue);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
							// infoflag



						String infoflag = item.get(53);
						BigDecimal infoflag1 = null;

						// Check for null or empty before attempting conversion
						if (infoflag != null && !infoflag.trim().isEmpty()) {
							try {
								infoflag1 = new BigDecimal(infoflag.trim());
								System.out.println("The number as BigDecimal infoflag: " + infoflag);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}
						// isindividualflag




						String isindividualflag = item.get(55);
						BigDecimal isindividualflag1 = null;

						// Check for null or empty before attempting conversion
						if (isindividualflag != null && !isindividualflag.trim().isEmpty()) {
							try {
								isindividualflag1 = new BigDecimal(isindividualflag.trim());
								System.out.println("The number as BigDecimal isindividualflag: " + isindividualflag);
							} catch (NumberFormatException e) {
								System.err.println("The string does not contain a parsable number.");
							}
						} else {
							System.err.println("Transaction amount is null or empty.");
						}

						
						// total_rwa

					String total_rwa = item.get(64);
					BigDecimal total_rwa1 = null;

					// Check for null or empty before attempting conversion
					if (total_rwa != null && !total_rwa.trim().isEmpty()) {
						try {
							total_rwa1 = new BigDecimal(total_rwa.trim());
							System.out.println("The number as BigDecimal total_rwa: " + total_rwa);
						} catch (NumberFormatException e) {
							System.err.println("The string does not contain a parsable number.");
						}
					} else {
						System.err.println("Transaction amount is null or empty.");
					}


						
						/* date formate */
				        String datePattern = "MM/dd/yyyy";  // Adjust this pattern based on your actual date format

				        // Create a SimpleDateFormat object for parsing
				        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
				        String report_date = item.get(17);
				        System.out.println("The number as BigDecimal is:report_date " + report_date);
				        Date reportDate1 = dateFormat.parse(report_date);
				        System.out.println("The number as BigDecimal reportDate1 " + reportDate1);
				        String maturitydate = item.get(18);
				        Date maturitydate1 = dateFormat.parse(maturitydate);
				        System.out.println("The number as BigDecimal maturitydate1 " + maturitydate1);
						// Your existing code
						
						String facilityid = item.get(0);
						String customerid = item.get(1);
						String cust_name = item.get(2);
						String branch_name = item.get(3);
						String portfoliotype = item.get(4);
						String portfolioname = item.get(5);
						String subportfolioname = item.get(6);
						String productname = item.get(7);
						String rating = item.get(8);
						String currency = item.get(10);
						String interestaccrued = item.get(16);
						String collateraltype = item.get(21);
						String weighted_pd = item.get(26);
						String stage = item.get(30);
						String stagereason = item.get(31);
						System.out.println("stage " + stage);
						System.out.println("stagereason " + stagereason);
						String deferral = item.get(44); 
						String country = item.get(54); 
						System.out.println("country " + country); 
						String asset_class = item.get(56); 
						String transfer_stage = item.get(57); 
						String brf_1_classification = item.get(58);
						String brf_107 = item.get(59);
						String brf_106 = item.get(60);
						String basel_2_category = item.get(61);
						String provision_coverage = item.get(62);
						String mgmtoverlay = item.get(63);
						
						PO.setFacilityid(facilityid);
						PO.setCustomerid(customerid);
						PO.setCust_name(cust_name);
						PO.setBranch_name(branch_name);
						PO.setPortfoliotype(portfoliotype);
						PO.setPortfolioname(portfolioname);
						PO.setSubportfolioname(subportfolioname);
						PO.setProductname(productname);
						PO.setRating(rating);
						PO.setDpdbucket(dpdbucket1);
						PO.setCurrency(currency);
						PO.setLimit(limit1);
						PO.setDrawnamount(drawnamount1);
						PO.setUndrawnamount(undrawnamount1);
						PO.setCcf(ccf1);
						PO.setEad(ead1);
						PO.setInterestaccrued(interestaccrued);
						PO.setReport_date(reportDate1);
						PO.setMaturitydate(maturitydate1);
						PO.setPaymentfrequency(paymentfrequency1);
						PO.setEir(eir1);
						PO.setCollateraltype(collateraltype);
						PO.setCollateralvalue(collateralvalue1);
						PO.setPositivepd(positivepd1);
						PO.setNegativepd(negativepd1);
						PO.setWeighted_pd(weighted_pd);
						PO.setUnsecuredlgdrate(unsecuredlgdrate1);
						PO.setLgdrate(lgdrate1);
						PO.setPastduedays(pastduedays1);
						PO.setStage(stage);
						PO.setStagereason(stagereason);
						PO.setBasepd(basepd1);
						PO.setLecl_base(lecl_base1);
						PO.setLecl_positive(lecl_positive1);
						PO.setLecl_negative(lecl_negative1);
						PO.setLife_time_weigthed(life_time_weigthed1);
						PO.setEcl12m_base(ecl12m_base1);
						PO.setEcl12m_negative(ecl12m_negative1);
						PO.setEcl12m_positive(ecl12m_positive1);
						PO.setA12monthweighted(a12monthweighted1);
						PO.setIfrs9_ecl_number_base(ifrs9_ecl_number_base1);
						PO.setIfrs9_ecl_number_negative(ifrs9_ecl_number_negative1);
						PO.setIfrs9_ecl_number_positive(ifrs9_ecl_number_positive1);
						PO.setFinalweightedecl(finalweightedecl1);
						PO.setDeferral(deferral);
						PO.setEcl_incul_deferral(ecl_incul_deferral1);
						PO.setEcl_mgmt_overlay(ecl_mgmt_overlay1);
						PO.setSpecific_provision(specific_provision1);
						PO.setInterest_suspense(interest_suspense1);
						PO.setModificationflag(modificationflag1);
						PO.setModificationvalue(modificationvalue1);
						PO.setWrittenoffflag(writtenoffflag1);
						PO.setWrittenoffvalue(writtenoffvalue1);
						PO.setInfoflag(infoflag1);
						PO.setIsindividualflag(isindividualflag1);
                        PO.setAsset_class(asset_class);
						PO.setTransfer_stage(transfer_stage);
						PO.setBrf_1_classification(brf_1_classification);
						PO.setBrf_107(brf_107);
						PO.setBrf_106(brf_106);
						PO.setBasel_2_category(basel_2_category);
						PO.setProvision_coverage(provision_coverage);
						PO.setMgmtoverlay(mgmtoverlay);
						PO.setTotal_rwa(total_rwa1);

						Ecl_upload_Repo.save(PO);
						msg = "Excel Data Uploaded Successfully";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				msg = "File has not been successfully uploaded";
			}
		}
		return msg;

	}

	private static String formatLakh(double d) {
		String s = String.format(Locale.UK, "%1.2f", Math.abs(d));
		s = s.replaceAll("(.+)(...\\...)", "$1,$2");
		while (s.matches("\\d{3,},.+")) {
			s = s.replaceAll("(\\d+)(\\d{2},.+)", "$1,$2");
		}
		return d < 0 ? ("-" + s) : s;
	}

	private static boolean isRowEmpty(Row row) {
		boolean isEmpty = true;
		DataFormatter dataFormatter = new DataFormatter();

		if (row != null) {
			for (Cell cell : row) {
				if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
					isEmpty = false;
					break;
				}
			}
		}
		return isEmpty;
	}
}