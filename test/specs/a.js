var assert = require('assert');

describe('RateCity website', function() {
    it('should have the right title - the fancy generator way', function () {
        browser.url('http://www.ratecity.com.au');
        var title = browser.getTitle();
        assert.equal(title, 'Interest Rates Comparison, Financial News & Resources | Compare & Save @ RateCity');
    });

    it('should have the right title - the fancy generator way', function () {
        browser.url('http://www.ratecity.com.au/home-loans/mortgage-rates');
        var title = browser.getTitle();
        // assert.equal(title, 'Interest Rates Comparison, Financial News & Resources | Compare & Save @ RateCity');
        browser.getText('td.productName', function(text) {
          console.log(text);
        })
    });
});
