<%@ page contentType = "text/html; charset=EUC-KR" import= "java.util.*, java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<title>Test Page</title>

<script type="text/javascript">
function doChange(srcE, targetId){
    var val = srcE.options[srcE.selectedIndex].value;
    var targetE = document.getElementById(targetId);
    removeAll(targetE);

    if(val == 'languages'){
        addOption('C++', targetE);
        addOption('Java', targetE);
        addOption('Scheme', targetE);
    }
    else if(val == 'tools'){
        addOption('Visual Studio', targetE);
        addOption('Netbeans', targetE);
        addOption('Eclipse', targetE);
    }
}

function addOption(value, e){
    var o = new Option(value);
    try{
        e.add(o);
    }catch(ee){
        e.add(o, null);
    }
}

function removeAll(e){
    for(var i = 0, limit = e.options.length; i < limit - 1; ++i){
        e.remove(1);
    }
}
</script>

</head>
<body>
<form action="#">
    <select name="selOne" id="selOne" onchange="doChange(this, 'selTwo')">
        <option value="default">---Select Something---</option>
        <option value="languages">¾ð¾î</option>
        <option value="tools">Åø</option>
    </select>
    <select name="selTwo" id="selTwo">
        <option value="default">---Select Something---</option>
    </select>
</form>
</body>
</html>