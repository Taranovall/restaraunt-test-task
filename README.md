Available commands:
- /help - prints all available commands in console
- /make_order - using this command you can make an order
- /add_orders - prints in console all made orders

First query:\
SELECT country.name\
FROM City city\
JOIN Country country ON country.countryID = city.countryID\
GROUP BY country.name\
HAVING sum(city.population) > 400\
Second query:\
SELECT country.name\
FROM Building building\
JOIN City city on city.CityID = building.CityID\
RIGHT JOIN Country country on country.CountryID = city.CountryID\
GROUP BY country.name\
HAVING count(building.name) = 0