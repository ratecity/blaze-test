var assert = require('assert');
var expect = require('chai').expect;

describe.only('Widgets', function() {
  describe('Home Loans', function () {
    describe('Mrec Single', function () {
      it('Should display a go to site button', function () {
        browser.url('http://www.ratecity.com.au/widgets/moneysaver/mrec-single/home-loans');
        expect(browser.getText('button.gotosite').length).to.be.at.least(1)
      });
    })

    describe('Mrec Multi', function () {
      it('Should display multiple go to site buttons', function () {
        browser.url('http://www.ratecity.com.au/widgets/moneysaver/mrec-multi/home-loans');
        expect(browser.getText('.product-title').length).to.be.at.least(2)
      });
    })
  })

});
