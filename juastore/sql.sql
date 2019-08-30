create view product_inventory_view as select
product.product_code as product_code,
product.product_name as product_name,
product.product_price as product_price,
(select sum(amount) from inventory where inventory_state ='in')as inventory_amount,



select (select sum(inventory_amount) from inventory where product_code='op0017' and inventory_state='in')-
    (select sum(inventory_amount) from inventory where product_code='op0017' and inventory_state='out') 
    as amount from inventory where product_code='op0017';
    
select (select sum(inventory_amount) from inventory where product_code='op0017' and inventory_state='in')
    as amount from inventory where product_code='op0017';
    
    select(select sum(inventory_amount) from inventory where product_code='op0017' and inventory_state='out') 
    as amount from inventory where product_code='op0017';