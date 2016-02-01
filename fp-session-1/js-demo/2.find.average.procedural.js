var request = require('request');


function calculateAverage(arr){
    var total = 0;
    for(var i = 0; i < arr.length ; i++ ){
        total = total + arr[i];
    }

    return total/arr.length;
}




function calculateAveragePrice(carrot_prices, field){
    // extract an array of Min price
    var prices = [];
    for(var i = 0 ; i < carrot_prices.length; i++ ){
        prices.push(parseInt(carrot_prices[i][field]));
    }

    return calculateAverage(prices);
}




function getCarrotRecords(data){
    var carrotRecords = [];

    for(var i = 0; i < data.length; i++){
        if(data[i].commodity == 'Carrot'){
            carrotRecords.push(data[i])
        }
    }
    return carrotRecords;
}

function printCarrotData(data){

    var price_data = JSON.parse(data);

    // get all carrot data
    // look through the array stored in the "records" field
    var carrot_prices = getCarrotRecords(price_data["records"]);

    // get Min Price
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
