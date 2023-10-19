package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto36;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MyDao5 {


    @Select("""
            <script>
                SELECT COUNT(*)
                FROM customers  
            
                <if test='country !=null'>
                WHERE country = #{country}
                </if>
            </script>
            """)
    String select1(String country);



    @Select("""
        <script>
            SELECT CustomerName FROM customers
            
            <if test='num ==10'>
                -- 수가 10이다.
            </if>
            <if test='num != 10'>
                -- 수가 10이 아니다       
            </if>
            <if test='num >10' >
                -- 수가 10보다 크다.
            </if>
            <if test='num lt 10' >
                -- 수가 10보다 작다.
            </if>
            <if test= 'num >= 10'>
                -- 수가 10보다 크거나 같다
            </if>
            <if test = 'num lte 10'>
                -- 수가 10보다 작거나 같다
            </if>
        </script>
        """)

    // Controller 31에서 10이 아닌 9를 넣으면 --수가 10이 아니라는 메시지가 콘솔창에 뜸
    List<String> select2(Integer num); //if test에서는 #{}말고 그냥 num쓰면 됨



    @Select("""
            <script>
                SELECT customerName, contactName
                FROM customers
                <if test = 'code == 1'>
                  -- WHERE customerName LIKE CONCAT('%', #{k}, '%')
                    WHERE customerName
                    
                </if>
                <if test = 'code == 2'>
                    -- WHERE contactName LIKE CONCAT('%', #{k}, '%')
                    WHERE contactName
                </if>
                    LIKE #{k}
            </script>
            """)
    List<Map<String, Objects>> select3(Integer code, String k);



    @Select("""
            <script>
                SELECT COUNT(*) FROM customers
                WHERE 
                <if test='i gt 10'>
                    -- i가 10보다 큼
                </if>
                <if test='i lt 10'>
                    -- i가 10보다 작음
                </if>
                <if test='(i gt 0) and (i lt 100)'>
                    -- i가 0보다 크고 100보다 작음
                </if>
            </script>
            """)
    String select4(int i);


    @Select("""
            SELECT *
            FROM customers
            WHERE CustomerName > 'a';
            """)
    String select5();



    @Select("""
            <script>
                <![CDATA[
                SELECT  *
                FROM customers
                WHERE CustomerName < 'a';
                ]]>
            </script>
            """)
    String select6();


    @Select("""
        <script>
        SELECT *
        FROM customers
        WHERE 
            Country IN(
            
            <foreach collection="args" 
                    item="elem"
                    separator=", "
                    open="("
                    close=")"
                    > 
                #{elem}
            </foreach>
            )
        </script>    
        """)
    String select7(List args);


    @Select("""
            
            <script>
            SELECT *
            FROM customers
            WHERE 
                <trim prefix="WHERE" prefixOverrides="OR">
                <foreach collection="args" item="elem">
                        OR country= #{elem} 
                </foreach>
                </trim>
            </script>            
            """)
    String select8(List args);
    // prefix="WHERE" 이게 있을때만 붙이겠다.
    // prefixOverrides="OR" 앞에는 OR생략



    //bind 이용하면 키워드에 "%"+ "com" + "%" 안넣고 "com"이라고만 넣어도 됨
    // 안쪽에 '' 쓰면 밖엔 "" 써야함, 반대여도 마찬가지. attribute는 '', "" 상관없음
    //
    @Select("""
        <script>
        <bind name="alterKeyword" value="'%' + keyword + '%'" />
        SELECT *
        FROM customers
        WHERE CustomerName LIKE #{alterKeyword}
        </script>
        """)
    String select9(String keyword);



    // 메뉴얼에 따르면 String은 작은 따옴표 쓸수 있음
    // 싱글 캐릭터는 작은따옴표 써야함. 'q'는 스트링인가? 캐릭터인가? > 캐릭터로 해석됨
    // 그냥 'q'도 작은따옴표 말고 "q" 큰따옴표 쓰기
    @Select("""
            <script>
                SELECT * FROM customers
                WHERE
                    <if test="word == 'abc'">
                        -- word는 abc
                    </if>
                    <if test='word == "def"'>
                        -- word는 def
                    </if>
                    <if test="word == 'q'">
                        -- word는 q
                    </if>
                    <if test='word == "k"'>
                        -- word는 k
                    </if>
            </script>
            """)
    String select10(String word);


    @Select("""
            SELECT DISTINCT city FROM customers
            WHERE city IS NOT NULL AND city !=''
            ORDER BY 1
            """)
    List<String> listCustomerCity();


    @Select("""
            SELECT DISTINCT Country
            FROM customers
            WHERE country IS NOT NULL AND Country !=''
            ORDER BY 1
          
            """)
    List<String> listCustomerCountry();


    @Select("""
            <script>
            SELECT  CustomerName name, City, Country
            FROM customers
            <trim prefix="WHERE">
                <if test='type == "1"'>
                    city
                    <foreach collection="city" item="elem" open=" IN ("
                        separator="," close=")">
                        #{elem}
                    </foreach>
                </if>
                
                <if test= 'type == "2"'>
                    country
                    <foreach collection="country" item="elem" open = "IN ("
                        separator="," close=")">
                        #{elem}
                        </foreach>
                </if>
                </trim>
            ORDER BY name, country, city 
                </script>
            """)
    List<Map<String, Object>> listCustomer(MyDto36 dto);
}




