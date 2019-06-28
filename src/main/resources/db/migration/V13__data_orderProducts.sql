insert into order_products (order_id, product_id, quantity, price, position)
values (20, 1, 20, '2.50', 1),
       (20, 2, 11, '3.25', 2),
       (20, 3, 3, '1.11', 3);

update orders set total_price=(20*2.50)+(11*3.25)+(3*1.11) where id=20;