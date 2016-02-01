var request = require('request');

function calculateAveragePrice(carrot_prices, field){
    var total = carrot_prices.reduce(function(prevValue,currentValue){
        return prevValue + parseInt(currentValue[field]);
    },0);

    return total/ carrot_prices.length;
}

function printCarrotData(data){

    var price_data = JSON.parse(data);

    // get all carrot data
    // look through the array stored in the "records" field
    var carrot_prices =  price_data["records"].filter(function(value){
        return value.commodity == 'Cotton';
    });


    var min_price = calculateAveragePrice(carrot_prices,"min_price");

    // get Max Average
    var max_price = calculateAveragePrice(carrot_prices,"max_price");

    console.log("MIN AVG : " + min_price);
    console.log("MAX AVG : " + max_price);


}

function showCarrotData(){
    request('https://data.gov.in/api/datastore/resource.json?resource_id=9ef84268-d588-465a-a308-a864a43d0070&api-key=283f9ef8c8a51d2d55b3a84766823aa2', function (error, response, body) {
        if (!error && response.statusCode == 200) {
            printCarrotData(body);
        }
    });

}

// TASK : Find out average min, max price  of carrots in India
showCarrotData();
