var assert = require('assert');
var expect = require('chai').expect;

describe('Whitelabels', function() {
  describe('Moneysaver', function() {
    describe('Superannuation', function () {
      it('Should display some products', function () {
        browser.url('http://www.ratecity.com.au/whitelabels/moneysaver/superannuation/overview');
        browser.pause(4000);
        expect(browser.getText('td.productName').length).to.at.least(10);
      });
    })
  })
  describe('Default', function() {
    describe('Home Loans', function () {
      it('Should display some products', function () {
        browser.url('http://www.ratecity.com.au/whitelabels/default/home-loans');
        browser.pause(4000);
        expect(browser.getText('td.productName').length).to.at.least(10);
      });
    })
  })
});
