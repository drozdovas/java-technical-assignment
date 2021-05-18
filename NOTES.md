# Notes

My main objective was to separate the logic from the models. At first I thought it would be great to have a separate discount calculator, but it provided a bit of an overhead and would take more time to implement. That's why I decided to all the discount logic in the PriceCalculator.

Now that I look at the code, I should have simplified further by removing ItemBy... and just use Item with an extra added enum field - Metric(KG, UNIT). 

Just as easily I could have then added a grouping enum.
