package com.example.payroll.service.impl;

import com.example.payroll.model.Sequence;
import com.example.payroll.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Created by yeo on 5/10/2017.
 */
@Service
public class SequenceServiceImpl implements SequenceService {

	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public Long getStaffNextSeq() {
		return getNextSequence("STAFF_ID_SEQ");
	}

	@Override
	public Long getJobNextSeq() {
		return getNextSequence("JOB_ID_SEQ");
	}

	@Override
	public Long getBranchNextSeq() {
		return getNextSequence("BRANCH_ID_SEQ");
	}

	@Override
	public Long getDeductionNextSeq() {
		return getNextSequence("DEDUCTION_ID_SEQ");
	}

	@Override
	public Long getPayslipNextSeq() {
		return getNextSequence("PAYSLIP_ID_SEQ");
	}

	@Override
	public Long getPayslipItemNextSeq() {
		return getNextSequence("PAYSLIP_ITEM_ID_SEQ");
	}

	private Long getNextSequence(String seqName) {
		// get sequence id
		Query query = new Query(Criteria.where("_id").is(seqName));

		// increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);

		// return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		Sequence sequence = mongoOperation.findAndModify(query, update, options, Sequence.class);

		return sequence.getSeq();
	}
}
