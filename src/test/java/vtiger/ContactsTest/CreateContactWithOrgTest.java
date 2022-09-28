package vtiger.ContactsTest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInformationPage;
import ObjectRepository.OrganizationPage;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
@Listeners(vtiger.GenericUtility.ListenersPractice.class)








public class CreateContactWithOrgTest extends BaseClass {
	@Test( retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void CreateContactWithOrgtest() throws EncryptedDocumentException, IOException {
		String ORGNAME = eUtil.getDataFromExcel("sheet2", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.getDataFromExcel("sheet2", 4, 2);
		
		HomePage hp=new HomePage(driver);
		hp.ClickonOrgLink();
		Reporter.log("organization link clicked",true);
		
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateNewOrgImg();
		Reporter.log("create org look up img is clicked",true);
		
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.CreateNewOrg(ORGNAME);
		Reporter.log("New Organization created",true);
		
		
		
		
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String OrgHeader = oip.getOrgHeader();
		System.out.println(OrgHeader);
		Assert.assertEquals(OrgHeader.contains(ORGNAME), true);
		
		
		
		hp.ClickOnContactsLink();
		ContactsPage cp=new ContactsPage(driver);
		cp.ClickOnCreateContact();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.CreateNewContact(LASTNAME, ORGNAME,driver);
		Reporter.log("created contact with organization", true);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String ContactHeader = cip.GetContactHeader();
		System.out.println(ContactHeader);
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
					
				
			
			
		}
		
		
				
		
		
	}


