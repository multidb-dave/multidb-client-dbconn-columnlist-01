@ECHO OFF 
java -jar target/clientmdb-1.0-SNAPSHOT-jar-with-dependencies.jar .\data

@REM FOR /L %%X IN (0,1,2) DO (
@REM 	ECHO %%X
@REM 	java -jar target/clientmdb-1.0-SNAPSHOT-jar-with-dependencies.jar .\data
@REM )

