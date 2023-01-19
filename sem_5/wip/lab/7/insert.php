<html>
<head>
</head>
<body>
    <?php
        $name=$_POST['name'];
        $emp_id=$_POST['emp_id'];
        $exp=$_POST['exp'];
        $con=mysqli_connect("localhost","root","");
        if(!($con))
        {
            die("error in connecting to DB");
        }
        else
        {
            print "<i style='color:green'>connection successfull</i><br />";
        }
        $db=mysqli_select_db($con,"userinfo");
        $query="insert into user_detail values('$name',$emp_id,$exp)";
        mysqli_query($con,$query);
        $result=mysqli_query($con,"select * from user_detail");
        $rows=mysqli_num_rows($result);
        echo "<i style='color:blue'>num of rows inserted into the user_detail table are $rows</i>";
        echo "<table border='1'><tr><th>Name</th><th>emp_id</th><th>exp</th></tr>";
        for($row=1;$row<=$rows;$row++)
        {
            $rowv=mysqli_fetch_array($result,MYSQLI_ASSOC);
            echo "<tr><td>".$rowv['name']."</td>";
            echo "<td>".$rowv['emp_id']."</td></tr>";
            echo "<td>".$rowv['exp']."</td></tr>";
        }
        echo "</table>";
        mysqli_close($con);
    ?>
    <h4>Enter user name to be searched</h4>
    <form action="http://localhost:2123/TEST/search.php" method="post">
        Enter employee id to be searched:<input type="text" name="emp_id"/>
        <input type="submit" value="Search"/>
        <input type="reset" value="reset"/>
    </form>
</body>
</html>