$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test\\resources\\HomePage.feature");
formatter.feature({
  "id": "homepage-objects",
  "description": "As a Customer\r\nI want to explore all the products and info \r\nSo that I can sign up for the best package",
  "name": "HomePage Objects",
  "keyword": "Feature",
  "line": 1
});
formatter.scenarioOutline({
  "id": "homepage-objects;home-page-products",
  "tags": [
    {
      "name": "@Smoke",
      "line": 6
    }
  ],
  "description": "",
  "name": "Home Page products",
  "keyword": "Scenario Outline",
  "line": 7,
  "type": "scenario_outline"
});
formatter.step({
  "name": "I open the home page",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "I explore the \"\u003cproducts\u003e\"",
  "keyword": "When ",
  "line": 11,
  "rows": [
    {
      "cells": [
        "HEALTH INSURANCE",
        "OTHER INSURANCE",
        "BETTER HEALTH"
      ],
      "line": 12
    },
    {
      "cells": [
        "Singles",
        "Pet Insurance",
        "Information \u0026 advice"
      ],
      "line": 13
    },
    {
      "cells": [
        "Couples",
        "Travel Insurance",
        "Better health guides"
      ],
      "line": 14
    },
    {
      "cells": [
        "Families",
        "Life Insurance",
        "Get Active"
      ],
      "line": 15
    }
  ]
});
formatter.step({
  "name": "I should see all the required info",
  "keyword": "Then ",
  "line": 17
});
formatter.step({
  "name": "I should be able to view detials about packages",
  "keyword": "And ",
  "line": 19
});
formatter.examples({
  "id": "homepage-objects;home-page-products;list-of-products",
  "description": "",
  "name": "list of products",
  "keyword": "Examples",
  "line": 22,
  "rows": [
    {
      "id": "homepage-objects;home-page-products;list-of-products;1",
      "cells": [
        "products"
      ],
      "line": 23
    },
    {
      "id": "homepage-objects;home-page-products;list-of-products;2",
      "cells": [
        "HEALTH INSURANCE"
      ],
      "line": 24
    },
    {
      "id": "homepage-objects;home-page-products;list-of-products;3",
      "cells": [
        "OTHER INSURANCE"
      ],
      "line": 25
    },
    {
      "id": "homepage-objects;home-page-products;list-of-products;4",
      "cells": [
        "BETTER HEALTH"
      ],
      "line": 26
    }
  ]
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
  "line": 24,
  "type": "scenario"
});
formatter.step({
  "name": "I open the home page",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "I explore the \"HEALTH INSURANCE\"",
  "keyword": "When ",
  "line": 11,
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
      "line": 12
    },
    {
      "cells": [
        "Singles",
        "Pet Insurance",
        "Information \u0026 advice"
      ],
      "line": 13
    },
    {
      "cells": [
        "Couples",
        "Travel Insurance",
        "Better health guides"
      ],
      "line": 14
    },
    {
      "cells": [
        "Families",
        "Life Insurance",
        "Get Active"
      ],
      "line": 15
    }
  ]
});
formatter.step({
  "name": "I should see all the required info",
  "keyword": "Then ",
  "line": 17
});
formatter.step({
  "name": "I should be able to view detials about packages",
  "keyword": "And ",
  "line": 19
});
formatter.match({
  "location": "testHomePage.I_open_the_home_page()"
});
formatter.result({
  "duration": 122913387,
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
  "duration": 2535239,
  "status": "passed"
});
formatter.match({
  "location": "testHomePage.I_should_see_all_the_required_info()"
});
formatter.result({
  "duration": 21581,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
  "line": 25,
  "type": "scenario"
});
formatter.step({
  "name": "I open the home page",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "I explore the \"OTHER INSURANCE\"",
  "keyword": "When ",
  "line": 11,
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
      "line": 12
    },
    {
      "cells": [
        "Singles",
        "Pet Insurance",
        "Information \u0026 advice"
      ],
      "line": 13
    },
    {
      "cells": [
        "Couples",
        "Travel Insurance",
        "Better health guides"
      ],
      "line": 14
    },
    {
      "cells": [
        "Families",
        "Life Insurance",
        "Get Active"
      ],
      "line": 15
    }
  ]
});
formatter.step({
  "name": "I should see all the required info",
  "keyword": "Then ",
  "line": 17
});
formatter.step({
  "name": "I should be able to view detials about packages",
  "keyword": "And ",
  "line": 19
});
formatter.match({
  "location": "testHomePage.I_open_the_home_page()"
});
formatter.result({
  "duration": 18582599,
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
  "duration": 147924,
  "status": "passed"
});
formatter.match({
  "location": "testHomePage.I_should_see_all_the_required_info()"
});
formatter.result({
  "duration": 11523,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
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
  "line": 26,
  "type": "scenario"
});
formatter.step({
  "name": "I open the home page",
  "keyword": "Given ",
  "line": 9
});
formatter.step({
  "name": "I explore the \"BETTER HEALTH\"",
  "keyword": "When ",
  "line": 11,
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
      "line": 12
    },
    {
      "cells": [
        "Singles",
        "Pet Insurance",
        "Information \u0026 advice"
      ],
      "line": 13
    },
    {
      "cells": [
        "Couples",
        "Travel Insurance",
        "Better health guides"
      ],
      "line": 14
    },
    {
      "cells": [
        "Families",
        "Life Insurance",
        "Get Active"
      ],
      "line": 15
    }
  ]
});
formatter.step({
  "name": "I should see all the required info",
  "keyword": "Then ",
  "line": 17
});
formatter.step({
  "name": "I should be able to view detials about packages",
  "keyword": "And ",
  "line": 19
});
formatter.match({
  "location": "testHomePage.I_open_the_home_page()"
});
formatter.result({
  "duration": 5902077,
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
  "duration": 209454,
  "status": "passed"
});
formatter.match({
  "location": "testHomePage.I_should_see_all_the_required_info()"
});
formatter.result({
  "duration": 12921,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});