SET DATABASE SQL SYNTAX ORA TRUE;

  create schema rates;
  
  CREATE TABLE "PW_MAILING_GROUP" 
   (	"PW_MAILING_GROUP_SEQ_NO" NUMBER, 
	"CUSTOMER_GROUP_ID" VARCHAR2(25), 
	"DESCRIPTION" VARCHAR2(50), 
	"ACTIVITY_DATE" DATE DEFAULT SYSDATE, 
	"OPEN_DATE" DATE DEFAULT SYSDATE, 
	"OPEN_USER_ID" NUMBER, 
	"CLOSE_DATE" DATE DEFAULT NULL, 
	"CLOSE_USER_ID" NUMBER,  
	"PREPARER_PERMIT_NUMBER" VARCHAR2(40), 
	"PREPARER_PERMIT_TYPE" VARCHAR2(2), 
	"POSTOFFICE_OF_MAILING_ZIP" VARCHAR2(5), 
	"FINANCE_NO" VARCHAR2(6) NOT NULL , 
	"ORIGIN" VARCHAR2(6), 
	"PAPER_ELECTRONIC_IND" VARCHAR2(1) DEFAULT 'P', 
	"PREPARER_PERMIT_SEQ_NO" NUMBER(12,0), 
	"MAILING_FACILITY" VARCHAR2(30), 
	"RBV_IND" VARCHAR2(1) DEFAULT 'N', 
	"PRESENTATION_CATEGORY" VARCHAR2(1), 
	"COMPLETE_DATE" DATE, 
	"ACCEPTANCE_FINANCE_NO" VARCHAR2(6), 
	"ONE_PASS_INDICATOR" VARCHAR2(1), 
	"LAST_GROUP_UPDATE_DATE" DATE DEFAULT SYSDATE, 
	"SUBMITTER_CRID" VARCHAR2(10), 
	"MULTI_PERMIT_IND" VARCHAR2(1), 
	"COPAL_IND" VARCHAR2(1), 
	"CANCEL_JOB_USE_IND" VARCHAR2(1), 
	"CANCEL_CRID" NUMBER, 
	"CANCEL_DATE" DATE, 
	"CANCELLATION_REASON" VARCHAR2(4000), 
	"CANCEL_OTH_RSN_COMMENT" VARCHAR2(2000), 
	"CANCEL_USER_ID" NUMBER(15,0), 
	"SEAMLESS_IND" VARCHAR2(1), 
	"PROVIDER_CODE" VARCHAR2(4), 
	"MA_CRID" NUMBER(15,0), 
	"DELETED_CONTAINERS_IND" VARCHAR2(1), 
	"E_INDUCTION" VARCHAR2(1), 
	 CONSTRAINT "PW_MAILING_GROUP_PK" PRIMARY KEY ("PW_MAILING_GROUP_SEQ_NO"), 
	 CONSTRAINT "PW_MAILING_GRP_COPAL_CONS" CHECK (copal_ind in ('O','L', null))  
   ) ; 


  CREATE TABLE "PW_WIZARD_STATEMENT_SUM" 
   (	"POSTAGE_STATEMENT_SEQ_NO" NUMBER NOT NULL , 
	"PROVIDER_CODE" VARCHAR2(4), 
	"STAGE" VARCHAR2(4) NOT NULL , 
	"PERMIT_PUB_NO" NUMBER(8,0), 
	"PERMIT_PUB_TYPE" VARCHAR2(2), 
	"FINANCE_NO" VARCHAR2(6) NOT NULL , 
	"POSTG_PAYMENT_METHOD" VARCHAR2(1), 
	"RATE_TYPE" VARCHAR2(2), 
	"PROCESS_CAT" VARCHAR2(2), 
	"CLASS" VARCHAR2(1), 
	"RECIPIENT_TYPE" VARCHAR2(1), 
	"FORM_NUMBER" VARCHAR2(20), 
	"FORM_TYPE" VARCHAR2(3), 
	"UNIT_WEIGHT" NUMBER, 
	"SPECIAL_SERVICE_FEE" NUMBER, 
	"TOTAL_PIECES" NUMBER, 
	"TOTAL_COPIES" NUMBER, 
	"TOTAL_WEIGHT" NUMBER, 
	"USPS_ADDITIONAL_POSTAGE" NUMBER, 
	"USPS_TOTAL_POSTAGE" NUMBER, 
	"USPS_TOTAL_ADJUSTED_POSTAGE" NUMBER, 
	"USPS_VERIFIED_DATE" DATE, 
	"USPS_NOTIFIED_DATE" DATE, 
	"USPS_BY_INITIAL" VARCHAR2(3 CHAR), 
	"USPS_VERF_PERFORMED" VARCHAR2(2), 
	"USPS_ADJUSTED_ENTRY" VARCHAR2(1), 
	"USPS_REASON" VARCHAR2(255), 
	"USPS_CONTACT_NAME" VARCHAR2(40), 
	"USPS_EMP_NAME" VARCHAR2(40), 
	"USPS_OPTIONAL_PROCEDURE" VARCHAR2(1), 
	"USPS_REPORT_CODE" VARCHAR2(20), 
	"AFFIXED_PIECES" NUMBER, 
	"AFFIXED_POSTAGE" NUMBER, 
	"RIDE_ALONG_IND" VARCHAR2(1), 
	"RIDE_ALONG_WEIGHT" NUMBER, 
	"TOTAL_CONTAINERS" NUMBER, 
	"MAILING_DATE" DATE, 
	"USER_STATEMENT_SEQ_NO" VARCHAR2(30), 
	"ENCLOSING_CLASS" VARCHAR2(2), 
	"SACKING_BASIS" VARCHAR2(1), 
	"PACKAGING_BASIS" VARCHAR2(1), 
	"POST_OFFICE_ZIP" VARCHAR2(5), 
	"AUTO_ADD_MATCH_DATE" DATE, 
	"CR_ADD_MATCH_DATE" DATE, 
	"CR_SEQUENCING_DATE" DATE, 
	"SIGNER_NAME" VARCHAR2(101), 
	"SIGNER_PHONE" VARCHAR2(10), 
	"ACTIVITY_DATE" DATE NOT NULL , 
	"ORIGIN" VARCHAR2(6) NOT NULL , 
	"ORIGIN_VERSION" VARCHAR2(10), 
	"SUBMITTER_IP" VARCHAR2(40), 
	"VENDOR_NAME" VARCHAR2(20), 
	"VENDOR_VERSION" VARCHAR2(10), 
	"SUBMIT_DATE" DATE, 
	"SUBMIT_USER_ID" NUMBER, 
	"CANCEL_DATE" DATE, 
	"CANCEL_USER_ID" NUMBER, 
	"REVERSE_DATE" DATE, 
	"REVERSE_USER_ID" NUMBER, 
	"FISCAL_YEAR" NUMBER, 
	"QUARTER" NUMBER, 
	"OVER_10" VARCHAR2(1), 
	"ISSUE_DATE" DATE, 
	"EDITION_CODE" VARCHAR2(20), 
	"ISSUE_FREQUENCY" VARCHAR2(20), 
	"ADVERTISING_PERCENT" NUMBER, 
	"REF_NO" NUMBER(2,0) DEFAULT 0, 
	"CALCULATED_POSTAGE" NUMBER, 
	"CAPS_REF_NO" VARCHAR2(40), 
	"REGISTER_IND" VARCHAR2(1) DEFAULT '0', 
	"PPI_INDICATOR" VARCHAR2(1) DEFAULT '0', 
	"COMPANY_IMPRINT" VARCHAR2(1) DEFAULT '0', 
	"CONSOLIDATED_MAILING" VARCHAR2(1) DEFAULT '0', 
	"PERIODICAL_PENDING" VARCHAR2(1) DEFAULT '0', 
	"EXPERIMENTAL" VARCHAR2(1) DEFAULT '0', 
	"MAILING_DATE_2" DATE, 
	"USER_STATEMENT_SEQ_NO_2" VARCHAR2(30), 
	"PERIODICAL_STATEMENT_TYPE" VARCHAR2(1) DEFAULT NULL, 
	"ISSUE_DATE_2" DATE, 
	"ISSUES_IN_MONTH" NUMBER DEFAULT NULL, 
	"SHEET_WEIGHT" NUMBER DEFAULT NULL, 
	"AFFIXED_METHOD" VARCHAR2(1) DEFAULT NULL, 
	"AGENCY_CODE" VARCHAR2(3), 
	"AGENCY_COST_CODE" VARCHAR2(6), 
	"USPS_PRESORT_RECEIVED" VARCHAR2(1), 
	"USPS_PRESORT_ERRORS" NUMBER, 
	"USPS_VERF_ARC" VARCHAR2(1), 
	"USPS_VERF_COST" NUMBER, 
	"PW_MAILING_GROUP_SEQ_NO" NUMBER NOT NULL , 
	"POSTAGE_STATEMENT_ID" NUMBER, 
	"REPOSITIONABLE_NOTES" NUMBER DEFAULT 0, 
	"RIDE_ALONG_PIECES" NUMBER DEFAULT 0, 
	"USPS_MERLIN_POSTNET_ERRORS" NUMBER DEFAULT 0, 
	"USPS_MERLIN_POSTNET_POSTAGE" NUMBER DEFAULT 0, 
	"USPS_MERLIN_PRESORT_ERRORS" NUMBER DEFAULT 0, 
	"USPS_MERLIN_PRESORT_POSTAGE" NUMBER DEFAULT 0, 
	"USPS_MERLIN_SHORT_ERRORS" NUMBER DEFAULT 0, 
	"USPS_MERLIN_SHORT_POSTAGE" NUMBER DEFAULT 0, 
	"PAPER_ELECTRONIC_IND" VARCHAR2(1) DEFAULT 'P', 
	"TRAN_SEQ_NO" NUMBER(15,0), 
	"TRANSPORT_TYPE" VARCHAR2(1), 
	"SHIPMENT_TYPE" VARCHAR2(1), 
	"ICM_DISCOUNT_PERCENT" NUMBER, 
	"ICM_DISCOUNT_TYPE" VARCHAR2(1), 
	"AFFIXED_POUND_POSTAGE" NUMBER, 
	"AFFIXED_PIECE_POSTAGE" NUMBER, 
	"INTERNATIONAL_IND" VARCHAR2(1) DEFAULT '0', 
	"USPS_PENDING_POSTAGE" NUMBER(11,2), 
	"CPP_IND" VARCHAR2(1) DEFAULT '0', 
	"USPS_COMMENT" VARCHAR2(255), 
	"USPS_VERF_PIECES_REWORKED" NUMBER DEFAULT 0, 
	"USPS_PRESORT_POSTAGE" NUMBER DEFAULT 0, 
	"USPS_MERLIN_RECEIVED" VARCHAR2(1), 
	"PRESORT_IND" VARCHAR2(1) DEFAULT '0', 
	"OUT_RIDE_ALONG_WEIGHT" NUMBER, 
	"IN_RIDE_ALONG_WEIGHT" NUMBER, 
	"JOB_ID" VARCHAR2(25), 
	"PROCESSING_DATE" DATE, 
	"PROCESSING_USER_ID" NUMBER, 
	"PENDING_STATEMENT_TYPE" VARCHAR2(2), 
	"ICM_ACCT_NBR" NUMBER, 
	"ELECTRONIC_DEL_CON" VARCHAR2(1), 
	"GDC_CAT_CODE" VARCHAR2(1), 
	"GDC_ADDR_ACCUR_RATE" NUMBER(5,2), 
	"GDC_TOT_TARE_WT" NUMBER(13,4), 
	"GDC_MAILG_PREPN_OPT" VARCHAR2(3), 
	"GDC_BASE_ALLOW_EXCESS_WT" NUMBER(13,4), 
	"GDC_EXCESS_WT_PSTG_AMT" NUMBER(10,2), 
	"GDC_EXCESS_WT_RATE" NUMBER, 
	"VOLUME_DISCOUNT_PERCENT" NUMBER, 
	"VOLUME_DISCOUNT_AMOUNT" NUMBER, 
	"SURCHARGE" NUMBER, 
	"ICM_DISCOUNT_AMOUNT" NUMBER, 
	"COMBINED_MAILING" VARCHAR2(1) DEFAULT '0', 
	"PCM_IND" VARCHAR2(1) DEFAULT '0', 
	"CONS_POSTAGE_STATEMENT_ID" NUMBER, 
	"ENTRY_FACILITY_TYPE" VARCHAR2(1), 
	"ENTRY_ZIP" VARCHAR2(6), 
	"MAILER_MAILING_DATE" DATE, 
	"MAILER_MAILING_DATE_2" DATE, 
	"USPS_IV_TYPE" VARCHAR2(1), 
	"USPS_IV_RESULTS" VARCHAR2(1), 
	"USPS_IV_FAILURE" VARCHAR2(2), 
	"USPS_IV_EMP_NAME" VARCHAR2(50), 
	"USPS_IV_COMMENTS" VARCHAR2(400), 
	"USPS_IV_MERLIN_ID" VARCHAR2(7), 
	"DAL_PIECES" NUMBER(10,0), 
	"VOLUME_NO" VARCHAR2(5), 
	"ISSUE_NO" VARCHAR2(6), 
	"COMBINED_MAILING_ID" NUMBER, 
	"FACILITY_ID" NUMBER, 
	"VERIF_DATE" DATE, 
	"VERIF_SEQ_NO" NUMBER, 
	"RBV_VERIF_REQUIRED_IND" VARCHAR2(1), 
	"RBV_MANUAL_OVERRIDE_IND" VARCHAR2(1), 
	"GOTO_PSW_STEP" VARCHAR2(20), 
	"RBV_SAMPLE_SIZE" NUMBER, 
	"RBV_CLEARANCE_TIME" DATE, 
	"RBV_RSV_LARGE_INCREMENT" NUMBER, 
	"RBV_AUTOMATION_RATE_IND" VARCHAR2(1), 
	"MASTER_STATEMENT_SEQ_NO" NUMBER, 
	"RECORD_TYPE" VARCHAR2(1) DEFAULT 'S', 
	"TOTAL_MAILER_DECL_PIECES" NUMBER, 
	"TOTAL_MAILER_DECL_WEIGHT" NUMBER, 
	"RBV_LOCK_USER_SEQ_NO" NUMBER, 
	"RBV_LOCK_START_TIME" DATE, 
	"RBV_WINDOW_LETTER_IND" VARCHAR2(1), 
	"RBV_PS_START_TIME" DATE, 
	"RBV_PLP" NUMBER, 
	"RBV_MSRN" NUMBER, 
	"RBV_PS_START_EMP_INIT" VARCHAR2(10), 
	"RBV_PREV_ASSESSED_IND" VARCHAR2(1), 
	"RBV_PROCESSING_TIME" DATE, 
	"TOTAL_USPS_DETR_PIECES" NUMBER, 
	"WGH_ERR_OVER_THRSHLD_IND" VARCHAR2(1), 
	"TOTAL_USPS_DETR_WEIGHT" NUMBER, 
	"DIMENSIONAL_WEIGHT" NUMBER, 
	"ICNTY_PALLET_CNT" NUMBER, 
	"ICNTY_SACK_CNT" NUMBER, 
	"ICNTY_TRAY_CNT" NUMBER, 
	"OCNTY_PALLET_CNT" NUMBER, 
	"OCNTY_SACK_CNT" NUMBER, 
	"OCNTY_TRAY_CNT" NUMBER, 
	"CONT_CHRG_APPLIES_IND" VARCHAR2(1), 
	"LINKED_TRAN_NBR" VARCHAR2(15), 
	"LINKED_MAILING_DATE" DATE, 
	"LINKED_TOTAL_PIECES" NUMBER, 
	"LINKED_TOTAL_POSTAGE" NUMBER, 
	"TOTAL_CONT_TO_CHRG" NUMBER, 
	"TOTAL_BUNDLE_TO_CHRG" NUMBER, 
	"FOR_CONSOLIDATION" VARCHAR2(1), 
	"CONTAINER_ONLY_IND" VARCHAR2(1), 
	"PERMIT_REPLY_MAIL_IND" VARCHAR2(1), 
	"PCP_SELECTION" VARCHAR2(1), 
	"STANDALONE_BUNDLE_IND" VARCHAR2(1), 
	"EST_PIECES_PER_BUNDLE" NUMBER, 
	"SINGLE_PIECE_POSTAGE" NUMBER, 
	"USPS_DETERMINED_UNIT_WEIGHT" NUMBER, 
	"DSP_CONTAINER_LINES_IND" VARCHAR2(1), 
	"SIGNER_PHONE_EXT" VARCHAR2(10), 
	"NONPRFT_USPS_TOTAL_POSTAGE" NUMBER, 
	"MOVE_UPDATE_METHOD_IND" VARCHAR2(10), 
	"PRICE_TYPE" VARCHAR2(100), 
	"LCD_CLAIMED_IND" VARCHAR2(1), 
	"CPP_PENDING_PAYMENT_DATE" DATE, 
	"TEMP_POSTAGE_STATEMENT_SEQ_NO" NUMBER, 
	"ORIG_POSTAGE_STATEMENT_SEQ_NO" NUMBER, 
	"UNSENT_PIECES" NUMBER, 
	"UNSENT_POSTAGE_REDUCTION" NUMBER, 
	"CCC_PRODUCT_SEQ_NO" NUMBER, 
	"CCC_RATE_SCHEDULE" VARCHAR2(1), 
	"CCC_DISCOUNT_TOTAL" NUMBER, 
	"ALT_ADDRESS_IND" VARCHAR2(1), 
	"REVERSAL_REENTRY_IND" VARCHAR2(1), 
	"REVERSAL_REASON_IND" VARCHAR2(1), 
	"REVERSAL_TRAN_NBR" VARCHAR2(17), 
	"SPL_PSTG_PYMT_AGMT_IND" VARCHAR2(1), 
	"EEL_PFC" VARCHAR2(28) DEFAULT NULL, 
	"TOT_PIECES_SHRTG_SPOIL" NUMBER(12,0), 
	"TOT_POSTG_SHRTG_SPOIL" NUMBER(15,3), 
	"SYSTEM_JOB_ARRIVAL" TIMESTAMP (6) WITH TIME ZONE, 
	"USER_JOB_ARRIVAL" TIMESTAMP (6) WITH TIME ZONE, 
	"JOB_ARRIVAL_ADJ_CODE" VARCHAR2(4), 
	"JOB_ARRIVAL_OTHER_COMMENT" VARCHAR2(50), 
	"JOB_ARRIVAL_USER_SEQ_NO" NUMBER, 
	"PS_MAILER_ID" VARCHAR2(9), 
	"PS_MAILING_ID" VARCHAR2(9), 
	"PS_HIGHEST_PIECE_ID" VARCHAR2(9), 
	"PS_FULL_SERVICE_IND" VARCHAR2(1), 
	"MTE_COUNT" NUMBER, 
	"FREEZE_IND" VARCHAR2(1), 
	"FREEZE_REASON" VARCHAR2(10), 
	"NBR_ADDR_SUPP_FOR_INCNTY" NUMBER, 
	"NBR_ADDR_SUPP_FOR_OUTCNTY" NUMBER, 
	"ADDR_SUPP_IND" VARCHAR2(1), 
	"AUTO_RATE_BARCODE_TYPE" VARCHAR2(1), 
	"SIMP_ADD_DSF_DATE" DATE, 
	"ADJ_HARDCOPY_PS" VARCHAR2(1), 
	"CONT_MAILER_IND" VARCHAR2(1), 
	"CERTIFY_IND" VARCHAR2(1), 
	"MAILER_NOTIFY_DATE" DATE, 
	"CONTACT_NAME" VARCHAR2(100), 
	"CONTACTED_BY_NAME" VARCHAR2(100), 
	"EMAIL_USER" VARCHAR2(1000), 
	"CANCELLATION_REASON" VARCHAR2(2000), 
	"EMAIL_IND" VARCHAR2(1), 
	"HC_POSTAGE_STATEMENT_SEQ_NO" NUMBER, 
	"TEMP_USPS_PENDING_POSTAGE" NUMBER(11,2), 
	"ENTRY_DISCOUNT_IND" VARCHAR2(1), 
	"NO_PS_8125_IND" VARCHAR2(1), 
	"LATE_STMT_REASON_CODE" VARCHAR2(2), 
	"LATE_STMT_REASON_COMMENT" VARCHAR2(255), 
	"LATE_STMT_REASON_TICKET" VARCHAR2(25), 
	"USPS_CONTACT_PHONE" VARCHAR2(14), 
	"CM_IN_PROCESS_OVER" VARCHAR2(2), 
	"INCLUDED_OTH_DOCN" VARCHAR2(1), 
	"IN_PROCESS_IND" VARCHAR2(1), 
	"IN_PROCESS_DATE" DATE, 
	"RBV_FACILITY_TYPE" VARCHAR2(10), 
	"MPU_FLAT_TYPE" VARCHAR2(1), 
	"CPT_FLAT_TYPE" VARCHAR2(1), 
	"MPU_PARCEL_TYPE" VARCHAR2(1), 
	"CPT_PARCEL_TYPE" VARCHAR2(1), 
	"CONTENT_MAIL" VARCHAR2(2), 
	"USPS_PRICE_INCENT_TYPE" VARCHAR2(30), 
	"FS_HELP_DESK_TICKET" VARCHAR2(25), 
	"FULL_SERVICE_REASON" VARCHAR2(4000), 
	"FULL_SERVICE_COMMENT" VARCHAR2(4000), 
	"MAIL_PIECE_REPLY_IND" VARCHAR2(1), 
	"MAIL_NOT_FCM_IND" VARCHAR2(1), 
	"MAIL_DVD_CD_IND" VARCHAR2(1), 
	"HOLD_FOR_PICKUP_PIECES" NUMBER, 
	"OPEN_DIST_IND" VARCHAR2(1), 
	"HOLD_FOR_PICKUP_IND" VARCHAR2(1), 
	"PM_RRB_IND" VARCHAR2(1), 
	"CERTIFY_CLERK_IND" VARCHAR2(1), 
	"CANCEL_OTH_RSN_COMMENT" VARCHAR2(4000), 
	"CANCELLATION_SOURCE" VARCHAR2(100), 
	"MAIL_PROD_SAMPLE_IND" VARCHAR2(1), 
	"DELIV_STAT_FILE_DATE" DATE, 
	"RECALCULATED_IND" VARCHAR2(1), 
	"SAT_ENTRY_MAIL_IND" CHAR(1), 
	"PLANNED_ENTRY_SAT_IND" CHAR(1), 
	"PW_MIXED_MAILING_SEQ_NO" NUMBER, 
	"DELIV_STAT_FILE_IND" VARCHAR2(1), 
	"NUM_OF_SMPLFD_ADDR_PIECES" NUMBER, 
	"MAILING_DATE_TIME" DATE, 
	"SBS_TYPE" VARCHAR2(6), 
	"INCENTIVE_AMOUNT" NUMBER, 
	"PS_NONLOCAL_HIGHEST_PIECE_ID" VARCHAR2(9), 
	"PS_LOWEST_PIECE_ID" VARCHAR2(9), 
	"PS_NONLOCAL_LOWEST_PIECE_ID" VARCHAR2(9), 
	"EDDM_IND" VARCHAR2(1), 
	"DSMS_IND" VARCHAR2(1), 
	"ESTIMATE_IND" VARCHAR2(1), 
	"UPD_COMPLETE_IND" VARCHAR2(2), 
	"AFFIXED_POSTAGE_SPOILED" NUMBER, 
	"PACT_ACT_IND" VARCHAR2(1), 
	"ELECTION_MAIL_IND" VARCHAR2(1), 
	"NSA_IND" VARCHAR2(1), 
	"NUM_MIT_PIECES" NUMBER, 
	"MARKETING_FULLFILL_IND" VARCHAR2(1), 
	"FEE_TYPE" VARCHAR2(20), 
	"FEE_AMOUNT" NUMBER, 
	"ACCOUNT_NUMBER" NUMBER(9,0), 
	"SEL_PROCESS_CAT" VARCHAR2(2), 
	"VAR_TRAN_IND" VARCHAR2(1), 
	"PO_FINANCE_NO" VARCHAR2(6), 
	"THRESHOLD_AMOUNT" NUMBER, 
	"AUTO_FINALIZE_IND" VARCHAR2(1), 
	"NUM_OF_CLIENTS" NUMBER, 
	"ELECTRONIC_SIGN_CON" VARCHAR2(1), 
	"REQ_PS8017_PS8125_IND" VARCHAR2(1), 
	"GXG_ENVELOPE_NUMBER" NUMBER, 
	"REQ_PS3811_IND" VARCHAR2(1), 
	"PO_COST_CENTER" VARCHAR2(10), 
	"OUNCES_IND" VARCHAR2(1), 
	"SS_IND" VARCHAR2(1), 
	"MA_CERT_IND" VARCHAR2(1), 
	"MA_CERT_REASON_ID" NUMBER, 
	"MA_CERT_COMMENTS" VARCHAR2(250), 
	"SUBMITTER_TRAN_NBR" VARCHAR2(32), 
	"SUBMITTER_ID" NUMBER, 
	"MAILER_JOB_DESC" VARCHAR2(20), 
	"TOTAL_INCENTIVE_PIECES" NUMBER, 
	"MI_HELP_DESK_TICKET" VARCHAR2(25), 
	"MI_REASON" VARCHAR2(50), 
	"MI_COMMENT" VARCHAR2(255), 
	"FULL_SERVICE_PCT" NUMBER(5,2), 
	"MOVE_UPDATE_DATE" DATE, 
	"MAIL_PIECE_COMPLETE_IND" VARCHAR2(1), 
	"TECH_CREDIT_AMOUNT" NUMBER(10,2), 
	"SAMPLE_PIECES" NUMBER, 
	"SAMPLE_PIECES_PCT" NUMBER, 
	"PH_CRID" NUMBER(15,0), 
	"CLK_INITS" VARCHAR2(3), 
	"VERIFICATION_DUE" VARCHAR2(200), 
	"OFFICIAL_ELECTION_MAIL_IND" VARCHAR2(1), 
	"PSTG_AFFIXED_TO_STMT_IND" VARCHAR2(1), 
	"PARCEL_PROCESSING_BARCODE_TYPE" VARCHAR2(1), 
	 CONSTRAINT "PW_WIZARD_STATEMENT_SUM_PK" PRIMARY KEY ("POSTAGE_STATEMENT_SEQ_NO"), 
	 CONSTRAINT "MOVE_UPDATE_METHOD_CHK1" CHECK (MOVE_UPDATE_METHOD_IND IN ('ASE', 'NCOA', 'ACS', 'FAST', 'ALT', 'MULT', 'NCOP', 'OCACS', 'ADDR', 'ONCOA'))  , 
	 CONSTRAINT "PAPER_ELECT_CHECK" CHECK (PAPER_ELECTRONIC_IND IN ('P', 'E'))  , 
	 CONSTRAINT "PRICE_TYPE_CHK1" CHECK (PRICE_TYPE IN ('RETAIL', 'COMMERCIAL', 'COMMERCIALPLUS', 'FEE', 'PERIODICAL', 'COMMERCIALPLUSCUBIC', 'COMMERCIALPLUSENVELOPE'))  , 
	 CONSTRAINT "PS_FULL_SERVICE_IND_CHK1" CHECK (PS_FULL_SERVICE_IND IN ('Y', 'N', NULL))  , 
	 CONSTRAINT "T1_MOVE_UPDATE_METHOD_CHK1" CHECK (
      MOVE_UPDATE_METHOD_IND IN ('ASE', 'NCOA', 'ACS', 'FAST', 'ALT', 'MULT', 'NCOP', 'OCACS', 'ADDR', 'ONCOA')
    ) , 
	 CONSTRAINT "T1_PAPER_ELECT_CHECK" CHECK (
      PAPER_ELECTRONIC_IND IN ('P', 'E')
    ) , 
	 CONSTRAINT "T1_PRICE_TYPE_CHK1" CHECK (
      PRICE_TYPE IN ('RETAIL', 'COMMERCIAL', 'COMMERCIALPLUS', 'FEE', 'PERIODICAL', 'COMMERCIALPLUSCUBIC', 'COMMERCIALPLUSENVELOPE')
    ) , 
	 CONSTRAINT "T1_PS_FULL_SERVICE_IND_CHK1" CHECK (
      PS_FULL_SERVICE_IND IN ('Y', 'N', NULL)
    ) , 
	 CONSTRAINT "PW_WIZARD_STATEMENT_SUM_FK" FOREIGN KEY ("PW_MAILING_GROUP_SEQ_NO")
	  REFERENCES "PW_MAILING_GROUP" ("PW_MAILING_GROUP_SEQ_NO")  
   ); 
   

  CREATE TABLE "VIEW_3600_FIRST_CLASS" 
   (	SERVICE_ID NUMBER ,
		FORM_ID NUMBER ,
		DOM_RATE_ID NUMBER ,
		MAIL_TYPE VARCHAR2(2) NOT NULL,
		FORM_NAME VARCHAR2(5) NOT NULL,
		PRICE_TYPE VARCHAR2(100) ,
		PRODUCT_TYPE VARCHAR2(100) ,
		SERVICE_TYPE VARCHAR2(10) ,
		CLASS VARCHAR2(1) ,
		RATE_TYPE VARCHAR2(2) ,
		RATE_CATEGORY VARCHAR2(2) ,
		PROCESS_CATEGORY VARCHAR2(2) ,
		ZONE VARCHAR2(1) ,
		MPU_SURCHARGE VARCHAR2(1) ,
		SECTION VARCHAR2(2) NOT NULL,
		LINE_NUMBER INTEGER,
		BLOCK_NAME VARCHAR2(50) ,
		MIN_WEIGHT NUMBER ,
		MAX_WEIGHT NUMBER ,
		OUNCES NUMBER ,
		PIECE_RATE NUMBER ,
		FIXED_RATE_IND VARCHAR2(1) ,
		WEIGHT_BREAK_IND VARCHAR2(1) ,
		START_DATE DATE NOT NULL,
		END_DATE DATE ,
		POSTG_PAYMENT_METHOD VARCHAR2(1) ,
		SERVICE_DESCRIPTION VARCHAR2(50) ,
		SECTION_HEADER_LABEL VARCHAR2(50) ,
		SECTION_LABEL VARCHAR2(100) ,
		BLOCK_LABEL VARCHAR2(200) ,
		LINE_LABEL VARCHAR2(100) ,
		PIECE_VIP VARCHAR2(10) ,
		CREATION_DATE DATE ,
		LAST_MOD_DATE DATE ,
		FULL_SERVICE_IND VARCHAR2(1) ,
		AIC VARCHAR2(10) ,
		CLASS_CODE NUMBER(2) ,
		SUB_CLASS_CODE NUMBER(4) ,
		INCLUDE_TOTALS VARCHAR2(1) ,
		FEE_TYPE_CODE VARCHAR2(2) ,
		CPT_INCENT_TYPE VARCHAR2(2) ,
		OLD_LINE_NUMBER NUMBER ,
		OLD_SECTION VARCHAR2(1) ,
		PRCL_BARCODE_RATE_IND VARCHAR2(1) ,
		NSA_IND VARCHAR2(1) ,
		CONTENT_OF_MAIL VARCHAR2(2) ,
		ELECTION_MAIL_IND VARCHAR2(1) ,
		AUTOMATION VARCHAR2(1) ,
		SINGLE_PIECE_IND VARCHAR2(1) ,
		MACHINABLE VARCHAR2(1) ,
		FS_IMD_IND VARCHAR2(1) ,
		IMSB_REQUIRED_IND VARCHAR2(1) ,
		DISCOUNT_TYPE VARCHAR2(1) ,
		RESIDUAL_PREP_IND VARCHAR2(1) ,
		PRODUCT_ID NUMBER NOT NULL,
		RATE_CASE_ID NUMBER NOT NULL,
		PS_LINE_ID NUMBER NOT NULL,
		RATE_SEQ_ID NUMBER NOT NULL,
		MAPPING_ROWID VARCHAR2(200) ,
		LINE_ROWID VARCHAR2(200) ,
		RATE_CASE_ROWID VARCHAR2(200) ,
		PRODUCT_ROWID VARCHAR2(200) 
   );
   
 CREATE TABLE PW_WIZARD_LINE 
