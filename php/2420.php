<?php
echo(__FILE__);
echo(dirname(__FILE__));
echo("\n");
echo(__DIR__);
echo("\n");
echo(dirname(__DIR__));
echo("\n");
echo(dirname(dirname(__DIR__)));
echo("\n");
while(fscanf(STDIN, "%d",$a)==1&&$a>=0)
{
	$base_time = strtotime("2000-01-01");
	$new_time = strtotime("+".$a."days",$base_time);
	echo date("Y-m-d l",$new_time)."\n";
}