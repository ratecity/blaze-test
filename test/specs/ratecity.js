var assert = require('assert');
var expect = require('chai').expect;

describe('RateCity website', function() {
  describe('Homepage', function() {
    it('Should have the correct page title', function () {
        browser.url('http://www.ratecity.com.au');
        assert.equal(browser.getTitle(), 'Interest Rates Comparison, Financial News & Resources | Compare & Save @ RateCity');
    });
  })

  describe('Home Loans', function () {
    describe('Search Page', function () {
      it('Should display at least 15 products by default', function () {
        browser.url('http://www.ratecity.com.au/home-loans/mortgage-rates');
        expect(browser.getText('td.productName').length).to.at.least(15)
      });

      it('Should change the number of results by clicking page size', function () {
        browser.click('=50');
        browser.pause(3000)
        expect(browser.getText('td.productName').length).to.eq(50)
      })
    })

    describe('Product Page', function () {
      it('Should render the name of the product in the breadcrumbs', function () {
        browser.url('http://www.ratecity.com.au/home-loans/ubank/value-offer-20-deposit-minimum');
        expect(browser.getText('ol.breadcrumb > li.active')).to.eq('Value Offer - 20% Deposit Minimum')
      })
    })

    describe('Company Page', function () {
      it('Should render company products', function () {
        browser.click('=UBank')
        expect(browser.getText('td.productName').length).to.be.at.least(2)
      })
    })
  })

  describe('Credit Cards', function () {
    describe('Search Page', function () {
      it('Should render at least 10 products', function () {
        browser.url('http://www.ratecity.com.au/credit-cards/search');
        expect(browser.getText('td.product-name').length).to.be.at.least(10)
      })
    })

    describe('Product Page', function () {
      it('Should render the name of the product in the breadcrumbs', function () {
        browser.url('http://www.ratecity.com.au/credit-cards/anz/low-rate')
        expect(browser.getText('ol.breadcrumb > li.active')).to.eq('Low Rate')
      })
    })
  })

  describe('Savings accounts', function () {
    describe('Search Page', function () {
      it('Should render at least 10 products', function () {
        browser.url('http://www.ratecity.com.au/savings-accounts?utf8=%E2%9C%93&q%5Bamount%5D=5000&q%5Bterm%5D=60&q%5Baccount_type%5D=any&commit=Find+an+account');
        expect(browser.getText('td.description').length).to.be.at.least(10)
      })
    })

    describe('Product Page', function () {
      it('Should render the name of the product on the page', function () {
        browser.url('http://www.ratecity.com.au/savings-accounts/bank-australia/bonus-saver?q%5Bamount%5D=5000&q%5Bterm%5D=60&source=ratecity')
        expect(browser.getText('h1.product-title')).to.eq('Bonus Saver')
      })
    })
  })
});
