Script to read fields from a JSON response and set it as a collection variable that can be used in the subsequent steps:
var jsonData = JSON.parse(responseBody);
pm.collectionVariables.set("quoteId", jsonData.data.quoteId);

Script to read fields from a SOAP response and set it as a collection variable that can be used in the subsequent steps:
var parseString = require('xml2js').parseString;
var stripPrefix = require('xml2js').processors.stripPrefix;

parseString(responseBody, { tagNameProcessors: [ stripPrefix ] }, function(err, js) {
    if(err) throw err;

    var companysQuoteNumber = js.Envelope.Body[0].rateResponse[0].response[0].HomePolicyQuoteInqRs[0].PersPolicy[0].QuoteInfo[0].CompanysQuoteNumber[0];

    pm.collectionVariables.set("companysQuoteNumber", companysQuoteNumber);
});

(A simpler way is to use xml2json but it will not remove the namespaces from the json and if the namespaces are dynamically changing, it can be a problem)
