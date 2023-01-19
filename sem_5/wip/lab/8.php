<?php
    date_default_timezone_set("Asia/Calcutta");
    $current_time = date("H:i:s d/m/Y");
    $time_to_expire = time() + 60*60;
    setcookie("Last_Accessed",$current_time,$time_to_expire);
    if(isset($_COOKIE["Last_Accessed"]))
    {
        $last_visit = $_COOKIE["Last_Accessed"];
        print "<br><br>Last Accessed : $last_visit";
    }
    else
    {
        print "<br><br>This page has been visited for the first time.";
    }
    print "<br><br>Current Time: <b>$current_time</b>";
    print "<br><br>Thank you";
?>