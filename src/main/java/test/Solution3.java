//SELECT H.BUYER_ID, SUM(P.PRICE)
//        FROM house H
//        JOIN price P
//        ON H.HOUSE_ID = P.HOUSE_ID
//        GROUP BY H.BUYER_ID
//        HAVING COUNT(H.BUYER_ID) > 1 AND SUM(P.PRICE) >= 100
//        ORDER BY H.BUYER_ID;