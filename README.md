# supermarket-pricing

The problem domain is something seemingly simple: pricing goods at
supermarkets.
 
Some things in supermarkets have simple prices: this can of beans
costs $0.65. Other things have more complex prices. For example:
•     three for a dollar (so what’s the price if I buy 4, or 5?)
•     $1.99/pound (so what does 4 ounces cost?)
•     buy two, get one free (so does the third item have a price?)

# model : 
it contains the different object model to use in the application:
 - Discount : the discount to apply
 - Product : the product whit name , reference and price
 - Price: price of a product in Unit price or weight price
 - Shop : the product with the quantity
 - Quantity : the quantity of prduct to buy in Unit Quantity or Weight Quantity
 - WeightUnit : enum with values is Pound or Ounce

# controller :
PricingService: the service pricingService allows to calculate the total price of a shop with discount or without discount

# main class:
 SuperMarketPricingMain : it contains the main method to test the service pricingService for example with the following arguments (-product p1 ref1 1.99 POUND -discount p1 ref1 1.0  3.0 UNIT -shop p2 ref1 48.0 OUNCE)
 
# Unit test :
 PricingServiceTest : it contains some unit tests of the service pricingService.