(
  LINE_SEQ_NO NUMBER NOT NULL 
, POSTAGE_STATEMENT_SEQ_NO NUMBER NOT NULL 
, ACTIVITY_DATE DATE NOT NULL 
, PRCL_BARCODE_RATE_IND VARCHAR2(1) 
, RATE_CATEGORY VARCHAR2(10) 
, MPU_SURCHARGE VARCHAR2(1) 
, PRESORT_DISCOUNT VARCHAR2(1) 
, ENTRY_DISCOUNT VARCHAR2(1) 
, ZONE VARCHAR2(2) 
, CLASS VARCHAR2(1) 
, MACHINABLE VARCHAR2(1) 
, IN_OUT_COUNTY_IND VARCHAR2(1) 
, DISCOUNT_TYPE VARCHAR2(1) 
, HEAVY_LETTER VARCHAR2(1) 
, SECTION VARCHAR2(1) 
, LINE_NUMBER VARCHAR2(3) 
, LINE_LABEL VARCHAR2(80) 
, PIECE_RATE NUMBER 
, POUND_RATE NUMBER 
, PIECE_POSTAGE NUMBER 
, POUND_POSTAGE NUMBER 
, SUB_REQ_COPIES NUMBER 
, NON_COPIES NUMBER 
, ADVERTISING_POUNDS NUMBER 
, PIECE_VIP VARCHAR2(10) 
, POUND_VIP VARCHAR2(10) 
, RATE_GROUP VARCHAR2(1) 
, PIECES NUMBER 
, COPIES NUMBER 
, POUNDS NUMBER 
, PARCEL_ENTRY VARCHAR2(50) 
, EXPERIMENTAL VARCHAR2(1) DEFAULT '0' 
, WEIGHT_BREAK_IND VARCHAR2(1) DEFAULT 'N' 
, PROCESS_CAT VARCHAR2(2) 
, FOREIGN_COPY_WEIGHT NUMBER 
, UNIT_WEIGHT NUMBER DEFAULT 0 
, FLAT_RATE_INDICATOR VARCHAR2(1) 
, CONTAINER_TYPE VARCHAR2(10) 
, CONT_CHRG_APPLIES_IND VARCHAR2(1) 
, RATE_TYPE VARCHAR2(2) 
, PACKAGE_LEVEL VARCHAR2(2) 
, CONTAINER_LEVEL VARCHAR2(2) 
, ENTRY_FACILITY_TYPE VARCHAR2(1) 
, NON_ADVERTISING_POUNDS NUMBER 
, CCC_DISCOUNT_TOTAL NUMBER 
, NONPRFT_PIECE_RATE NUMBER 
, NONPRFT_POUND_RATE NUMBER 
, NONPRFT_PIECE_POSTAGE NUMBER 
, NONPRFT_POUND_POSTAGE NUMBER 
, NONPRFT_PIECE_VIP VARCHAR2(10) 
, NONPRFT_POUND_VIP VARCHAR2(10) 
, TEMP_LINE_SEQ_NO NUMBER 
, TEMP_POSTAGE_STATEMENT_SEQ_NO NUMBER 
, NONPRFT_ORIG_LINE_SEQ_NO_LINK NUMBER 
, DELIVERY_TYPE VARCHAR2(1) 
, TIER VARCHAR2(3) 
, CCC_PRODUCT_SEQ_NO NUMBER 
, CCA_IND VARCHAR2(1) 
, PUBLISH_RATE NUMBER 
, DISC_RATE NUMBER 
, PRICE_TYPE VARCHAR2(100) 
, CPT_INCENT_TYPE VARCHAR2(2) 
, STD_PARCEL_TYPE VARCHAR2(11) 
, STD_FLAT_TYPE VARCHAR2(11) 
, HOLD_FOR_PICK_UP VARCHAR2(1) 
, NO_PCS_TO_HOLD NUMBER(15, 0) 
, SNGL_PC_DIM_PRICE NUMBER(15, 4) 
, SNGL_PC_DIM_BALLOON_PRICE NUMBER(15, 4) 
, INCENTIVE_AMOUNT NUMBER 
, DISCOUNT_AMOUNT NUMBER 
, FEE_AMOUNT NUMBER 
, FEE_TYPE VARCHAR2(100) 
, PMOD_IND VARCHAR2(1) 
, CONTAINER_IND VARCHAR2(2) 
, BOX VARCHAR2(1) 
, TOTAL_POSTAGE NUMBER 
, SUB_TOTAL_PSTG NUMBER 
, FEE_TOTAL NUMBER 
, CHARACTERISTIC VARCHAR2(8) 
, SIMPLIFIED_ADDR_IND VARCHAR2(1) 
, DISCT_TOTAL NUMBER 
, DISC_POUND_RATE NUMBER 
, PUBLISH_POUND_RATE NUMBER 
, IM_BARCODE_PCS NUMBER 
, PRODUCT_ID NUMBER 
, PS_LINE_ID NUMBER 
, INCENTIVE_CLAIMED VARCHAR2(100) 
, FULL_SERVICE_PIECES NUMBER 
, FULL_SERVICE_AMOUNT NUMBER 
);

