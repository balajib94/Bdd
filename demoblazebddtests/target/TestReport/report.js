$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/DemoOnlineShopTest.feature");
formatter.feature({
  "name": "This Feature is to validate if the user is able to place an order in Demoblaze",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Launching the Browser",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the browser is launched",
  "keyword": "Given "
});
formatter.match({
  "location": "Uisteps.launchBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Adding Laptops and Placing an order as a guest user",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is on home page",
  "keyword": "Given "
});
formatter.match({
  "location": "Uisteps.openApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user searches for \u0027Laptops\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "Uisteps.searchCategory(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds the given products",
  "rows": [
    {
      "cells": [
        "Sony vaio i5"
      ]
    },
    {
      "cells": [
        "Dell i7 8gb"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Uisteps.addProduct(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user navigates to cart",
  "keyword": "And "
});
formatter.match({
  "location": "Uisteps.navigateToCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user deletes the product from cart",
  "rows": [
    {
      "cells": [
        "Dell i7 8gb"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Uisteps.deleteProduct(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on Place Order",
  "rows": [
    {
      "cells": [
        "Name",
        "TestUser"
      ]
    },
    {
      "cells": [
        "Country",
        "India"
      ]
    },
    {
      "cells": [
        "City",
        "Chennai"
      ]
    },
    {
      "cells": [
        "Credit card",
        "5231XXXXXXXXX123"
      ]
    },
    {
      "cells": [
        "Month",
        "12"
      ]
    },
    {
      "cells": [
        "Year",
        "2022"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Uisteps.clickPlaceOrder(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the purchase id should be generated",
  "keyword": "Then "
});
formatter.match({
  "location": "Uisteps.assertPurchaseId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the purchase amount should match with expected value",
  "keyword": "And "
});
formatter.match({
  "location": "Uisteps.assertPurchaseAmount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on OK",
  "keyword": "And "
});
formatter.match({
  "location": "Uisteps.clickOnOK()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/DemoPetStoreTest.feature");
formatter.feature({
  "name": "This Feature is to validate the demo pet store APIs",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Get the available pets",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "get all the Pets by status",
  "keyword": "Given "
});
formatter.match({
  "location": "PetStoreSteps.getPetByStatus()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user adds a new Pet",
  "keyword": "When "
});
formatter.match({
  "location": "PetStoreSteps.addNewPet()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});