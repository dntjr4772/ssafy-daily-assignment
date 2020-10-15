use starwarsdb;
-- 1. 전 스타워즈 시리즈의 상영년도, 에피소드이름, 배역, 출연배우 이름
select openyear,episodename,charactername, realname
from starwars s,casting a,characters c
where s.EPISODEID=a.EPISODEID and a.characterid=c.characterid;

-- 2. 에피소드 4에 출연한 배우는 모두 몇 명인지 구하는 쿼리
select count(realname)
from starwars s,casting a
where s.EPISODEID=a.EPISODEID;

-- 3. 각 배우 별 출연횟수를 조회하는 쿼리
select realname, count(realname)
from casting
group by realname;
 
-- 4. 에피소드별 이름과 출연자 수
select episodename, count(realname)
from starwars s,casting a
where s.EPISODEID=a.EPISODEID
group by s.EPISODEID;

-- 5. 출연자수가 10명 이상인 에피소드의 이름과 출연자수
select episodename, count(realname)
from starwars s,casting a
where s.EPISODEID=a.EPISODEID
group by s.EPISODEID
having count(realname)>=10;

-- 6.제국의 역습에 등장하는 배우 이름
select realname
from casting
where EPISODEID=5;

-- 7. '아미달라 여왕'이 등장했던 에피소드 id, 에피소드 이름과 상영연도
select s.episodeid,episodename,openyear
from starwars s join casting a join characters c
on s.EPISODEID=a.EPISODEID and a.characterid=c.characterid
where c.charactername='아미달라 여왕';
    
-- 8. 해리슨 포드가 등장했던 에피소드의 id와 에피소드 이름
select s.episodeid,episodename
from starwars s join casting a
on s.EPISODEID=a.EPISODEID
where a.realname='해리슨 포드';

-- 9. 각 에피소드의 id와 출연한 인원 수
select s.episodeid,count(*)
from starwars s join casting a
on s.EPISODEID=a.EPISODEID
group by a.EPISODEID;

-- 10. 모든 에피소드 출연한 인원 수 중 가장 많은 인원수는



-- 11. 가장 많은 인원이 출연한 에피소드의 id와 인원 수
select s.episodeid,count(*)
from starwars s join casting a
on s.EPISODEID=a.EPISODEID
group by a.EPISODEID
order by count(*) desc
limit 1;

-- 12. 가장 많은 인원이 출연한 에피소드 id, 그 에피소드에 츌연한 배우명
select s.episodeid,realname
from starwars s join casting a
on s.EPISODEID=a.EPISODEID
where s.episodeid=(select s.episodeid
					from starwars s join casting a
					on s.EPISODEID=a.EPISODEID
					group by a.EPISODEID
					order by count(*) desc
					limit 1
				   );

-- 13. 모든 시리즈에 총 출연했던 횟수가 가장 많은 배우 TOP 5의 이름과 횟수를 조회
select realname,count(*)
from casting
group by characterid
order by count(*) desc
limit 5;

-- 14. 모든 시리즈에 총 출연했던 횟수가 가장 많은 배우 TOP 6-10의 이름과 횟수를 조회
select realname,count(*)
from casting
group by characterid
order by count(*) desc
limit 5,5;
 
-- 15. 캐릭터에 role값을 부여하여 update(롤의 이름을 활용한다.)
-- 1,4,13 제다이
-- 2,9 반란군
-- 5,12,18 시스




-- 16. 캐릭터와 마스터 연결하여  update
-- 아나킨 스카이워커 13 		오비완 케노비 4
-- 루크 스카이워커 1		오비완 케노비 4
-- 마스터 윈두 	20		요다 11
-- 듀크백작 	21			요다	11
-- 다스 베이더		5		다스 시디어스 12
-- 다스 몰		18		다스 시디어스 12
-- 오비완 캐노비 4			콰이곤 진 14
-- 콰이콘 진		14		듀크백작 21
update characters
set masterid=13
where charactername="아나킨 스카이워커";


-- 17. 마스터 역할의 배역이름

                            
                            
-- 18. 오비완 케노비의 제자는



-- 19. 오비완 케노비의 제자는 몇명 

                    
-- 20. 모든 배역과 해당 배역의 마스터 역할배역의 이름을 함께 조회(단, 마스터가 없는 배역도 포함)



-- 21. 에피소드 3의 에피소드 이름과 배역 ,출연배우 이름, 마스터 이름,이메일 

  
-- 22. 에피소드 5와 에피소드 2에 모두 출연한 배우는





-- 23. 다음 문장은 스타워즈 에피소드 2에 출연한 배우들의 극중 이름, 역할을 조회하는 쿼리이다.
-- SELECT c.charactername, b.realname, d.rolename
--   FROM starwars a, 
--        casting b, 
--        characters c, 
--        roles d
--  WHERE a.episodeid = b.episodeid
--    AND b.characterid = c.characterid
--    AND c.roleid = d.roleid
--    AND a.episodeid = 2;

-- 이 쿼리에는 한 가지 문제점이 있는데, 무엇을 말하는 것일까?

-- -------------------------------------------------------------------------------------------------
-- CHARACTERS 테이블에 저장되어 있는 각 배역들의 정보에는 ROLEID 값이 없는 배역이 존재한다. 따라서 위 쿼리의 경우
-- ROLEID 값이 없는 배역은 조회되지 않는다는 문제점이 존재한다. 
-- ROLEID 값이 없는 배역도 조회가 될 수 있도록 외부조인을 사용해야 한다. 



   