CREATE SEQUENCE PW_WIZARD_LINE_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE RATES_LINE_ITEM_PROPERTIES (
	RATE_SEQ_ID NUMBER,
	JAVA_CLASS VARCHAR2(255),
	SURCHARGE_PRICE NUMBER
);

CREATE TABLE "RATES"."ALL_RATE_CASE_DATE_INFO" (
	"RATE_CASE_ID" NUMBER NOT NULL, 
	"FORM_TYPE" VARCHAR2(2) NOT NULL, 
	"START_DATE" DATE NOT NULL, 
	"END_DATE" DATE
);

insert into "RATES"."ALL_RATE_CASE_DATE_INFO"
(rate_case_id, form_type, start_date, end_date)
values
('207', 'FC', to_date('08-13-2014','MM-DD-YYYY'), null)
;

insert into "RATES"."ALL_RATE_CASE_DATE_INFO"
(rate_case_id, form_type, start_date, end_date)
values
('207', 'SM', to_date('08-13-2014','MM-DD-YYYY'), null)
;


create table PS_VALIDATION_TYPE (
	PS_VALIDATION_TYPE_ID number(10) not null primary key,
	PS_VALIDATION_CLASS_NAME varchar2(255) not null
);

create table PS_VALIDATION (
	PS_VALIDATION_ID number(10) not null primary key,
	PS_VALIDATION_TYPE_ID number(10) not null,
	EFFECTIVE_START_DATE date not null,
	EFFECTIVE_END_DATE date,
	constraint FK_PS_VALIDATION_TYPE
		foreign key (PS_VALIDATION_TYPE_ID)
		references PS_VALIDATION_TYPE(PS_VALIDATION_TYPE_ID)
);

