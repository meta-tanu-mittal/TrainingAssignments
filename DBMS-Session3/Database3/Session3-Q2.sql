USE store_front;

#Assignment2
/*Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.*/
SELECT pcr.product_id,COUNT(pcr.product_id),p.name
FROM Product_Category_Relation pcr,Product p
WHERE pcr.product_id=p.id
GROUP BY pcr.product_id
HAVING COUNT(pcr.product_id)>1;

#Display Count of products as per below price range:
SELECT p.RangeOfPrice,COUNT(*)
FROM (SELECT CASE
WHEN PRICE BETWEEN 0 AND 500 THEN '0-500'
WHEN PRICE BETWEEN 501 AND 1000 THEN '501-1000'
ELSE 'Above 1000'
END AS RangeOfPrice
FROM Product )p
GROUP BY p.RangeOfPrice;

#Display the Categories along with number of products under each category.
SELECT c.id,c.name,COUNT(*)
FROM Category c
INNER JOIN Product_Category_Relation pcr
ON c.id=pcr.category_id
GROUP BY pcr.category_id;

