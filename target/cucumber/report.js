$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HomePage.feature");
formatter.feature({
  "id": "homepage-objects",
  "description": "As a Customer\r\nI want to explore all the products and info \r\nSo that I can sign up for the best package",
  "name": "HomePage Objects",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "homepage-objects;home-page-products;list-of-products;2",
  "tags": [
    {
      "name": "@Smoke",
      "line": 6
    }
  ],
  "description": "",
  "name": "Home Page products",
  "keyword": "Scenario Outline",
  "line": 19,
  "type": "scenario"
});
formatter.step({
  "name": "I open the home page",
  "keyword": "Given ",
  "line": 8
});
formatter.step({
  "name": "I explore the \"HEALTH INSURANCE\"",
  "keyword": "When ",
  "line": 9,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "HEALTH INSURANCE",
        "OTHER INSURANCE",
        "BETTER HEALTH"
      ],
      "line": 10
    },
    {
      "cells": [
        "Singles",
        "Pet Insurance",
        "Healthy recipes"
      ],
      "line": 11
    },
    {
      "cells": [
        "Couples",
        "Travel Insurance",
        "Better health guides"
      ],
      "line": 12
    },
    {
      "cells": [
        "Families",
        "Life Insurance",
        "Betterhealthguides"
      ],
      "line": 13
    }
  ]
});
formatter.step({
  "name": "I should see all the required package info",
  "keyword": "Then ",
  "line": 14
});
formatter.match({
  "location": "testHomePage.I_open_the_home_page()"
});
formatter.result({
  "duration": 133226220,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "HEALTH INSURANCE",
      "offset": 15
    }
  ],
  "location": "testHomePage.I_explore_the_products(String,DataTable)"
});
formatter.result({
  "duration": 150001537,
  "status": "passed"
});
formatter.match({
  "location": "testHomePage.I_should_see_all_the_required_info()"
});
formatter.result({
  "duration": 33943,
  "status": "passed"
});
formatter.scenario({
  "id": "homepage-objects;home-page-products;list-of-products;3",
  "tags": [
    {
      "name": "@Smoke",
      "line": 6
    }
  ],
  "description": "",
  "name": "Home Page products",
  "keyword": "Scenario Outline",
  "line": 20,
  "type": "scenario"
});
formatter.step({
  "name": "I open the home page",
  "keyword": "Given ",
  "line": 8
});
formatter.step({
  "name": "I explore the \"OTHER INSURANCE\"",
  "keyword": "When ",
  "line": 9,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "HEALTH INSURANCE",
        "OTHER INSURANCE",
        "BETTER HEALTH"
      ],
      "line": 10
    },
    {
      "cells": [
        "Singles",
        "Pet Insurance",
        "Healthy recipes"
      ],
      "line": 11
    },
    {
      "cells": [
        "Couples",
        "Travel Insurance",
        "Better health guides"
      ],
      "line": 12
    },
    {
      "cells": [
        "Families",
        "Life Insurance",
        "Betterhealthguides"
      ],
      "line": 13
    }
  ]
});
formatter.step({
  "name": "I should see all the required package info",
  "keyword": "Then ",
  "line": 14
});
formatter.match({
  "location": "testHomePage.I_open_the_home_page()"
});
formatter.result({
  "duration": 9301112,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "OTHER INSURANCE",
      "offset": 15
    }
  ],
  "location": "testHomePage.I_explore_the_products(String,DataTable)"
});
formatter.result({
  "duration": 123187444,
  "status": "passed"
});
formatter.match({
  "location": "testHomePage.I_should_see_all_the_required_info()"
});
formatter.result({
  "duration": 26400,
  "status": "passed"
});
formatter.scenario({
  "id": "homepage-objects;home-page-products;list-of-products;4",
  "tags": [
    {
      "name": "@Smoke",
      "line": 6
    }
  ],
  "description": "",
  "name": "Home Page products",
  "keyword": "Scenario Outline",
  "line": 21,
  "type": "scenario"
});
formatter.step({
  "name": "I open the home page",
  "keyword": "Given ",
  "line": 8
});
formatter.step({
  "name": "I explore the \"BETTER HEALTH\"",
  "keyword": "When ",
  "line": 9,
  "matchedColumns": [
    0
  ],
  "rows": [
    {
      "cells": [
        "HEALTH INSURANCE",
        "OTHER INSURANCE",
        "BETTER HEALTH"
      ],
      "line": 10
    },
    {
      "cells": [
        "Singles",
        "Pet Insurance",
        "Healthy recipes"
      ],
      "line": 11
    },
    {
      "cells": [
        "Couples",
        "Travel Insurance",
        "Better health guides"
      ],
      "line": 12
    },
    {
      "cells": [
        "Families",
        "Life Insurance",
        "Betterhealthguides"
      ],
      "line": 13
    }
  ]
});
formatter.step({
  "name": "I should see all the required package info",
  "keyword": "Then ",
  "line": 14
});
formatter.match({
  "location": "testHomePage.I_open_the_home_page()"
});
formatter.result({
  "duration": 8902528,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BETTER HEALTH",
      "offset": 15
    }
  ],
  "location": "testHomePage.I_explore_the_products(String,DataTable)"
});
formatter.result({
  "duration": 102108089,
  "status": "passed"
});
formatter.match({
  "location": "testHomePage.I_should_see_all_the_required_info()"
});
formatter.result({
  "duration": 26120,
  "status": "passed"
});
});