create sequence PS_VALIDATION_SEQ start with 1;

CREATE TABLE "VIEW_3602_STANDARD" 
   ("RATE_CATEGORY" VARCHAR2(2) NOT NULL, 
	"PROCESS_CATEGORY" VARCHAR2(2) NOT NULL, 
	"RATE_TYPE" VARCHAR2(1) NOT NULL, 
	"DESTINATION_ENTRY" VARCHAR2(1), 
	"POSTG_PAYMENT_METHOD" VARCHAR2(1) NOT NULL, 
	"MPU_SURCHARGE" VARCHAR2(1) NOT NULL, 
	"PRCL_BARCODE_RATE_IND" VARCHAR2(1), 
	"HEAVY_LETTER" VARCHAR2(1), 
	"MIN_WEIGHT" NUMBER, 
	"MAX_WEIGHT" NUMBER(7,4), 
	"PIECE_RATE" NUMBER, 
	"POUND_RATE" NUMBER, 
	"START_DATE" DATE NOT NULL, 
	"END_DATE" DATE, 
	"SECTION" VARCHAR2(2) NOT NULL, 
	"LINE_LABEL" VARCHAR2(100), 
	"PIECE_VIP" VARCHAR2(10), 
	"POUND_VIP" VARCHAR2(10), 
	"LINE_NUMBER" NUMBER, 
	"SECTION_LABEL" VARCHAR2(100), 
	"BLOCK_LABEL" VARCHAR2(200), 
	"BLOCK_NAME" VARCHAR2(50), 
	"SERVICE_TYPE" VARCHAR2(100), 
	"SERVICE_CODE" VARCHAR2(100), 
	"CLASS" VARCHAR2(1) NOT NULL, 
	"FIXED_RATE_IND" VARCHAR2(1), 
	"ZONE" VARCHAR2(1), 
	"FORM_RATE_TYPE" VARCHAR2(1), 
	"RATE_GROUP" VARCHAR2(10), 
	"HEAVY" VARCHAR2(1), 
	"SERVICE_ID" NUMBER, 
	"HAS_POUND" VARCHAR2(1), 
	"FULL_SERVICE_IND" VARCHAR2(1), 
	"TAB_3602_SEQ" NUMBER, 
	"AIC" VARCHAR2(10), 
	"CLASS_CODE" NUMBER(2,0), 
	"SUB_CLASS_CODE" NUMBER(4,0), 
	"INCLUDE_TOTALS" VARCHAR2(1), 
	"STD_PARCEL_TYPE" VARCHAR2(11), 
	"OLD_LINE_NUMBER" NUMBER, 
	"OLD_SECTION" VARCHAR2(2), 
	"EDDM_IND" VARCHAR2(1), 
	"MARKETING_FULFILL_IND" VARCHAR2(20), 
	"SIMP_ADDR_IND" VARCHAR2(1), 
	"PRESORT_IND" VARCHAR2(1), 
	"AUTOMATION" VARCHAR2(1), 
	"MACHINABLE" VARCHAR2(1), 
	"CARRIER_ROUTE" VARCHAR2(1), 
	"FS_IMD_IND" VARCHAR2(1), 
	"DISCOUNT_TYPE" VARCHAR2(1), 
	"UNIT_CRITERIA" VARCHAR2(20), 
	"CONTAINER_LEVEL" VARCHAR2(2), 
	"VOLUME_MIN" NUMBER, 
	"VOLUME_MAX" NUMBER, 
	"IMSB_REQUIRED_IND" CHAR(1), 
	"PRODUCT_ID" NUMBER NOT NULL, 
	"RATE_CASE_ID" NUMBER NOT NULL, 
	"PS_LINE_ID" NUMBER NOT NULL, 
	"RATE_SEQ_ID" NUMBER NOT NULL
   );
   
CREATE SEQUENCE PW_WIZARD_SERVICE_SEQ START WITH 1 INCREMENT BY 1;
CREATE TABLE PW_WIZARD_SERVICE
(
  SERVICE_SEQ_NO            NUMBER,
  POSTAGE_STATEMENT_SEQ_NO  NUMBER,
  SERVICE_CODE              VARCHAR2(4 BYTE),
  TOTAL_PIECES              NUMBER,
  SECTION                   VARCHAR2(1 BYTE),
  LINE_NUMBER               VARCHAR2(3 BYTE),
  LINE_LABEL                VARCHAR2(80 BYTE),
  SERVICE_RATE              NUMBER,
  SERVICE_VIP               VARCHAR2(5 BYTE),
  SERVICE_POSTAGE           NUMBER,
  ACTIVITY_DATE             DATE                DEFAULT SYSDATE,
  INCENTIVE_AMOUNT          NUMBER,
  CCC_PRODUCT_SEQ_NO        NUMBER,
  SERVICE_SUB_CODE          VARCHAR2(3 BYTE),
  TOTAL_POSTAGE             NUMBER,
  INCENTIVE_CLAIMED         VARCHAR2(100 BYTE),
  TOTAL_POUNDS              NUMBER
);
