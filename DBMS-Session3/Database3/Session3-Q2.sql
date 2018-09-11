USE store_front;

#Assignment2
/*Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.*/
SELECT pcr.product_id,COUNT(pcr.product_id),p.name
FROM Product_Category_Relation pcr,Product p
WHERE pcr.product_id=p.id
GROUP BY pcr.product_id
HAVING COUNT(pcr.product_id)>1;

#Display Count of products as per below price range:
SELECT '0-100' AS rangeInRs,COUNT(*) AS COUNT FROM product
WHERE price BETWEEN 0 AND 100
UNION
SELECT '101-500' AS rangeInRs,COUNT(*) AS COUNT FROM product
WHERE price BETWEEN 101 AND 500
UNION
SELECT 'Above 500' AS rangeInRs,COUNT(*) AS COUNT FROM product
WHERE price >500;

#Display the Categories along with number of products under each category.
SELECT c.id,c.name,COUNT(*)
FROM Category c
INNER JOIN Product_Category_Relation pcr ON c.id=pcr.category_id
GROUP BY pcr.category_id;

