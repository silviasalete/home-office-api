package com.homeoffice.api.service;

import com.homeoffice.api.model.Company;
import com.homeoffice.api.web.form.CompanyForm;
import com.homeoffice.api.web.form.CompanyFormAssociate;

public interface CompanyService {

	Company save(CompanyForm companyForm);

	Company associateSectors(CompanyFormAssociate companyFormAssociate);
}
